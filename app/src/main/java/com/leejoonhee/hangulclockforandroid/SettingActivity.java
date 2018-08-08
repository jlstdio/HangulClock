package com.leejoonhee.hangulclockforandroid;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity
{
    SharedPreferences sets;
    EditText words;

    LinearLayout image1;
    LinearLayout image2;
    LinearLayout image3;
    LinearLayout image4;
    TextView sentence;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        image1 = (LinearLayout)findViewById(R.id.imageView);
        image2 = (LinearLayout)findViewById(R.id.imageView2);
        image3 = (LinearLayout)findViewById(R.id.imageView4);
        image4 = (LinearLayout)findViewById(R.id.imageView5);
        sentence = (TextView)findViewById(R.id.title);

        words = (EditText)findViewById(R.id.editText1); //표시할문자 값을 받아주기위해 선언하였습니다

        sets = getSharedPreferences("usersets", Activity.MODE_PRIVATE); //MainActivity가 꺼져도 NewAppWidget에서 값을 받아 올 수 있도록 SharedPreference를 사용하였습니다
        words.setText(sets.getString("title", "네가 있어 아름다운 오늘"));
        sentence.setText(sets.getString("title", "네가 있어 아름다운 오늘"));

        if (sets.getInt("color", 0) == 1){
            image1.setBackgroundColor(getResources().getColor(R.color.white));
            image2.setBackgroundColor(getResources().getColor(R.color.white));
            image3.setBackgroundColor(getResources().getColor(R.color.white));
            image4.setBackgroundColor(getResources().getColor(R.color.white));
            sentence.setTextColor(Color.WHITE);
        }

        if(sets.getInt("color", 0) == 2){
            image1.setBackgroundColor(getResources().getColor(R.color.black));
            image2.setBackgroundColor(getResources().getColor(R.color.black));
            image3.setBackgroundColor(getResources().getColor(R.color.black));
            image4.setBackgroundColor(getResources().getColor(R.color.black));
            sentence.setTextColor(Color.BLACK);
        }

        if (sets.getInt("color", 0) == 3){
            image1.setBackgroundColor(getResources().getColor(R.color.pink));
            image2.setBackgroundColor(getResources().getColor(R.color.pink));
            image3.setBackgroundColor(getResources().getColor(R.color.pink));
            image4.setBackgroundColor(getResources().getColor(R.color.pink));
            sentence.setTextColor(getResources().getColor(R.color.pink));
        }

        if (sets.getInt("color", 0) == 4){
            image1.setBackgroundColor(getResources().getColor(R.color.red));
            image2.setBackgroundColor(getResources().getColor(R.color.red));
            image3.setBackgroundColor(getResources().getColor(R.color.red));
            image4.setBackgroundColor(getResources().getColor(R.color.red));
            sentence.setTextColor(getResources().getColor(R.color.red));
        }

        if (sets.getInt("color", 0) == 5){
            image1.setBackgroundColor(getResources().getColor(R.color.orange));
            image2.setBackgroundColor(getResources().getColor(R.color.orange));
            image3.setBackgroundColor(getResources().getColor(R.color.orange));
            image4.setBackgroundColor(getResources().getColor(R.color.orange));
            sentence.setTextColor(getResources().getColor(R.color.orange));
        }

        if (sets.getInt("color", 0) == 6){
            image1.setBackgroundColor(getResources().getColor(R.color.green));
            image2.setBackgroundColor(getResources().getColor(R.color.green));
            image3.setBackgroundColor(getResources().getColor(R.color.green));
            image4.setBackgroundColor(getResources().getColor(R.color.green));
            sentence.setTextColor(getResources().getColor(R.color.green));
        }

        if (sets.getInt("color", 0) == 7){
            image1.setBackgroundColor(getResources().getColor(R.color.bluegreen));
            image2.setBackgroundColor(getResources().getColor(R.color.bluegreen));
            image3.setBackgroundColor(getResources().getColor(R.color.bluegreen));
            image4.setBackgroundColor(getResources().getColor(R.color.bluegreen));
            sentence.setTextColor(getResources().getColor(R.color.bluegreen));
        }
    }

    public void save(View v){
        SharedPreferences.Editor editor = sets.edit();
        editor.putString("title", words.getText().toString()); //edittext에서 얻어온 값을 title로 저장합니다.
        editor.commit();

        sentence.setText(sets.getString("title", "receivingfail"));

        Toast.makeText(getApplicationContext(), "적용되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    int red, green, blue = 255;

    public void setwhite(View v) {

        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 1); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.white));
        image2.setBackgroundColor(getResources().getColor(R.color.white));
        image3.setBackgroundColor(getResources().getColor(R.color.white));
        image4.setBackgroundColor(getResources().getColor(R.color.white));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void setblack(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 2); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.black));
        image1.setBackgroundColor(getResources().getColor(R.color.black));
        image2.setBackgroundColor(getResources().getColor(R.color.black));
        image3.setBackgroundColor(getResources().getColor(R.color.black));
        image4.setBackgroundColor(getResources().getColor(R.color.black));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void setpink(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 3); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.pink));
        image1.setBackgroundColor(getResources().getColor(R.color.pink));
        image2.setBackgroundColor(getResources().getColor(R.color.pink));
        image3.setBackgroundColor(getResources().getColor(R.color.pink));
        image4.setBackgroundColor(getResources().getColor(R.color.pink));
        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void setred(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 4); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.red));
        image1.setBackgroundColor(getResources().getColor(R.color.red));
        image2.setBackgroundColor(getResources().getColor(R.color.red));
        image3.setBackgroundColor(getResources().getColor(R.color.red));
        image4.setBackgroundColor(getResources().getColor(R.color.red));
        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void setorange(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 5); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.orange));
        image1.setBackgroundColor(getResources().getColor(R.color.orange));
        image2.setBackgroundColor(getResources().getColor(R.color.orange));
        image3.setBackgroundColor(getResources().getColor(R.color.orange));
        image4.setBackgroundColor(getResources().getColor(R.color.orange));
        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void setgreen(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 6); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.green));
        image1.setBackgroundColor(getResources().getColor(R.color.green));
        image2.setBackgroundColor(getResources().getColor(R.color.green));
        image3.setBackgroundColor(getResources().getColor(R.color.green));
        image4.setBackgroundColor(getResources().getColor(R.color.green));
        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void setbluegreen(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 7); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.bluegreen));
        image1.setBackgroundColor(getResources().getColor(R.color.bluegreen));
        image2.setBackgroundColor(getResources().getColor(R.color.bluegreen));
        image3.setBackgroundColor(getResources().getColor(R.color.bluegreen));
        image4.setBackgroundColor(getResources().getColor(R.color.bluegreen));
        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void customset(View v) {

    }

}

