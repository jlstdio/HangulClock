package com.leejoonhee.hangulclockforandroid;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity
{
	SharedPreferences sets;
	EditText words;
	CheckBox mode;

	ImageView image;
	TextView sentence;
	
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        image = (ImageView)findViewById(R.id.backgroud);
        sentence = (TextView)findViewById(R.id.title);

		words = (EditText)findViewById(R.id.editText1); //표시할문자 값을 받아주기위해 선언하였습니다
        mode = (CheckBox)findViewById(R.id.mode); //색상을 정하도록 문자값을 받습니다(문자로 받는것은 또 다른 기능을 구현하기 위해 일부러 문자로 받았습니다)

        sets = getSharedPreferences("usersets", Activity.MODE_PRIVATE); //MainActivity가 꺼져도 NewAppWidget에서 값을 받아 올 수 있도록 SharedPreference를 사용하였습니다
        words.setText(sets.getString("title", "언젠가는 빛이 될 당신"));

        if(sets.getInt("color", 0) == 2){
            mode.setChecked(true);
			image.setImageResource(R.drawable.hangulclock_board_black_prev);
			sentence.setTextColor(Color.BLACK);
        }
        if (sets.getInt("color", 0) == 1){
            mode.setChecked(false);
			image.setImageResource(R.drawable.hangulclock_board_white_prev);
			sentence.setTextColor(Color.WHITE);
        }
    }

	public void save(View v){
		SharedPreferences.Editor editor = sets.edit();
		editor.putString("title", words.getText().toString()); //edittext에서 얻어온 값을 title로 저장합니다.
		editor.commit();

		sentence.setText(sets.getString("title", "receivingfail"));

		if(mode.isChecked()){
			editor.putInt("color", 2); //ID가"color"인 sharedpreference에 정수 "2"를 저장합니다
			editor.commit();
			image.setImageResource(R.drawable.hangulclock_board_black_prev);
			sentence.setTextColor(Color.BLACK);
		}
		else{
			editor.putInt("color", 1); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
			editor.commit();
			image.setImageResource(R.drawable.hangulclock_board_white_prev);
			sentence.setTextColor(Color.WHITE);
		}
		Toast.makeText(getApplicationContext(), "적용되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
	}

	public void update(View v){
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.leejoonhee.hangulclockforandroid"));
		startActivity(intent);
	}
	
}

