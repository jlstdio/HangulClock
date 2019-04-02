package com.leejoonhee.hangulclockforandroid.Service.Weather;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.leejoonhee.hangulclockforandroid.R;

public class WeatherSetting extends AppCompatActivity {

    SharedPreferences sets;

    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weathersetting);

        sets = getSharedPreferences("usersets", Activity.MODE_PRIVATE);

        text = (EditText)findViewById(R.id.url);

    }

    public void gotosite(View v){
        String url ="http://www.weather.go.kr/weather/lifenindustry/sevice_rss.jsp";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);

    }

    public void saveurl(View v){
        String str = text.getText().toString();

        SharedPreferences.Editor editor = sets.edit();
        editor.putString("weatherurl",str);
        editor.commit();
        Toast toast = Toast.makeText(getApplicationContext(),"Url을 저장하였습니다", Toast.LENGTH_SHORT);
        toast.show();

    }
}
