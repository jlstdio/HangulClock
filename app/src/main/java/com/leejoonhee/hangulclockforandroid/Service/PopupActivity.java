package com.leejoonhee.hangulclockforandroid.Service;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.leejoonhee.hangulclockforandroid.R;

public class PopupActivity extends Activity {

    TextView txtText;

    String inst;

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference notice = rootRef.child("notice");

    SharedPreferences sets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_activity);

        sets = getSharedPreferences("usersets", Activity.MODE_PRIVATE); //MainActivity가 꺼져도 NewAppWidget에서 값을 받아 올 수 있도록 SharedPreference를 사용하였습니다

        txtText = (TextView)findViewById(R.id.txtText);

        inst = sets.getString("notice","1");
    }

    public void mOnClose(View v){

        Intent intent = new Intent();
        intent.putExtra("result", "Close Popup");
        setResult(RESULT_OK, intent);

        int numInt = Integer.parseInt(inst);
        numInt++;
        String numStr = String.valueOf(numInt);

        SharedPreferences.Editor editor = sets.edit();
        editor.putString("notice", numStr);
        editor.commit();

        finish();
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

    }

}
