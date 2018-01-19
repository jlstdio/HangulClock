package com.leejoonhee.hangulclockforandroid;

import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.content.*;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
{
	DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
	DatabaseReference download = rootRef.child("downloads");
	DatabaseReference version = rootRef.child("version");
	TextView mversion;
	TextView mdownloads;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		mversion = (TextView)findViewById(R.id.version);
		mdownloads = (TextView)findViewById(R.id.download);
	}
	
	public void setting(View v){
		startActivity(new Intent(this, SettingActivity.class));
	}
	
	public void help(View v){
		startActivity(new Intent(this, HelpActivity.class));
	}

	@Override
	protected void onStart(){
		super.onStart();

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

				if(text.equals("1.4"))
					mversion.setText("현재 최신버전입니다");

				else
					mversion.setText("업데이트가 있습니다 <<업데이트하러가기>>");
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});

	}

}
