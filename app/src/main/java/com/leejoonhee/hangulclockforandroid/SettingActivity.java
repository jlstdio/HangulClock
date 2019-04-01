package com.leejoonhee.hangulclockforandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.leejoonhee.hangulclockforandroid.lockscreen.lockset;

public class SettingActivity extends AppCompatActivity
{
    SharedPreferences sets;

    LinearLayout image1;
    LinearLayout image2;
    LinearLayout image3;
    LinearLayout image4;

    TextView sentence;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        changeView(0) ;

        Intent intent = new Intent(Intent.ACTION_MAIN);

        image1 = findViewById(R.id.imageView);
        image2 = findViewById(R.id.imageView2);
        image3 = findViewById(R.id.imageView4);
        image4 = findViewById(R.id.imageView5);
        sentence = findViewById(R.id.sentence);

        sets = getSharedPreferences("usersets", Activity.MODE_PRIVATE); //MainActivity가 꺼져도 NewAppWidget에서 값을 받아 올 수 있도록 SharedPreference를 사용하였습니다
        sentence.setText(sets.getString("title", "설정이 필요합니다"));

        String str = sets.getString("title", "설정이필요합니다");

        if(str.equals("**weather**")){
            sentence.setText(MainActivity.weathersaved);
        }

        if (sets.getInt("color", 0) == 1 || sets.getInt("color", 0) == 0){
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

        if(sets.getInt("color", 0) == 3){
            image1.setBackgroundColor(getResources().getColor(R.color.claret));
            image2.setBackgroundColor(getResources().getColor(R.color.claret));
            image3.setBackgroundColor(getResources().getColor(R.color.claret));
            image4.setBackgroundColor(getResources().getColor(R.color.claret));
            sentence.setTextColor(getResources().getColor(R.color.claret));
        }

        if(sets.getInt("color", 0) == 4){
            image1.setBackgroundColor(getResources().getColor(R.color.clarett));
            image2.setBackgroundColor(getResources().getColor(R.color.clarett));
            image3.setBackgroundColor(getResources().getColor(R.color.clarett));
            image4.setBackgroundColor(getResources().getColor(R.color.clarett));
            sentence.setTextColor(getResources().getColor(R.color.clarett));
        }

        if(sets.getInt("color", 0) == 5){
            image1.setBackgroundColor(getResources().getColor(R.color.clarettt));
            image2.setBackgroundColor(getResources().getColor(R.color.clarettt));
            image3.setBackgroundColor(getResources().getColor(R.color.clarettt));
            image4.setBackgroundColor(getResources().getColor(R.color.clarettt));
            sentence.setTextColor(getResources().getColor(R.color.clarettt));
        }

        if(sets.getInt("color", 0) == 6){
            image1.setBackgroundColor(getResources().getColor(R.color.red));
            image2.setBackgroundColor(getResources().getColor(R.color.red));
            image3.setBackgroundColor(getResources().getColor(R.color.red));
            image4.setBackgroundColor(getResources().getColor(R.color.red));
            sentence.setTextColor(getResources().getColor(R.color.red));
        }

        if(sets.getInt("color", 0) == 7){
            image1.setBackgroundColor(getResources().getColor(R.color.redd));
            image2.setBackgroundColor(getResources().getColor(R.color.redd));
            image3.setBackgroundColor(getResources().getColor(R.color.redd));
            image4.setBackgroundColor(getResources().getColor(R.color.redd));
            sentence.setTextColor(getResources().getColor(R.color.redd));
        }

        if(sets.getInt("color", 0) == 8){
            image1.setBackgroundColor(getResources().getColor(R.color.reddd));
            image2.setBackgroundColor(getResources().getColor(R.color.reddd));
            image3.setBackgroundColor(getResources().getColor(R.color.reddd));
            image4.setBackgroundColor(getResources().getColor(R.color.reddd));
            sentence.setTextColor(getResources().getColor(R.color.reddd));
        }

        if(sets.getInt("color", 0) == 9){
            image1.setBackgroundColor(getResources().getColor(R.color.pink));
            image2.setBackgroundColor(getResources().getColor(R.color.pink));
            image3.setBackgroundColor(getResources().getColor(R.color.pink));
            image4.setBackgroundColor(getResources().getColor(R.color.pink));
            sentence.setTextColor(getResources().getColor(R.color.pink));
        }

        if(sets.getInt("color", 0) == 10){
            image1.setBackgroundColor(getResources().getColor(R.color.pinkk));
            image2.setBackgroundColor(getResources().getColor(R.color.pinkk));
            image3.setBackgroundColor(getResources().getColor(R.color.pinkk));
            image4.setBackgroundColor(getResources().getColor(R.color.pinkk));
            sentence.setTextColor(getResources().getColor(R.color.pinkk));
        }

        if(sets.getInt("color", 0) == 11){
            image1.setBackgroundColor(getResources().getColor(R.color.orange));
            image2.setBackgroundColor(getResources().getColor(R.color.orange));
            image3.setBackgroundColor(getResources().getColor(R.color.orange));
            image4.setBackgroundColor(getResources().getColor(R.color.orange));
            sentence.setTextColor(getResources().getColor(R.color.orange));
        }

        if(sets.getInt("color", 0) == 12){
            image1.setBackgroundColor(getResources().getColor(R.color.orangee));
            image2.setBackgroundColor(getResources().getColor(R.color.orangee));
            image3.setBackgroundColor(getResources().getColor(R.color.orangee));
            image4.setBackgroundColor(getResources().getColor(R.color.orangee));
            sentence.setTextColor(getResources().getColor(R.color.orangee));
        }

        if(sets.getInt("color", 0) == 13){
            image1.setBackgroundColor(getResources().getColor(R.color.orangeee));
            image2.setBackgroundColor(getResources().getColor(R.color.orangeee));
            image3.setBackgroundColor(getResources().getColor(R.color.orangeee));
            image4.setBackgroundColor(getResources().getColor(R.color.orangeee));
            sentence.setTextColor(getResources().getColor(R.color.orangeee));
        }

        if(sets.getInt("color", 0) == 14){
            image1.setBackgroundColor(getResources().getColor(R.color.yellow));
            image2.setBackgroundColor(getResources().getColor(R.color.yellow));
            image3.setBackgroundColor(getResources().getColor(R.color.yellow));
            image4.setBackgroundColor(getResources().getColor(R.color.yellow));
            sentence.setTextColor(getResources().getColor(R.color.yellow));
        }

        if(sets.getInt("color", 0) == 15){
            image1.setBackgroundColor(getResources().getColor(R.color.yelloww));
            image2.setBackgroundColor(getResources().getColor(R.color.yelloww));
            image3.setBackgroundColor(getResources().getColor(R.color.yelloww));
            image4.setBackgroundColor(getResources().getColor(R.color.yelloww));
            sentence.setTextColor(getResources().getColor(R.color.yelloww));
        }

        if(sets.getInt("color", 0) == 16){
            image1.setBackgroundColor(getResources().getColor(R.color.green));
            image2.setBackgroundColor(getResources().getColor(R.color.green));
            image3.setBackgroundColor(getResources().getColor(R.color.green));
            image4.setBackgroundColor(getResources().getColor(R.color.green));
            sentence.setTextColor(getResources().getColor(R.color.green));
        }

        if(sets.getInt("color", 0) == 17){
            image1.setBackgroundColor(getResources().getColor(R.color.greenn));
            image2.setBackgroundColor(getResources().getColor(R.color.greenn));
            image3.setBackgroundColor(getResources().getColor(R.color.greenn));
            image4.setBackgroundColor(getResources().getColor(R.color.greenn));
            sentence.setTextColor(getResources().getColor(R.color.greenn));
        }

        if(sets.getInt("color", 0) == 18){
            image1.setBackgroundColor(getResources().getColor(R.color.greennn));
            image2.setBackgroundColor(getResources().getColor(R.color.greennn));
            image3.setBackgroundColor(getResources().getColor(R.color.greennn));
            image4.setBackgroundColor(getResources().getColor(R.color.greennn));
            sentence.setTextColor(getResources().getColor(R.color.greennn));
        }

        if(sets.getInt("color", 0) == 19){
            image1.setBackgroundColor(getResources().getColor(R.color.bluegreen));
            image2.setBackgroundColor(getResources().getColor(R.color.bluegreen));
            image3.setBackgroundColor(getResources().getColor(R.color.bluegreen));
            image4.setBackgroundColor(getResources().getColor(R.color.bluegreen));
            sentence.setTextColor(getResources().getColor(R.color.bluegreen));
        }

        if(sets.getInt("color", 0) == 20){
            image1.setBackgroundColor(getResources().getColor(R.color.bluegreenn));
            image2.setBackgroundColor(getResources().getColor(R.color.bluegreenn));
            image3.setBackgroundColor(getResources().getColor(R.color.bluegreenn));
            image4.setBackgroundColor(getResources().getColor(R.color.bluegreenn));
            sentence.setTextColor(getResources().getColor(R.color.bluegreenn));
        }

        if(sets.getInt("color", 0) == 21){
            image1.setBackgroundColor(getResources().getColor(R.color.navy));
            image2.setBackgroundColor(getResources().getColor(R.color.navy));
            image3.setBackgroundColor(getResources().getColor(R.color.navy));
            image4.setBackgroundColor(getResources().getColor(R.color.navy));
            sentence.setTextColor(getResources().getColor(R.color.navy));
        }

        if(sets.getInt("color", 0) == 22){
            image1.setBackgroundColor(getResources().getColor(R.color.navyy));
            image2.setBackgroundColor(getResources().getColor(R.color.navyy));
            image3.setBackgroundColor(getResources().getColor(R.color.navyy));
            image4.setBackgroundColor(getResources().getColor(R.color.navyy));
            sentence.setTextColor(getResources().getColor(R.color.navyy));
        }

        if(sets.getInt("color", 0) == 23){
            image1.setBackgroundColor(getResources().getColor(R.color.darkblue));
            image2.setBackgroundColor(getResources().getColor(R.color.darkblue));
            image3.setBackgroundColor(getResources().getColor(R.color.darkblue));
            image4.setBackgroundColor(getResources().getColor(R.color.darkblue));
            sentence.setTextColor(getResources().getColor(R.color.darkblue));
        }

        if(sets.getInt("color", 0) == 24){
            image1.setBackgroundColor(getResources().getColor(R.color.blue));
            image2.setBackgroundColor(getResources().getColor(R.color.blue));
            image3.setBackgroundColor(getResources().getColor(R.color.blue));
            image4.setBackgroundColor(getResources().getColor(R.color.blue));
            sentence.setTextColor(getResources().getColor(R.color.blue));
        }

        if(sets.getInt("color", 0) == 25){
            image1.setBackgroundColor(getResources().getColor(R.color.bluee));
            image2.setBackgroundColor(getResources().getColor(R.color.bluee));
            image3.setBackgroundColor(getResources().getColor(R.color.bluee));
            image4.setBackgroundColor(getResources().getColor(R.color.bluee));
            sentence.setTextColor(getResources().getColor(R.color.bluee));
        }

        if(sets.getInt("color", 0) == 26){
            image1.setBackgroundColor(getResources().getColor(R.color.violet));
            image2.setBackgroundColor(getResources().getColor(R.color.violet));
            image3.setBackgroundColor(getResources().getColor(R.color.violet));
            image4.setBackgroundColor(getResources().getColor(R.color.violet));
            sentence.setTextColor(getResources().getColor(R.color.violet));
        }

        if(sets.getInt("color", 0) == 27){
            image1.setBackgroundColor(getResources().getColor(R.color.violett));
            image2.setBackgroundColor(getResources().getColor(R.color.violett));
            image3.setBackgroundColor(getResources().getColor(R.color.violett));
            image4.setBackgroundColor(getResources().getColor(R.color.violett));
            sentence.setTextColor(getResources().getColor(R.color.violett));
        }

        if(sets.getInt("color", 0) == 28){
            image1.setBackgroundColor(getResources().getColor(R.color.violettt));
            image2.setBackgroundColor(getResources().getColor(R.color.violettt));
            image3.setBackgroundColor(getResources().getColor(R.color.violettt));
            image4.setBackgroundColor(getResources().getColor(R.color.violettt));
            sentence.setTextColor(getResources().getColor(R.color.violettt));
        }

        if(sets.getInt("color", 0) == 29){
            image1.setBackgroundColor(getResources().getColor(R.color.violetttt));
            image2.setBackgroundColor(getResources().getColor(R.color.violetttt));
            image3.setBackgroundColor(getResources().getColor(R.color.violetttt));
            image4.setBackgroundColor(getResources().getColor(R.color.violetttt));
            sentence.setTextColor(getResources().getColor(R.color.violetttt));
        }

        if(sets.getInt("color", 0) == 30){
            image1.setBackgroundColor(getResources().getColor(R.color.violettttt));
            image2.setBackgroundColor(getResources().getColor(R.color.violettttt));
            image3.setBackgroundColor(getResources().getColor(R.color.violettttt));
            image4.setBackgroundColor(getResources().getColor(R.color.violettttt));
            sentence.setTextColor(getResources().getColor(R.color.violettttt));
        }
    }

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
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.black));
        image2.setBackgroundColor(getResources().getColor(R.color.black));
        image3.setBackgroundColor(getResources().getColor(R.color.black));
        image4.setBackgroundColor(getResources().getColor(R.color.black));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void claret(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 3); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.claret));
        image2.setBackgroundColor(getResources().getColor(R.color.claret));
        image3.setBackgroundColor(getResources().getColor(R.color.claret));
        image4.setBackgroundColor(getResources().getColor(R.color.claret));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void clarett(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 4); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.clarett));
        image2.setBackgroundColor(getResources().getColor(R.color.clarett));
        image3.setBackgroundColor(getResources().getColor(R.color.clarett));
        image4.setBackgroundColor(getResources().getColor(R.color.clarett));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void clarettt(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 5); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.clarettt));
        image2.setBackgroundColor(getResources().getColor(R.color.clarettt));
        image3.setBackgroundColor(getResources().getColor(R.color.clarettt));
        image4.setBackgroundColor(getResources().getColor(R.color.clarettt));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void red(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 6); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.red));
        image2.setBackgroundColor(getResources().getColor(R.color.red));
        image3.setBackgroundColor(getResources().getColor(R.color.red));
        image4.setBackgroundColor(getResources().getColor(R.color.red));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void redd(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 7); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.redd));
        image2.setBackgroundColor(getResources().getColor(R.color.redd));
        image3.setBackgroundColor(getResources().getColor(R.color.redd));
        image4.setBackgroundColor(getResources().getColor(R.color.redd));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void reddd(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 8); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.reddd));
        image2.setBackgroundColor(getResources().getColor(R.color.reddd));
        image3.setBackgroundColor(getResources().getColor(R.color.reddd));
        image4.setBackgroundColor(getResources().getColor(R.color.reddd));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void pink(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 9); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.pink));
        image2.setBackgroundColor(getResources().getColor(R.color.pink));
        image3.setBackgroundColor(getResources().getColor(R.color.pink));
        image4.setBackgroundColor(getResources().getColor(R.color.pink));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void pinkk(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 10); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.pinkk));
        image2.setBackgroundColor(getResources().getColor(R.color.pinkk));
        image3.setBackgroundColor(getResources().getColor(R.color.pinkk));
        image4.setBackgroundColor(getResources().getColor(R.color.pinkk));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void orange(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 11); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.orange));
        image2.setBackgroundColor(getResources().getColor(R.color.orange));
        image3.setBackgroundColor(getResources().getColor(R.color.orange));
        image4.setBackgroundColor(getResources().getColor(R.color.orange));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void orangee(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 12); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.orangee));
        image2.setBackgroundColor(getResources().getColor(R.color.orangee));
        image3.setBackgroundColor(getResources().getColor(R.color.orangee));
        image4.setBackgroundColor(getResources().getColor(R.color.orangee));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void orangeee(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 13); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.orangeee));
        image2.setBackgroundColor(getResources().getColor(R.color.orangeee));
        image3.setBackgroundColor(getResources().getColor(R.color.orangeee));
        image4.setBackgroundColor(getResources().getColor(R.color.orangeee));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void yellow(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 14); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.yellow));
        image2.setBackgroundColor(getResources().getColor(R.color.yellow));
        image3.setBackgroundColor(getResources().getColor(R.color.yellow));
        image4.setBackgroundColor(getResources().getColor(R.color.yellow));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void yelloww(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 15); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.yelloww));
        image2.setBackgroundColor(getResources().getColor(R.color.yelloww));
        image3.setBackgroundColor(getResources().getColor(R.color.yelloww));
        image4.setBackgroundColor(getResources().getColor(R.color.yelloww));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void green(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 16); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.green));
        image2.setBackgroundColor(getResources().getColor(R.color.green));
        image3.setBackgroundColor(getResources().getColor(R.color.green));
        image4.setBackgroundColor(getResources().getColor(R.color.green));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void greenn(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 17); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.greenn));
        image2.setBackgroundColor(getResources().getColor(R.color.greenn));
        image3.setBackgroundColor(getResources().getColor(R.color.greenn));
        image4.setBackgroundColor(getResources().getColor(R.color.greenn));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void greennn(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 18); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.greennn));
        image2.setBackgroundColor(getResources().getColor(R.color.greennn));
        image3.setBackgroundColor(getResources().getColor(R.color.greennn));
        image4.setBackgroundColor(getResources().getColor(R.color.greennn));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void bluegreen(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 19); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.bluegreen));
        image2.setBackgroundColor(getResources().getColor(R.color.bluegreen));
        image3.setBackgroundColor(getResources().getColor(R.color.bluegreen));
        image4.setBackgroundColor(getResources().getColor(R.color.bluegreen));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void bluegreenn(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 20); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.bluegreenn));
        image2.setBackgroundColor(getResources().getColor(R.color.bluegreenn));
        image3.setBackgroundColor(getResources().getColor(R.color.bluegreenn));
        image4.setBackgroundColor(getResources().getColor(R.color.bluegreenn));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void navy(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 21); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.navy));
        image2.setBackgroundColor(getResources().getColor(R.color.navy));
        image3.setBackgroundColor(getResources().getColor(R.color.navy));
        image4.setBackgroundColor(getResources().getColor(R.color.navy));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void navyy(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 22); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.navyy));
        image2.setBackgroundColor(getResources().getColor(R.color.navyy));
        image3.setBackgroundColor(getResources().getColor(R.color.navyy));
        image4.setBackgroundColor(getResources().getColor(R.color.navyy));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void darkblue(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 23); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.darkblue));
        image2.setBackgroundColor(getResources().getColor(R.color.darkblue));
        image3.setBackgroundColor(getResources().getColor(R.color.darkblue));
        image4.setBackgroundColor(getResources().getColor(R.color.darkblue));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void blue(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 24); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.blue));
        image2.setBackgroundColor(getResources().getColor(R.color.blue));
        image3.setBackgroundColor(getResources().getColor(R.color.blue));
        image4.setBackgroundColor(getResources().getColor(R.color.blue));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void bluee(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 25); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.bluee));
        image2.setBackgroundColor(getResources().getColor(R.color.bluee));
        image3.setBackgroundColor(getResources().getColor(R.color.bluee));
        image4.setBackgroundColor(getResources().getColor(R.color.bluee));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void violet(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 26); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.violet));
        image2.setBackgroundColor(getResources().getColor(R.color.violet));
        image3.setBackgroundColor(getResources().getColor(R.color.violet));
        image4.setBackgroundColor(getResources().getColor(R.color.violet));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void violett(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 27); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.violett));
        image2.setBackgroundColor(getResources().getColor(R.color.violett));
        image3.setBackgroundColor(getResources().getColor(R.color.violett));
        image4.setBackgroundColor(getResources().getColor(R.color.violett));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void violettt(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 28); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.violettt));
        image2.setBackgroundColor(getResources().getColor(R.color.violettt));
        image3.setBackgroundColor(getResources().getColor(R.color.violettt));
        image4.setBackgroundColor(getResources().getColor(R.color.violettt));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void violetttt(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 29); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.violetttt));
        image2.setBackgroundColor(getResources().getColor(R.color.violetttt));
        image3.setBackgroundColor(getResources().getColor(R.color.violetttt));
        image4.setBackgroundColor(getResources().getColor(R.color.violetttt));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void violettttt(View v) {
        SharedPreferences.Editor editor = sets.edit();
        editor.putInt("color", 30); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
        sentence.setTextColor(getResources().getColor(R.color.white));
        image1.setBackgroundColor(getResources().getColor(R.color.violettttt));
        image2.setBackgroundColor(getResources().getColor(R.color.violettttt));
        image3.setBackgroundColor(getResources().getColor(R.color.violettttt));
        image4.setBackgroundColor(getResources().getColor(R.color.violettttt));

        Toast.makeText(getApplicationContext(), "선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
    }

    public void mainmenu(View V){
        changeView(0);
        sentence.setText(sets.getString("title", "receivingfail"));
    }

    public void color(View V){
        changeView(1) ;
        sentence.setText("색상을 선택해주세요");
    }

    public void sentence(View V){ startActivity(new Intent(this, SentenceActivity.class)); }

    public void weather(View V){ startActivity(new Intent(this, WeatherSetting.class)); }

    public void shortcut(View V){
        changeView(4) ;
        sentence.setText("단축버튼을 설정해주세요");

    }

    public void lab(View V){
        changeView(5) ;
        sentence.setText("베타기능을 만나보세요");
    }

    public void home(View V){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void gotolock(View V){
        startActivity(new Intent(this, lockset.class));
    }

    private void changeView(int index) {

            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            FrameLayout frame = findViewById(R.id.frame);

            if (frame.getChildCount() > 0) {frame.removeViewAt(0);}

            View view = null ; switch (index) {
                case 0 :
                    view = inflater.inflate(R.layout.mainsetting, frame, false) ;
                    break ;
                case 1 :
                    view = inflater.inflate(R.layout.colorsetting, frame, false) ;
                    break ;
                case 2 :
                    view = inflater.inflate(R.layout.sentencesetting, frame, false) ;
                    break ;
                case 3 :
                    view = inflater.inflate(R.layout.weathersetting, frame, false) ;
                    break ;
                case 4 :
                    view = inflater.inflate(R.layout.shortcutsetting, frame, false) ;
                    break ;
                case 5 :
                    view = inflater.inflate(R.layout.labsetting, frame, false) ;
                    break ;
            }
        // FrameLayout에 뷰 추가.
        if (view != null) { frame.addView(view) ; } }

}

