package com.leejoonhee.hangulclockforandroid;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText words = (EditText)findViewById(R.id.editText1); //표시할문자 값을 받아주기위해 선언하였습니다
        final CheckBox mode = (CheckBox)findViewById(R.id.mode); //색상을 정하도록 문자값을 받습니다(문자로 받는것은 또 다른 기능을 구현하기 위해 일부러 문자로 받았습니다)
        final SharedPreferences sets = getSharedPreferences("usersets", Activity.MODE_PRIVATE); //MainActivity가 꺼져도 NewAppWidget에서 값을 받아 올 수 있도록 SharedPreference를 사용하였습니다

        words.setText(sets.getString("title", ""));

        final int prefColor = sets.getInt("color", NewAppWidget.PREF_COLOR_DEFAULT);
        switch (prefColor) {
            case NewAppWidget.PREF_COLOR_WHITE:
                mode.setChecked(false);
                break;
            case NewAppWidget.PREF_COLOR_BLACK:
                mode.setChecked(true);
                break;
            default:
                break;
        }

        RemoteViews views = new RemoteViews(getPackageName(), R.layout.new_app_widget);//new_app_widget의 objects들의 값을 변경하기위함입니다

        //저장 버튼을 눌렀을 시에 작동합니다
        findViewById(R.id.button1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        SharedPreferences.Editor editor = sets.edit();
                        editor.putString("title", words.getText().toString()); //edittext에서 얻어온 값을 title로 저장합니다.

                        if (mode.isChecked()) {
                            editor.putInt("color", NewAppWidget.PREF_COLOR_BLACK); //ID가"color"인 sharedpreference에 정수 "2"를 저장합니다
                        } else{
                            editor.putInt("color", NewAppWidget.PREF_COLOR_WHITE); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
                        }
                        editor.apply();
                        NewAppWidget.sUpdateData.update();

                        Toast.makeText(getApplicationContext(), "적용되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
                    }
                }
        );

    }

}

