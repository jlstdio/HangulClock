package com.leejoonhee.hangulclockforandroid;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;

import android.widget.RemoteViews;

import java.util.Calendar;
import java.util.HashSet;


/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {
    static final int PREF_COLOR_WHITE = 1;
    static final int PREF_COLOR_BLACK = 2;
    static final int PREF_COLOR_DEFAULT = PREF_COLOR_WHITE;

    private static final String TAG = "AppWidget";

    /* AppWidgetProvider 의 인스턴스는 호출될 때 마다 생성되므로
     * static class에서 일괄적으로 처리하도록 해야합니다.
     */
    private static class AppWidgetUpdateData extends BroadcastReceiver {
        private Context mContext = null;
        private AppWidgetManager mManager = null;
        private HashSet<Integer> mViewIds = new HashSet<>();
        private boolean mTickEnabled = false;

        AppWidgetUpdateData () {

        }

        void update() {
            int [] viewIds = new int[mViewIds.size()];
            Integer[] ids = new Integer[mViewIds.size()];
            mViewIds.toArray(ids);

            String msg = "view ids (";
            for (int i = 0; i < viewIds.length; i++) {
                viewIds[i] = ids[i];
                msg += ids[i] + ", ";
            }
            Log.v(TAG, msg + " ) will be updated");

            updateWidgets(mContext, mManager, viewIds);
        }

        void onUpdate(Context context, AppWidgetManager manager, int[] viewIds) {
            mContext = context.getApplicationContext();
            mManager = manager;
            String msg = "update view ids (";
            for (int i: viewIds) {
                mViewIds.add(i);
                msg += i + ", ";
            }
            Log.v(TAG, msg + " ) will be combined");
            update();
            subscribeTick();
        }

        void onDeleted(Context context, int[] viewIds) {
            mContext = context.getApplicationContext();
            for(int i: viewIds) {
                mViewIds.remove(i);
            }
            subscribeTick();
        }

        /* 1분마다 시계를 업데이트해야 하므로, TIME_TICK 인텐트를 이용해서 업데이트 하도록 합니다. */
        private static final IntentFilter TICK_INTENT_FILTER = new IntentFilter(Intent.ACTION_TIME_TICK);

        void subscribeTick() {
            boolean hasIds = !mViewIds.isEmpty();
            if (hasIds && !mTickEnabled) {
                mContext.registerReceiver(this, TICK_INTENT_FILTER);
                mTickEnabled = true;
                Log.v(TAG, "tick registered");
            } else if (mTickEnabled && !hasIds) {
                mContext.unregisterReceiver(this);
                mTickEnabled = false;
                Log.v(TAG, "tick unregistered");
            }
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            if (Intent.ACTION_TIME_TICK.equals(intent.getAction())) {
                update();
            }
        }
    }

    private static AppWidgetUpdateData sUpdateData = new AppWidgetUpdateData();

    @Override
    public void onEnabled(Context context) {
        Log.d(TAG, "enabled: " + this);
    }

    @Override
    public void onDisabled(Context context) {
        Log.d(TAG, "disabled: " + this);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.d(TAG, "update: " + this + " ids: " + appWidgetIds.length);
        sUpdateData.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Log.d(TAG, "deleted: " + this + " ids: " + appWidgetIds.length);
        sUpdateData.onDeleted(context, appWidgetIds);
    }

    static private void updateWidgets(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.d(TAG, "updateWidgets");
        SharedPreferences sets = context.getSharedPreferences("usersets",0);//MainActivity에서 받아온 sharedpreference의 값들을 받아오기위한 준비입니다

        final int N = appWidgetIds.length;
        for(int i = 0 ; i < N ; i++)
        {
            int appWidgetId = appWidgetIds[i];
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);//new_app_widget의 objects들의 값을 변경하기위함입니다

            Calendar now = Calendar.getInstance(); //calendar에서 현재 시각을 받아옵니다
            int hour = now.get(Calendar.HOUR_OF_DAY); //"시"는 hour에 저장합니다
            int min = now.get(Calendar.MINUTE); //"분"은 min에 저장합니다

            views.setTextViewText(R.id.textView1, sets.getString("title", "title"));//Onupdate에서 받은 sentence의 값을 new_app_widget의 textview1의 ID를 가진 object에 올려줍니다

            final int prefColor = sets.getInt("color", PREF_COLOR_DEFAULT);
            int textColor = -1;
            switch (prefColor) {
                case PREF_COLOR_WHITE:
                    //textcolorselcetion이 1이라면..
                    textColor = Color.WHITE;
                    views.setImageViewResource(R.id.board, R.drawable.hangulclock_board_white);

                    break;
                case PREF_COLOR_BLACK:
                    //textcolorselcetion이 2라면..
                    textColor = Color.BLACK;
                    views.setImageViewResource(R.id.board, R.drawable.hangulclock_board_black);
            }
            views.setTextColor(R.id.textView1, textColor);

            views.setTextColor(R.id.aa, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.ab, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.ac, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.ba, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.bb, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.bc, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.ca, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.cb, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.cc, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.da, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.db, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.dc, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.ea, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.eb, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.ec, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.fa, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.fb, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.fc, Color.argb(40, 67, 70, 90));

            switch (hour % 12) {
                case 1:
                    views.setTextColor(R.id.aa, textColor);
                    views.setTextColor(R.id.fc, textColor);
                    break;
                case 2:
                    views.setTextColor(R.id.ba, textColor);
                    views.setTextColor(R.id.fc, textColor);
                    break;
                case 3:
                    views.setTextColor(R.id.ca, textColor);
                    views.setTextColor(R.id.fc, textColor);
                    break;
                case 4:
                    views.setTextColor(R.id.da, textColor);
                    views.setTextColor(R.id.fc, textColor);
                    break;
                case 5:
                    views.setTextColor(R.id.ea, textColor);
                    views.setTextColor(R.id.fa, textColor);
                    views.setTextColor(R.id.fc, textColor);
                    break;
                case 6:
                    views.setTextColor(R.id.ab, textColor);
                    views.setTextColor(R.id.bb, textColor);
                    views.setTextColor(R.id.fc, textColor);
                    break;
                case 7:
                    views.setTextColor(R.id.cb, textColor);
                    views.setTextColor(R.id.db, textColor);
                    views.setTextColor(R.id.fc, textColor);
                    break;
                case 8:
                    views.setTextColor(R.id.eb, textColor);
                    views.setTextColor(R.id.fb, textColor);
                    views.setTextColor(R.id.fc, textColor);
                    break;
                case 9:
                    views.setTextColor(R.id.ac, textColor);
                    views.setTextColor(R.id.bc, textColor);
                    views.setTextColor(R.id.fc, textColor);
                    break;
                case 10:
                    views.setTextColor(R.id.cc, textColor);
                    views.setTextColor(R.id.fc, textColor);
                    break;
                case 11:
                    views.setTextColor(R.id.cc, textColor);
                    views.setTextColor(R.id.dc, textColor);
                    views.setTextColor(R.id.fc, textColor);
                    break;
                case 0:
                    views.setTextColor(R.id.cc, textColor);
                    views.setTextColor(R.id.ec, textColor);
                    views.setTextColor(R.id.fc, textColor);
                    break;
                default:
                    break;
            }

            views.setTextColor(R.id.ad, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.ae, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.af, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.bd, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.be, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.bf, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.cd, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.ce, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.cf, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.dd, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.de, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.df, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.ed, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.ee, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.ef, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.fd, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.fe, Color.argb(40, 67, 70, 90));
            views.setTextColor(R.id.ff, Color.argb(40, 67, 70, 90));

            if(min == 1){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.be, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.be, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 2){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.ce, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.ce, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 3){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.de, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.de, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 4){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.ee, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.ee, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 5){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.bf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.bf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 6){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.fe, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.fe, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 7){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.cf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.cf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 8){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.df, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.df, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 9){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.ef, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.ef, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 10){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 11){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.be, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.be, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 12){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ce, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ce, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 13){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.de, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.de, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 14){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ee, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ee, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 15){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.bf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.bf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 16){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.fe, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.fe, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 17){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.cf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.cf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 18){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.df, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.df, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 19){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ef, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ef, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 20){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 21){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.be, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.be, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);

                }
            }

            if(min == 22){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ce, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ce, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 23){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.de, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.de, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 24){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ee, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ee, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 25){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.bf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.bf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 26){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.fe, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.fe, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 27){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.cf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.cf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 28){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.df, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.df, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 29){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.bd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ef, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.bd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ef, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 30){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 31){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.be, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.be, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 32){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ce, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ce, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 33){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.de, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.de, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 34){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ee, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ee, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 35){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.bf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.bf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 36){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.fe, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.fe, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 37){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.cf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.cf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 38){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.df, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.df, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 39){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.cd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ef, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ef, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 40){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.cd, Color.argb(40, 67, 70, 90));
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.cd, Color.argb(40, 67, 70, 90));
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 41){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.be, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.be, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 42){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ce, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ce, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 43){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.de, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.de, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 44){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ee, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ee, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 45){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.bf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.bf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 46){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.fe, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.fe, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 47){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.cf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.cf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 48){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.df, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.df, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 49){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.dd, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ef, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.dd, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ef, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 50){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 51){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.be, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.be, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 52){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ce, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ce, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 53){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.de, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.de, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 54){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ee, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ee, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 55){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.bf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.bf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 56){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.fe, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.fe, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 57){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.cf, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.cf, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 58){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.df, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.df, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 59){

                if(sets.getInt("color", 0) == 1)//white
                {
                    views.setTextColor(R.id.ed, Color.WHITE);
                    views.setTextColor(R.id.fd, Color.WHITE);
                    views.setTextColor(R.id.ef, Color.WHITE);
                    views.setTextColor(R.id.ff, Color.WHITE);
                }
                if(sets.getInt("color", 0) == 2)//black
                {
                    views.setTextColor(R.id.ed, Color.BLACK);
                    views.setTextColor(R.id.fd, Color.BLACK);
                    views.setTextColor(R.id.ef, Color.BLACK);
                    views.setTextColor(R.id.ff, Color.BLACK);
                }
            }

            if(min == 60 || min == 0){

                if(hour == 12)//정오
                {
                    if(sets.getInt("color", 0) == 1)//white
                    {
                        views.setTextColor(R.id.ae, Color.WHITE);
                        views.setTextColor(R.id.af, Color.WHITE);
                    }
                    if(sets.getInt("color", 0) == 2)//black
                    {
                        views.setTextColor(R.id.ae, Color.BLACK);
                        views.setTextColor(R.id.af, Color.BLACK);

                    }
                }

                if(hour == 60 || hour ==0)//자정
                {
                    if(sets.getInt("color", 0) == 1)//white
                    {
                        views.setTextColor(R.id.ad, Color.WHITE);
                        views.setTextColor(R.id.ae, Color.WHITE);
                    }
                    if(sets.getInt("color", 0) == 2)//black
                    {
                        views.setTextColor(R.id.ad, Color.WHITE);
                        views.setTextColor(R.id.ae, Color.BLACK);

                    }
                }

            }
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}

