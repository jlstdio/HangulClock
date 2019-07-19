package com.leejoonhee.hangulclockforandroid;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.leejoonhee.hangulclockforandroid.Service.HelpActivity;
import com.leejoonhee.hangulclockforandroid.Service.SettingActivity;
import com.leejoonhee.hangulclockforandroid.Service.Weather.WeatherInfo;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
	DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

	DatabaseReference download = rootRef.child("downloads");
	DatabaseReference version = rootRef.child("version");
	DatabaseReference notice = rootRef.child("notice");

	TextView mversion;
	TextView mdownloads;
	TextView sentence;

	static SharedPreferences sets;

	static public String weathersaved = "No data";

	static TextView weathertext;

	static String data = "";

	TextView txtText;

	AdView mAdView;

	double RE = 6371.00877; // 지구 반경(km)
	double GRID = 5.0; // 격자 간격(km)
	double SLAT1 = 30.0; // 투영 위도1(degree)
	double SLAT2 = 60.0; // 투영 위도2(degree)
	double OLON = 126.0; // 기준점 경도(degree)
	double OLAT = 38.0; // 기준점 위도(degree)
	double XO = 43; // 기준점 X좌표(GRID)
	double YO = 136; // 기1준점 Y좌표(GRID)

	double longitude, latitude = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sentence = findViewById(R.id.sentence);

		sets = getSharedPreferences("usersets", Activity.MODE_PRIVATE); //MainActivity가 꺼져도 NewAppWidget에서 값을 받아 올 수 있도록 SharedPreference를 사용하였습니다
		sentence.setText(sets.getString("title", "설정이 필요합니다"));

		String str = sets.getString("title", "설정이필요합니다");

		weathersaved = sets.getString("weatherurl", "날씨 설정이 필요합니다");

		txtText = (TextView)findViewById(R.id.txtText);

		new ReceiveShortWeather().execute();

		if(str.equals("**weather**")){
			sentence.setText(data);
		}

		weathertext = (TextView)findViewById(R.id.weather);

		mversion = (TextView)findViewById(R.id.version);
		mdownloads = (TextView)findViewById(R.id.download);

		mAdView = (AdView) findViewById(R.id.adView);

		AdView adView = new AdView(this);
		adView.setAdSize(AdSize.BANNER);
		adView.setAdUnitId("ca-app-pub-8081631582008293/5576438546");


		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		boolean isWhiteListing = false;
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
			isWhiteListing = pm.isIgnoringBatteryOptimizations(getPackageName());
		}

		if(!isWhiteListing){
			AlertDialog.Builder setdialog = new AlertDialog.Builder(MainActivity.this);
			setdialog.setTitle("추가 설정이 필요합니다.")
					.setMessage("어플을 문제없이 사용하기 위해서는 해당 어플을 \"배터리 사용량 최적화\" 목록에서 \"제외\"해야 합니다. 설정화면으로 이동하시겠습니까?")
					.setPositiveButton("네", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							startActivity(new Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS));
						}
					})
					.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(MainActivity.this, "설정을 취소했습니다.", Toast.LENGTH_SHORT).show();
						}
					})
					.create()
					.show();
		}
		/*
			Intent intent = new Intent(this, PopupActivity.class);
			startActivity(intent);
		*/
	}
	
	public void setting(View v){
		startActivity(new Intent(this, SettingActivity.class));
	}
	
	public void help(View v){
		startActivity(new Intent(this, HelpActivity.class));
	}

	public void pc(View v){
		String url ="https://github.com/dsa28s/windows-hangul-clock";
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		startActivity(intent);
	}

	public void android(View v){
		String url ="https://github.com/neo81389/HangulClock";
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		startActivity(intent);
	}

	public void update(View v){
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.leejoonhee.hangulclockforandroid"));
		startActivity(intent);
	}

	@Override
	protected void onStart(){
		super.onStart();

		notice.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				String text = dataSnapshot.getValue(String.class);
				txtText.setText(text);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});

		download.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				String text = dataSnapshot.getValue(String.class);

				mdownloads.setText(text);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});

		version.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				String text = dataSnapshot.getValue(String.class);

				if(text.equals("3.1"))
					mversion.setText("현재 최신버전입니다");

				else
					mversion.setText("[업데이트하러가기]");
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});

	}

	public static class ReceiveShortWeather extends AsyncTask<URL, Integer, Long> {

		ArrayList<WeatherInfo> shortWeathers = new ArrayList<WeatherInfo>();

		protected Long doInBackground(URL... urls) {

			String url = sets.getString("weatherurl", "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159068000");

			OkHttpClient client = new OkHttpClient();

			Request request = new Request.Builder()
					.url(url)
					.build();

			Response response = null;

			try {
				response = client.newCall(request).execute();
				parseXML(response.body().string());
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}

		public void onPostExecute(Long result) {

			data = shortWeathers.get(0).getTemp() + "도 . " +
					shortWeathers.get(0).getWfKor() + " . 강수량 " +
					shortWeathers.get(0).getPop();

			weathertext.setText(data);
			weathersaved = data;
		}

		void parseXML(String xml) {
			try {
				String tagName = "";
				boolean onHour = false;
				boolean onDay = false;
				boolean onTem = false;
				boolean onWfKor = false;
				boolean onPop = false;
				boolean onEnd = false;
				boolean isItemTag1 = false;
				int i = 0;

				XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
				XmlPullParser parser = factory.newPullParser();

				parser.setInput(new StringReader(xml));

				int eventType = parser.getEventType();

				while (eventType != XmlPullParser.END_DOCUMENT) {
					if (eventType == XmlPullParser.START_TAG) {
						tagName = parser.getName();
						if (tagName.equals("data")) {
							shortWeathers.add(new WeatherInfo());
							onEnd = false;
							isItemTag1 = true;
						}
					} else if (eventType == XmlPullParser.TEXT && isItemTag1) {
						if (tagName.equals("hour") && !onHour) {
							shortWeathers.get(i).setHour(parser.getText());
							onHour = true;
						}
						if (tagName.equals("day") && !onDay) {
							shortWeathers.get(i).setDay(parser.getText());
							onDay = true;
						}
						if (tagName.equals("temp") && !onTem) {
							shortWeathers.get(i).setTemp(parser.getText());
							onTem = true;
						}
						if (tagName.equals("wfKor") && !onWfKor) {
							shortWeathers.get(i).setWfKor(parser.getText());
							onWfKor = true;
						}
						if (tagName.equals("pop") && !onPop) {
							shortWeathers.get(i).setPop(parser.getText());
							onPop = true;
						}
					} else if (eventType == XmlPullParser.END_TAG) {
						if (tagName.equals("s06") && onEnd == false) {
							i++;
							onHour = false;
							onDay = false;
							onTem = false;
							onWfKor = false;
							onPop = false;
							isItemTag1 = false;
							onEnd = true;
						}
					}

					eventType = parser.next();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
