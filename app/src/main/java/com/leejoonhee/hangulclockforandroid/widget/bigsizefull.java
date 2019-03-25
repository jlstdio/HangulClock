package com.leejoonhee.hangulclockforandroid.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.leejoonhee.hangulclockforandroid.R;

import org.w3c.dom.Text;

import java.util.Calendar;

/**
 * Implementation of App Widget functionality.
 */
public class bigsizefull extends AppWidgetProvider {

    private static final int WIDGET_UPDATE_INTERVAL = 1000; //초당 한번씩 update를 합니다

    //시스템에서 지속적으로 액티비티를 끄는것을 방지하기위해 AlarmManager를 사용하여 계속 불러주기위함입니다
    private static PendingIntent mSender;
    private static AlarmManager mManager;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        super.onReceive(context, intent);

        String action = intent.getAction();

        if(action.equals("android.appwidget.action.APPWIDGET_UPDATE"))
        {
            //Log.w(TAG, "android.appwidget.action.APPWIDGET_UPDATE");
            removePreviousAlarm();

            long firstTime = System.currentTimeMillis() + WIDGET_UPDATE_INTERVAL;
            mSender = PendingIntent.getBroadcast(context, 0, intent, 0);
            mManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            mManager.set(AlarmManager.RTC, firstTime, mSender);
        }

        else if(action.equals("android.appwidget.action.APPWIDGET_DISABLED"))
        {
            removePreviousAlarm();//위젯 삭제시 액티비티를 계속 불러주던 알람도 삭제합니다
        }

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        SharedPreferences sets = context.getSharedPreferences("usersets",0);//MainActivity에서 받아온 sharedpreference의 값들을 받아오기위한 준비입니다
        SharedPreferences timer = context.getSharedPreferences("time",0);//MainActivity에서 받아온 sharedpreference의 값들을 받아오기위한 준비입니다

        appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, getClass()));
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        final int N = appWidgetIds.length;
        for(int i = 0 ; i < N ; i++)
        {
            int appWidgetId = appWidgetIds[i];

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.bigsizefull);//new_app_widget의 objects들의 값을 변경하기위함입니다

            if(timer.getInt("min", 0) != 0){
                views.setTextViewText(R.id.textView1, "타이머 시작하기");
            }

            Calendar now = Calendar.getInstance(); //calendar에서 현재 시각을 받아옵니다

            int hour = now.get(Calendar.HOUR_OF_DAY); //"시"는 hour에 저장합니다

            int min = now.get(Calendar.MINUTE); //"분"은 min에 저장합니다

            views.setTextViewText(R.id.textView1, sets.getString("title", "언젠가는 빛이 될 당신"));//Onupdate에서 받은 sentence의 값을 new_app_widget의 textview1의 ID를 가진 object에 올려줍니다

            //textcolorselcetion이 1이라면..
            if (sets.getInt("color", 0) == 1){
                views.setImageViewResource(R.id.imageView, R.color.white);
                views.setImageViewResource(R.id.imageView2, R.color.white);
                views.setImageViewResource(R.id.imageView4, R.color.white);
                views.setImageViewResource(R.id.imageView5, R.color.white);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 2){
                views.setImageViewResource(R.id.imageView, R.color.black);
                views.setImageViewResource(R.id.imageView2, R.color.black);
                views.setImageViewResource(R.id.imageView4, R.color.black);
                views.setImageViewResource(R.id.imageView5, R.color.black);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 3){
                views.setImageViewResource(R.id.imageView, R.color.claret);
                views.setImageViewResource(R.id.imageView2, R.color.claret);
                views.setImageViewResource(R.id.imageView4, R.color.claret);
                views.setImageViewResource(R.id.imageView5, R.color.claret);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 4){
                views.setImageViewResource(R.id.imageView, R.color.clarett);
                views.setImageViewResource(R.id.imageView2, R.color.clarett);
                views.setImageViewResource(R.id.imageView4, R.color.clarett);
                views.setImageViewResource(R.id.imageView5, R.color.clarett);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 5){
                views.setImageViewResource(R.id.imageView, R.color.clarettt);
                views.setImageViewResource(R.id.imageView2, R.color.clarettt);
                views.setImageViewResource(R.id.imageView4, R.color.clarettt);
                views.setImageViewResource(R.id.imageView5, R.color.clarettt);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 6){
                views.setImageViewResource(R.id.imageView, R.color.red);
                views.setImageViewResource(R.id.imageView2, R.color.red);
                views.setImageViewResource(R.id.imageView4, R.color.red);
                views.setImageViewResource(R.id.imageView5, R.color.red);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 7){
                views.setImageViewResource(R.id.imageView, R.color.redd);
                views.setImageViewResource(R.id.imageView2, R.color.redd);
                views.setImageViewResource(R.id.imageView4, R.color.redd);
                views.setImageViewResource(R.id.imageView5, R.color.redd);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 8){
                views.setImageViewResource(R.id.imageView, R.color.reddd);
                views.setImageViewResource(R.id.imageView2, R.color.reddd);
                views.setImageViewResource(R.id.imageView4, R.color.reddd);
                views.setImageViewResource(R.id.imageView5, R.color.reddd);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 9){
                views.setImageViewResource(R.id.imageView, R.color.pink);
                views.setImageViewResource(R.id.imageView2, R.color.pink);
                views.setImageViewResource(R.id.imageView4, R.color.pink);
                views.setImageViewResource(R.id.imageView5, R.color.pink);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 10){
                views.setImageViewResource(R.id.imageView, R.color.pinkk);
                views.setImageViewResource(R.id.imageView2, R.color.pinkk);
                views.setImageViewResource(R.id.imageView4, R.color.pinkk);
                views.setImageViewResource(R.id.imageView5, R.color.pinkk);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 11){
                views.setImageViewResource(R.id.imageView, R.color.orange);
                views.setImageViewResource(R.id.imageView2, R.color.orange);
                views.setImageViewResource(R.id.imageView4, R.color.orange);
                views.setImageViewResource(R.id.imageView5, R.color.orange);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 12){
                views.setImageViewResource(R.id.imageView, R.color.orangee);
                views.setImageViewResource(R.id.imageView2, R.color.orangee);
                views.setImageViewResource(R.id.imageView4, R.color.orangee);
                views.setImageViewResource(R.id.imageView5, R.color.orangee);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 13){
                views.setImageViewResource(R.id.imageView, R.color.orangeee);
                views.setImageViewResource(R.id.imageView2, R.color.orangeee);
                views.setImageViewResource(R.id.imageView4, R.color.orangeee);
                views.setImageViewResource(R.id.imageView5, R.color.orangeee);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 14){
                views.setImageViewResource(R.id.imageView, R.color.yellow);
                views.setImageViewResource(R.id.imageView2, R.color.yellow);
                views.setImageViewResource(R.id.imageView4, R.color.yellow);
                views.setImageViewResource(R.id.imageView5, R.color.yellow);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 15){
                views.setImageViewResource(R.id.imageView, R.color.yelloww);
                views.setImageViewResource(R.id.imageView2, R.color.yelloww);
                views.setImageViewResource(R.id.imageView4, R.color.yelloww);
                views.setImageViewResource(R.id.imageView5, R.color.yelloww);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 16){
                views.setImageViewResource(R.id.imageView, R.color.green);
                views.setImageViewResource(R.id.imageView2, R.color.green);
                views.setImageViewResource(R.id.imageView4, R.color.green);
                views.setImageViewResource(R.id.imageView5, R.color.green);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 17){
                views.setImageViewResource(R.id.imageView, R.color.greenn);
                views.setImageViewResource(R.id.imageView2, R.color.greenn);
                views.setImageViewResource(R.id.imageView4, R.color.greenn);
                views.setImageViewResource(R.id.imageView5, R.color.greenn);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 18){
                views.setImageViewResource(R.id.imageView, R.color.greennn);
                views.setImageViewResource(R.id.imageView2, R.color.greennn);
                views.setImageViewResource(R.id.imageView4, R.color.greennn);
                views.setImageViewResource(R.id.imageView5, R.color.greennn);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 19){
                views.setImageViewResource(R.id.imageView, R.color.bluegreen);
                views.setImageViewResource(R.id.imageView2, R.color.bluegreen);
                views.setImageViewResource(R.id.imageView4, R.color.bluegreen);
                views.setImageViewResource(R.id.imageView5, R.color.bluegreen);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 20){
                views.setImageViewResource(R.id.imageView, R.color.bluegreenn);
                views.setImageViewResource(R.id.imageView2, R.color.bluegreenn);
                views.setImageViewResource(R.id.imageView4, R.color.bluegreenn);
                views.setImageViewResource(R.id.imageView5, R.color.bluegreenn);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 21){
                views.setImageViewResource(R.id.imageView, R.color.navy);
                views.setImageViewResource(R.id.imageView2, R.color.navy);
                views.setImageViewResource(R.id.imageView4, R.color.navy);
                views.setImageViewResource(R.id.imageView5, R.color.navy);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 22){
                views.setImageViewResource(R.id.imageView, R.color.navyy);
                views.setImageViewResource(R.id.imageView2, R.color.navyy);
                views.setImageViewResource(R.id.imageView4, R.color.navyy);
                views.setImageViewResource(R.id.imageView5, R.color.navyy);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 23){
                views.setImageViewResource(R.id.imageView, R.color.darkblue);
                views.setImageViewResource(R.id.imageView2, R.color.darkblue);
                views.setImageViewResource(R.id.imageView4, R.color.darkblue);
                views.setImageViewResource(R.id.imageView5, R.color.darkblue);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 24){
                views.setImageViewResource(R.id.imageView, R.color.blue);
                views.setImageViewResource(R.id.imageView2, R.color.blue);
                views.setImageViewResource(R.id.imageView4, R.color.blue);
                views.setImageViewResource(R.id.imageView5, R.color.blue);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 25){
                views.setImageViewResource(R.id.imageView, R.color.bluee);
                views.setImageViewResource(R.id.imageView2, R.color.bluee);
                views.setImageViewResource(R.id.imageView4, R.color.bluee);
                views.setImageViewResource(R.id.imageView5, R.color.bluee);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 26){
                views.setImageViewResource(R.id.imageView, R.color.violet);
                views.setImageViewResource(R.id.imageView2, R.color.violet);
                views.setImageViewResource(R.id.imageView4, R.color.violet);
                views.setImageViewResource(R.id.imageView5, R.color.violet);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 27){
                views.setImageViewResource(R.id.imageView, R.color.violett);
                views.setImageViewResource(R.id.imageView2, R.color.violett);
                views.setImageViewResource(R.id.imageView4, R.color.violett);
                views.setImageViewResource(R.id.imageView5, R.color.violett);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 28){
                views.setImageViewResource(R.id.imageView, R.color.violettt);
                views.setImageViewResource(R.id.imageView2, R.color.violettt);
                views.setImageViewResource(R.id.imageView4, R.color.violettt);
                views.setImageViewResource(R.id.imageView5, R.color.violettt);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 29){
                views.setImageViewResource(R.id.imageView, R.color.violetttt);
                views.setImageViewResource(R.id.imageView2, R.color.violetttt);
                views.setImageViewResource(R.id.imageView4, R.color.violetttt);
                views.setImageViewResource(R.id.imageView5, R.color.violetttt);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }

            if(sets.getInt("color", 0) == 30){
                views.setImageViewResource(R.id.imageView, R.color.violettttt);
                views.setImageViewResource(R.id.imageView2, R.color.violettttt);
                views.setImageViewResource(R.id.imageView4, R.color.violettttt);
                views.setImageViewResource(R.id.imageView5, R.color.violettttt);
                views.setTextColor(R.id.textView1, Color.WHITE);
            }


            views.setTextColor(R.id.aa, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.ab, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.ac, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.ba, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.bb, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.bc, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.ca, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.cb, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.cc, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.da, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.db, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.dc, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.ea, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.eb, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.ec, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.fa, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.fb, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.fc, Color.WHITE);

            if(hour == 1 || hour == 13){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.aa, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.aa, Color.WHITE);
                }
            }

            if(hour == 2 || hour == 14){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ba, Color.BLACK);
                    views.setTextColor(R.id.fc, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ba, Color.WHITE);
                }

            }

            if(hour == 3 || hour == 15){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ca, Color.BLACK);
                    views.setTextColor(R.id.fc, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ca, Color.WHITE);
                }
            }

            if(hour == 4 || hour == 16){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.da, Color.BLACK);
                    views.setTextColor(R.id.fc, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.da, Color.WHITE);
                }

            }

            if(hour == 5 || hour == 17){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ea, Color.BLACK);
                    views.setTextColor(R.id.fa, Color.BLACK);
                    views.setTextColor(R.id.fc, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ea, Color.WHITE);
                    views.setTextColor(R.id.fa, Color.WHITE);
                }
            }

            if(hour == 6 || hour == 18){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ab, Color.BLACK);
                    views.setTextColor(R.id.bb, Color.BLACK);
                    views.setTextColor(R.id.fc, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ab, Color.WHITE);
                    views.setTextColor(R.id.bb, Color.WHITE);
                }

            }

            if(hour == 7 || hour == 19){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cb, Color.BLACK);
                    views.setTextColor(R.id.db, Color.BLACK);
                    views.setTextColor(R.id.fc, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cb, Color.WHITE);
                    views.setTextColor(R.id.db, Color.WHITE);
                }
            }

            if(hour == 8 || hour == 20){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.eb, Color.BLACK);
                    views.setTextColor(R.id.fb, Color.BLACK);
                    views.setTextColor(R.id.fc, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.eb, Color.WHITE);
                    views.setTextColor(R.id.fb, Color.WHITE);
                }
            }

            if(hour == 9 || hour == 21){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ac, Color.BLACK);
                    views.setTextColor(R.id.bc, Color.BLACK);
                    views.setTextColor(R.id.fc, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ac, Color.WHITE);
                    views.setTextColor(R.id.bc, Color.WHITE);
                }
            }

            if(hour == 10 || hour == 22){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cc, Color.BLACK);
                    views.setTextColor(R.id.fc, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cc, Color.WHITE);
                }
            }

            if(hour == 11 || hour == 23){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cc, Color.BLACK);
                    views.setTextColor(R.id.dc, Color.BLACK);
                    views.setTextColor(R.id.fc, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cc, Color.WHITE);
                    views.setTextColor(R.id.dc, Color.WHITE);
                }
            }

            if(hour == 12 || hour == 24 || hour == 0){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cc, Color.BLACK);
                    views.setTextColor(R.id.ec, Color.BLACK);
                    views.setTextColor(R.id.fc, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cc, Color.WHITE);
                    views.setTextColor(R.id.ec, Color.WHITE);
                }
            }

            views.setTextColor(R.id.ad, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.ae, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.af, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.bd, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.be, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.bf, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.cd, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.ce, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.cf, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.dd, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.de, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.df, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.ed, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.ee, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.ef, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.fd, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.fe, Color.argb(65, 67, 70, 90));
            views.setTextColor(R.id.ff, Color.argb(65, 67, 70, 90));

            if(min == 1){

                if(sets.getInt("color", 1) == 1)//white
                {
                    views.setTextColor(R.id.be, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.be, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.be, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 2){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ce, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ce, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 3){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.de, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.de, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 4){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ee, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ee, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 5){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.bf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.bf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 6){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.fe, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.fe, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 7){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 8){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.df, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.df, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 9){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ef, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ef, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 10){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 11){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.be, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.be, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 12){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ce, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ce, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 13){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.de, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.de, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 14){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ee, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ee, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 15){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.bf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.bf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 16){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.fe, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.fe, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 17){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.cf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.cf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 18){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.df, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.df, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 19){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ef, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ef, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 20){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 21){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.be, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.be, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 22){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ce, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ce, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 23){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.de, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.de, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 24){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ee, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ee, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 25){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.bf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.bf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 26){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.fe, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.fe, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 27){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.cf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.cf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 28){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.df, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.df, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 29){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ef, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ef, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 30){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 31){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.be, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.be, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 32){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ce, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ce, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 33){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.de, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.de, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 34){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ee, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ee, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 35){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.bf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.bf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 36){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.fe, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.fe, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 37){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.cf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.cf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 38){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.df, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.df, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 39){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ef, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ef, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 40){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 41){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.be, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.be, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 42){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ce, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ce, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 43){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.de, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.de, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 44){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ee, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ee, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 45){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.bf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.bf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 46){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.fe, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.fe, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 47){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.cf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.cf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 48){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.df, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.df, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 49){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ef, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ef, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 50){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 51){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.be, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.be, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 52){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ce, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ce, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 53){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.de, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.de, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 54){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ee, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ee, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 55){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.bf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.bf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 56){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.fe, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.fe, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 57){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.cf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.cf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 58){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.df, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.df, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 59){
                if(sets.getInt("color", 1) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ef, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
                else{
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ef, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
            }

            if(min == 60 || min == 0){

                if(hour == 12)//정오
                {
                    if(sets.getInt("color", 1) == 2)//black
                    {
                        views.setTextColor(R.id.ae, Color.BLACK);
                        views.setTextColor(R.id.af, Color.BLACK);
                    }
                    else{
                        views.setTextColor(R.id.ae, Color.WHITE);
                        views.setTextColor(R.id.af, Color.WHITE);
                    }
                }

                if(hour == 60 || hour ==0)//자정
                {
                    if(sets.getInt("color", 1) == 2)//black
                    {
                        views.setTextColor(R.id.ad, Color.WHITE);
                        views.setTextColor(R.id.ae, Color.BLACK);
                    }
                    else{
                        views.setTextColor(R.id.ad, Color.WHITE);
                        views.setTextColor(R.id.ae, Color.WHITE);
                    }
                }

            }
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    public void home(View v){

    }

    public void removePreviousAlarm()
    {
        if(mManager != null && mSender != null)
        {
            mSender.cancel();
            mManager.cancel(mSender);
        }
    }
}

