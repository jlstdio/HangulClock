package com.leejoonhee.hangulclockforandroid.lockscreen;

import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.leejoonhee.hangulclockforandroid.R;

public class lockset extends AppCompatActivity {

    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lockscreen_set);

        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);

        LockScreen.getInstance().init(this,true);

        SharedPreferences sets = getSharedPreferences("usersets",0);
        sets.getInt("lock_color", 1);

        if(LockScreen.getInstance().isActive()){
            toggleButton.setChecked(true);
        }
        else{
            toggleButton.setChecked(false);

        }

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){

                    LockScreen.getInstance().active();
                }
                else{
                    LockScreen.getInstance().deactivate();
                }
            }
        });

    }






}