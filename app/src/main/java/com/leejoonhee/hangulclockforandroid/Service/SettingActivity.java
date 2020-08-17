package com.leejoonhee.hangulclockforandroid.Service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.leejoonhee.hangulclockforandroid.MainActivity;
import com.leejoonhee.hangulclockforandroid.R;
import com.leejoonhee.hangulclockforandroid.lockscreen.lockset;

public class SettingActivity extends AppCompatActivity
{
    SharedPreferences sets;

    LinearLayout image1;
    LinearLayout image2;
    LinearLayout image3;
    LinearLayout image4;

    TextView sentence;

    int pick = 0;

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

        String str = sets.getString("title", "프레임 색상을 설정합니다");

        //text color 가져오기

        int colorAlpha = sets.getInt("colorAlpha", 255);
        int colorRed = sets.getInt("colorRed", 255);
        int colorGreen = sets.getInt("colorGreen", 255);
        int colorBlue = sets.getInt("colorBlue", 255);

        sentence.setTextColor(Color.argb(colorAlpha, colorRed, colorGreen, colorBlue));

        //frame color 가져오기
        frameColor(sets.getInt("color", R.color.white));
    }

    void sentenceColor(int A, int R, int G, int B){
        sentence.setTextColor(Color.argb(A, R, G, B));
    }

    void clockColor(int Color){

    }

    public void frameColorClicked(View V) {pick = 0;}

    public void sentenceColorClicked(View V) {pick = 1;}

    //public void clockColorClicked(View V) {pick = 2;}

    public void setColor(int Color){

        SharedPreferences.Editor editor = sets.edit();

        if(pick == 0){
            editor.putInt("color", Color); //ID가"color"인 sharedpreference에 정수 "1"를 저장합니다
            editor.commit();

            frameColor(Color);
            Toast.makeText(getApplicationContext(), "프레임 색상이 선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
        }

        if(pick == 1){

            editor.putInt("colorAlpha", 255);
            editor.putInt("colorRed", 255);
            editor.putInt("colorGreen", 255);
            editor.putInt("colorBlue", 255);
            editor.commit();

            //sentenceColor(Color);
            Toast.makeText(getApplicationContext(), "문장 색상이 선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
        }

        if(pick == 2){
            editor.putInt("clockColor", Color);
            editor.commit();

            clockColor(Color);
            Toast.makeText(getApplicationContext(), "시계 색상이 선택되었습니다", Toast.LENGTH_SHORT).show(); //저장 버튼 클릭시 적용됨을 알리기위해 메세지를 띄웁니다
        }
    }

    public void setwhite(View v) { setColor(R.color.white); }

    public void setblack(View v) { setColor(R.color.black); }

    public void claret(View v) { setColor(R.color.claret); }

    public void clarett(View v) { setColor(R.color.clarett); }

    public void clarettt(View v) { setColor(R.color.clarettt); }

    public void red(View v) { setColor(R.color.red); }

    public void redd(View v) { setColor(R.color.redd); }

    public void reddd(View v) { setColor(R.color.reddd); }

    public void pink(View v) { setColor(R.color.pink); }

    public void pinkk(View v) { setColor(R.color.pinkk); }

    public void orange(View v) { setColor(R.color.orange); }

    public void orangee(View v) { setColor(R.color.orangee); }

    public void orangeee(View v) { setColor(R.color.orangeee); }

    public void yellow(View v) { setColor(R.color.yellow); }

    public void yelloww(View v) { setColor(R.color.yelloww); }

    public void green(View v) { setColor(R.color.green); }

    public void greenn(View v) { setColor(R.color.greenn); }

    public void greennn(View v) { setColor(R.color.greennn); }

    public void bluegreen(View v) { setColor(R.color.bluegreen); }

    public void bluegreenn(View v) { setColor(R.color.bluegreenn); }

    public void navy(View v) { setColor(R.color.navy); }

    public void navyy(View v) { setColor(R.color.navyy); }

    public void darkblue(View v) { setColor(R.color.darkblue); }

    public void blue(View v) { setColor(R.color.blue); }

    public void bluee(View v) { setColor(R.color.bluee); }

    public void violet(View v) { setColor(R.color.violet); }

    public void violett(View v) { setColor(R.color.violett); }

    public void violettt(View v) { setColor(R.color.violettt); }

    public void violetttt(View v) { setColor(R.color.violetttt); }

    public void violettttt(View v) { setColor(R.color.violettttt); }

    public void frameColor(int Color){

        image1.setBackgroundColor(getResources().getColor(Color));
        image2.setBackgroundColor(getResources().getColor(Color));
        image3.setBackgroundColor(getResources().getColor(Color));
        image4.setBackgroundColor(getResources().getColor(Color));
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

    public void lab(View V){
        changeView(5) ;
        sentence.setText("베타기능입니다");
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

