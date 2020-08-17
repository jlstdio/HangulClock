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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.leejoonhee.hangulclockforandroid.Service.HelpActivity;
import com.leejoonhee.hangulclockforandroid.Service.SettingActivity;

public class MainActivity extends AppCompatActivity
{
	DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

	DatabaseReference download = databaseReference.child("downloads");
	DatabaseReference version = databaseReference.child("version");
	DatabaseReference notice = databaseReference.child("notice");

	TextView mversion;
	TextView mdownloads;
	TextView sentence;

	static SharedPreferences sets;

	static String data = "";

	TextView txtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sentence = findViewById(R.id.sentence);

		sets = getSharedPreferences("usersets", Activity.MODE_PRIVATE); //MainActivity가 꺼져도 NewAppWidget에서 값을 받아 올 수 있도록 SharedPreference를 사용하였습니다
		sentence.setText(sets.getString("title", "설정이 필요합니다"));

		String str = sets.getString("title", "설정이필요합니다");

		txtText = (TextView) findViewById(R.id.txtText);

		if (str.equals("**weather**")) {
			sentence.setText(data);
		}

		mversion = (TextView) findViewById(R.id.version);
		mdownloads = (TextView) findViewById(R.id.download);

		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		boolean isWhiteListing = false;
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
			isWhiteListing = pm.isIgnoringBatteryOptimizations(getPackageName());
		}

		if (!isWhiteListing) {
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
							Toast.makeText(MainActivity.this, "설정을 취소했습니다", Toast.LENGTH_SHORT).show();
						}
					})
					.create()
					.show();
		}
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

				if(text.equals("3.2.2"))//Last Modified : Dec. 22. 2019
					mversion.setText("현재 최신버전입니다");

				else
					mversion.setText("[업데이트하러가기]");
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});

	}
}
