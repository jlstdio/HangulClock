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
    static class AppWidgetUpdateData extends BroadcastReceiver {
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

    static AppWidgetUpdateData sUpdateData = new AppWidgetUpdateData();

    private static final int ALL_HOUR_IDS[] = {
            R.id.aa, R.id.ba, R.id.ca, R.id.da, R.id.ea, R.id.fa,
            R.id.ab, R.id.bb, R.id.cb, R.id.db, R.id.eb, R.id.fb,
            R.id.ac, R.id.bc, R.id.cc, R.id.dc, R.id.ec, R.id.fc, };

    private static final int[][] HOUR_MAP = {
            {R.id.cc, R.id.ec, R.id.fc, }, // 열두시
            {R.id.aa, R.id.fc, }, // 한시
            {R.id.ba, R.id.fc, }, // 두시
            {R.id.ca, R.id.fc, }, // 세시
            {R.id.da, R.id.fc, }, // 네시
            {R.id.ea, R.id.fa, R.id.fc, }, // 다섯시
            {R.id.ab, R.id.bb, R.id.fc, }, // 여섯시
            {R.id.cb, R.id.db, R.id.fc, }, // 일곱시
            {R.id.eb, R.id.fb, R.id.fc, }, // 여덟시
            {R.id.ac, R.id.bc, R.id.fc, }, // 아홉시
            {R.id.cc, R.id.fc, }, // 열시
            {R.id.cc, R.id.dc, R.id.fc, }, //열한시
    };

    private static final int ALL_MINUTE_IDS[] = {
            R.id.ad, R.id.bd, R.id.cd, R.id.dd, R.id.ed, R.id.fd,
            R.id.ae, R.id.be, R.id.ce, R.id.de, R.id.ee, R.id.fe,
            R.id.af, R.id.bf, R.id.cf, R.id.df, R.id.ef, R.id.ff, };

    private static final int[][] MINUTE1_MAP = {
            {},
            {R.id.fd, }, // 십
            {R.id.bd, R.id.fd, }, // 이십
            {R.id.cd, R.id.fd, }, // 삼십
            {R.id.dd, R.id.fd, }, // 사십
            {R.id.ed, R.id.fd, }, // 오십
    };

    private static final int[][] MINUTE2_MAP = {
            {},
            {R.id.be, }, // 일
            {R.id.ce, }, // 이
            {R.id.de, }, // 삼
            {R.id.ee, }, // 사
            {R.id.bf, }, // 오
            {R.id.fe, }, // 육
            {R.id.cf, }, // 칠
            {R.id.df, }, // 팔
            {R.id.ef, }, // 구
    };

    private static final int COLOR_GRAY = Color.argb(40, 67, 70, 90);

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

            for (int resId: ALL_HOUR_IDS) {
                views.setTextColor(resId, COLOR_GRAY);
            }
            for (int resId: ALL_MINUTE_IDS) {
                views.setTextColor(resId, COLOR_GRAY);
            }

            for (int resId: HOUR_MAP[hour%12]) {
                views.setTextColor(resId, textColor);
            }
            if (hour == 0) {
                views.setTextColor(R.id.ad, textColor); // 자
                views.setTextColor(R.id.ae, textColor); // 정
            } else if (hour == 12) {
                views.setTextColor(R.id.ae, textColor); // 정
                views.setTextColor(R.id.af, textColor); // 오
            }

            for (int resId: MINUTE1_MAP[min/10]) {
                views.setTextColor(resId, textColor);
            }

            for (int resId: MINUTE2_MAP[min%10]) {
                views.setTextColor(resId, textColor);
            }
            if (min != 0) {
                views.setTextColor(R.id.ff, textColor); // 분
            }

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}