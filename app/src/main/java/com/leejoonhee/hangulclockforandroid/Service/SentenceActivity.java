package com.leejoonhee.hangulclockforandroid.Service;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.leejoonhee.hangulclockforandroid.R;

public class SentenceActivity extends AppCompatActivity {

    EditText editsentence;

    SharedPreferences sets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sentencesetting);

        editsentence = findViewById(R.id.editsentence);

        sets = getSharedPreferences("usersets", Activity.MODE_PRIVATE); //MainActivity가 꺼져도 NewAppWidget에서 값을 받아 올 수 있도록 SharedPreference를 사용하였습니다
        editsentence.setText(sets.getString("title", "receivingfail"));
    }

    public void save(View V){
        String word = editsentence.getText().toString();

        SharedPreferences.Editor editor = sets.edit();
        editor.putString("title", word); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
        editor.commit();
    }
}
