package com.leejoonhee.hangulclockforandroid.lockscreen;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.leejoonhee.hangulclockforandroid.R;

import java.util.Calendar;

public class LockScreenActivity extends AppCompatActivity {

    TextView aa;
    TextView ab;
    TextView ac;
    TextView ad;
    TextView ae;
    TextView af;

    TextView ba;
    TextView bb;
    TextView bc;
    TextView bd;
    TextView be;
    TextView bf;

    TextView ca;
    TextView cb;
    TextView cc;
    TextView cd;
    TextView ce;
    TextView cf;

    TextView da;
    TextView db;
    TextView dc;
    TextView dd;
    TextView de;
    TextView df;

    TextView ea;
    TextView eb;
    TextView ec;
    TextView ed;
    TextView ee;
    TextView ef;

    TextView fa;
    TextView fb;
    TextView fc;
    TextView fd;
    TextView fe;
    TextView ff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lock_activity);

        aa = (TextView) findViewById(R.id.aa);
        ab = (TextView) findViewById(R.id.ab);
        ac = (TextView) findViewById(R.id.ac);
        ad = (TextView) findViewById(R.id.ad);
        ae = (TextView) findViewById(R.id.ae);
        af = (TextView) findViewById(R.id.af);

        ba = (TextView) findViewById(R.id.ba);
        bb = (TextView) findViewById(R.id.bb);
        bc = (TextView) findViewById(R.id.bc);
        bd = (TextView) findViewById(R.id.bd);
        be = (TextView) findViewById(R.id.be);
        bf = (TextView) findViewById(R.id.bf);

        ca = (TextView) findViewById(R.id.ca);
        cb = (TextView) findViewById(R.id.cb);
        cc = (TextView) findViewById(R.id.cc);
        cd = (TextView) findViewById(R.id.cd);
        ce = (TextView) findViewById(R.id.ce);
        cf = (TextView) findViewById(R.id.cf);

        da = (TextView) findViewById(R.id.da);
        db = (TextView) findViewById(R.id.db);
        dc = (TextView) findViewById(R.id.dc);
        dd = (TextView) findViewById(R.id.dd);
        de = (TextView) findViewById(R.id.de);
        df = (TextView) findViewById(R.id.df);

        ea = (TextView) findViewById(R.id.ea);
        eb = (TextView) findViewById(R.id.eb);
        ec = (TextView) findViewById(R.id.ec);
        ed = (TextView) findViewById(R.id.ed);
        ee = (TextView) findViewById(R.id.ee);
        ef = (TextView) findViewById(R.id.ef);

        fa = (TextView) findViewById(R.id.fa);
        fb = (TextView) findViewById(R.id.fb);
        fc = (TextView) findViewById(R.id.fc);
        fd = (TextView) findViewById(R.id.fd);
        fe = (TextView) findViewById(R.id.fe);
        ff = (TextView) findViewById(R.id.ff);

                Calendar now = Calendar.getInstance(); //calendar에서 현재 시각을 받아옵니다

                int hour = now.get(Calendar.HOUR_OF_DAY); //"시"는 hour에 저장합니다

                int min = now.get(Calendar.MINUTE); //"분"은 min에 저장합니다

                aa.setTextColor(Color.argb(65, 67, 70, 90));
                ab.setTextColor(Color.argb(65, 67, 70, 90));
                ac.setTextColor(Color.argb(65, 67, 70, 90));
                ba.setTextColor(Color.argb(65, 67, 70, 90));
                bb.setTextColor(Color.argb(65, 67, 70, 90));
                bc.setTextColor(Color.argb(65, 67, 70, 90));
                ca.setTextColor(Color.argb(65, 67, 70, 90));
                cb.setTextColor(Color.argb(65, 67, 70, 90));
                cc.setTextColor(Color.argb(65, 67, 70, 90));
                da.setTextColor(Color.argb(65, 67, 70, 90));
                db.setTextColor(Color.argb(65, 67, 70, 90));
                dc.setTextColor(Color.argb(65, 67, 70, 90));
                ea.setTextColor(Color.argb(65, 67, 70, 90));
                eb.setTextColor(Color.argb(65, 67, 70, 90));
                ec.setTextColor(Color.argb(65, 67, 70, 90));
                fa.setTextColor(Color.argb(65, 67, 70, 90));
                fb.setTextColor(Color.argb(65, 67, 70, 90));
                fc.setTextColor(Color.WHITE);

                SharedPreferences sets = getSharedPreferences("usersets", 0);


                if (hour == 1 || hour == 13) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        aa.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        aa.setTextColor(Color.BLACK);
                    }
                    if (sets.getInt("lock_color", 1) == 3)//pink
                    {
                        aa.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 4)//red
                    {
                        aa.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 5)//orange
                    {
                        aa.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 6)//green
                    {
                        aa.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 7)//bluegreen
                    {
                        aa.setTextColor(Color.WHITE);
                    } else {
                        aa.setTextColor(Color.WHITE);
                    }
                }

                if (hour == 2 || hour == 14) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ba.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ba.setTextColor(Color.BLACK);
                        fc.setTextColor(Color.BLACK);
                    }
                    if (sets.getInt("lock_color", 1) == 3)//pink
                    {
                        ba.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 4)//red
                    {
                        ba.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 5)//orange
                    {
                        ba.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 6)//green
                    {
                        ba.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 7)//bluegreen
                    {
                        ba.setTextColor(Color.WHITE);
                    } else {
                        ba.setTextColor(Color.WHITE);
                    }

                }

                if (hour == 3 || hour == 15) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ca.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ca.setTextColor(Color.BLACK);
                        fc.setTextColor(Color.BLACK);
                    }
                    if (sets.getInt("lock_color", 1) == 3)//pink
                    {
                        ca.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 4)//red
                    {
                        ca.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 5)//orange
                    {
                        ca.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 6)//green
                    {
                        ca.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 7)//bluegreen
                    {
                        ca.setTextColor(Color.WHITE);
                    } else {
                        ca.setTextColor(Color.WHITE);
                    }
                }

                if (hour == 4 || hour == 16) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        da.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        da.setTextColor(Color.BLACK);
                        fc.setTextColor(Color.BLACK);
                    }
                    if (sets.getInt("lock_color", 1) == 3)//pink
                    {
                        da.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 4)//red
                    {
                        da.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 5)//orange
                    {
                        da.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 6)//green
                    {
                        da.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 7)//bluegreen
                    {
                        da.setTextColor(Color.WHITE);
                    } else {
                        da.setTextColor(Color.WHITE);
                    }

                }

                if (hour == 5 || hour == 17) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ea.setTextColor(Color.WHITE);
                        fa.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ea.setTextColor(Color.BLACK);
                        fa.setTextColor(Color.BLACK);
                        fc.setTextColor(Color.BLACK);
                    }
                    if (sets.getInt("lock_color", 1) == 3)//pink
                    {
                        ea.setTextColor(Color.WHITE);
                        fa.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 4)//red
                    {
                        ea.setTextColor(Color.WHITE);
                        fa.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 5)//orange
                    {
                        ea.setTextColor(Color.WHITE);
                        fa.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 6)//green
                    {
                        ea.setTextColor(Color.WHITE);
                        fa.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 7)//bluegreen
                    {
                        ea.setTextColor(Color.WHITE);
                        fa.setTextColor(Color.WHITE);
                    } else {
                        ea.setTextColor(Color.WHITE);
                        fa.setTextColor(Color.WHITE);
                    }
                }

                if (hour == 6 || hour == 18) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ab.setTextColor(Color.WHITE);
                        bb.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ab.setTextColor(Color.BLACK);
                        bb.setTextColor(Color.BLACK);
                        fc.setTextColor(Color.BLACK);
                    }
                    if (sets.getInt("lock_color", 1) == 3)//pink
                    {
                        ab.setTextColor(Color.WHITE);
                        bb.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 4)//red
                    {
                        ab.setTextColor(Color.WHITE);
                        bb.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 5)//orange
                    {
                        ab.setTextColor(Color.WHITE);
                        bb.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 6)//green
                    {
                        ab.setTextColor(Color.WHITE);
                        bb.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 7)//bluegreen
                    {
                        ab.setTextColor(Color.WHITE);
                        bb.setTextColor(Color.WHITE);
                    } else {
                        ab.setTextColor(Color.WHITE);
                        bb.setTextColor(Color.WHITE);
                    }

                }

                if (hour == 7 || hour == 19) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cb.setTextColor(Color.WHITE);
                        db.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cb.setTextColor(Color.BLACK);
                        db.setTextColor(Color.BLACK);
                        fc.setTextColor(Color.BLACK);
                    }
                    if (sets.getInt("lock_color", 1) == 3)//pink
                    {
                        cb.setTextColor(Color.WHITE);
                        db.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 4)//red
                    {
                        cb.setTextColor(Color.WHITE);
                        db.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 5)//orange
                    {
                        cb.setTextColor(Color.WHITE);
                        db.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 6)//green
                    {
                        cb.setTextColor(Color.WHITE);
                        db.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 7)//bluegreen
                    {
                        cb.setTextColor(Color.WHITE);
                        db.setTextColor(Color.WHITE);
                    } else {
                        cb.setTextColor(Color.WHITE);
                        db.setTextColor(Color.WHITE);
                    }
                }

                if (hour == 8 || hour == 20) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        eb.setTextColor(Color.WHITE);
                        fb.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        eb.setTextColor(Color.BLACK);
                        fb.setTextColor(Color.BLACK);
                        fc.setTextColor(Color.BLACK);
                    }
                    if (sets.getInt("lock_color", 1) == 3)//pink
                    {
                        eb.setTextColor(Color.WHITE);
                        fb.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 4)//red
                    {
                        eb.setTextColor(Color.WHITE);
                        fb.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 5)//orange
                    {
                        eb.setTextColor(Color.WHITE);
                        fb.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 6)//green
                    {
                        eb.setTextColor(Color.WHITE);
                        fb.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 7)//bluegreen
                    {
                        eb.setTextColor(Color.WHITE);
                        fb.setTextColor(Color.WHITE);
                    } else {
                        eb.setTextColor(Color.WHITE);
                        fb.setTextColor(Color.WHITE);
                    }
                }

                if (hour == 9 || hour == 21) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ac.setTextColor(Color.WHITE);
                        bc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ac.setTextColor(Color.BLACK);
                        bc.setTextColor(Color.BLACK);
                        fc.setTextColor(Color.BLACK);
                    }
                    if (sets.getInt("lock_color", 1) == 3)//pink
                    {
                        ac.setTextColor(Color.WHITE);
                        bc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 4)//red
                    {
                        ac.setTextColor(Color.WHITE);
                        bc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 5)//orange
                    {
                        ac.setTextColor(Color.WHITE);
                        bc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 6)//green
                    {
                        ac.setTextColor(Color.WHITE);
                        bc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 7)//bluegreen
                    {
                        ac.setTextColor(Color.WHITE);
                        bc.setTextColor(Color.WHITE);
                    } else {
                        ac.setTextColor(Color.WHITE);
                        bc.setTextColor(Color.WHITE);
                    }
                }

                if (hour == 10 || hour == 22) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cc.setTextColor(Color.BLACK);
                        fc.setTextColor(Color.BLACK);
                    }
                    if (sets.getInt("lock_color", 1) == 3)//pink
                    {
                        cc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 4)//red
                    {
                        cc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 5)//orange
                    {
                        cc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 6)//green
                    {
                        cc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 7)//bluegreen
                    {
                        cc.setTextColor(Color.WHITE);
                    } else {
                        cc.setTextColor(Color.WHITE);
                    }
                }

                if (hour == 11 || hour == 23) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cc.setTextColor(Color.WHITE);
                        dc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cc.setTextColor(Color.BLACK);
                        dc.setTextColor(Color.BLACK);
                        fc.setTextColor(Color.BLACK);
                    }
                    if (sets.getInt("lock_color", 1) == 3)//pink
                    {
                        cc.setTextColor(Color.WHITE);
                        dc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 4)//red
                    {
                        cc.setTextColor(Color.WHITE);
                        dc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 5)//orange
                    {
                        cc.setTextColor(Color.WHITE);
                        dc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 6)//green
                    {
                        cc.setTextColor(Color.WHITE);
                        dc.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 7)//bluegreen
                    {
                        cc.setTextColor(Color.WHITE);
                        dc.setTextColor(Color.WHITE);
                    } else {
                        cc.setTextColor(Color.WHITE);
                        dc.setTextColor(Color.WHITE);
                    }
                }

                if (hour == 12 || hour == 24 || hour == 0) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cc.setTextColor(Color.WHITE);
                        ec.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cc.setTextColor(Color.BLACK);
                        ec.setTextColor(Color.BLACK);
                        fc.setTextColor(Color.BLACK);
                    }
                    if (sets.getInt("lock_color", 1) == 3)//pink
                    {
                        cc.setTextColor(Color.WHITE);
                        ec.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 4)//red
                    {
                        cc.setTextColor(Color.WHITE);
                        ec.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 5)//orange
                    {
                        cc.setTextColor(Color.WHITE);
                        ec.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 6)//green
                    {
                        cc.setTextColor(Color.WHITE);
                        ec.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 7)//bluegreen
                    {
                        cc.setTextColor(Color.WHITE);
                        ec.setTextColor(Color.WHITE);
                    } else {
                        cc.setTextColor(Color.WHITE);
                        ec.setTextColor(Color.WHITE);
                    }
                }

                ad.setTextColor(Color.argb(65, 67, 70, 90));
                ae.setTextColor(Color.argb(65, 67, 70, 90));
                af.setTextColor(Color.argb(65, 67, 70, 90));
                bd.setTextColor(Color.argb(65, 67, 70, 90));
                be.setTextColor(Color.argb(65, 67, 70, 90));
                bf.setTextColor(Color.argb(65, 67, 70, 90));
                cd.setTextColor(Color.argb(65, 67, 70, 90));
                ce.setTextColor(Color.argb(65, 67, 70, 90));
                cf.setTextColor(Color.argb(65, 67, 70, 90));
                dd.setTextColor(Color.argb(65, 67, 70, 90));
                de.setTextColor(Color.argb(65, 67, 70, 90));
                df.setTextColor(Color.argb(65, 67, 70, 90));
                ed.setTextColor(Color.argb(65, 67, 70, 90));
                ee.setTextColor(Color.argb(65, 67, 70, 90));
                ef.setTextColor(Color.argb(65, 67, 70, 90));
                fd.setTextColor(Color.argb(65, 67, 70, 90));
                fe.setTextColor(Color.argb(65, 67, 70, 90));
                ff.setTextColor(Color.argb(65, 67, 70, 90));

                if (min == 1) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        be.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        be.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        be.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 2) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ce.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ce.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        ce.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 3) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        de.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        de.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        de.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 4) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ee.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ee.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        ee.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 5) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        bf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        bf.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        bf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 6) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        fe.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        fe.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        fe.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 7) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cf.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        cf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 8) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        df.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        df.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        df.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 9) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ef.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ef.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        ef.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 10) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        fd.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        fd.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        fd.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 11) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        fd.setTextColor(Color.WHITE);
                        be.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        fd.setTextColor(Color.BLACK);
                        be.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        fd.setTextColor(Color.WHITE);
                        be.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 12) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        fd.setTextColor(Color.WHITE);
                        ce.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        fd.setTextColor(Color.BLACK);
                        ce.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        fd.setTextColor(Color.WHITE);
                        ce.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 13) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        fd.setTextColor(Color.WHITE);
                        de.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        fd.setTextColor(Color.BLACK);
                        de.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        fd.setTextColor(Color.WHITE);
                        de.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 14) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        fd.setTextColor(Color.WHITE);
                        ee.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        fd.setTextColor(Color.BLACK);
                        ee.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        fd.setTextColor(Color.WHITE);
                        ee.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 15) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        fd.setTextColor(Color.WHITE);
                        bf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        fd.setTextColor(Color.BLACK);
                        bf.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        fd.setTextColor(Color.WHITE);
                        bf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 16) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        fd.setTextColor(Color.WHITE);
                        fe.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        fd.setTextColor(Color.BLACK);
                        fe.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        fd.setTextColor(Color.WHITE);
                        fe.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 17) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        fd.setTextColor(Color.WHITE);
                        cf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        fd.setTextColor(Color.BLACK);
                        cf.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        fd.setTextColor(Color.WHITE);
                        cf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 18) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        fd.setTextColor(Color.WHITE);
                        df.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        fd.setTextColor(Color.BLACK);
                        df.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        fd.setTextColor(Color.WHITE);
                        df.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 19) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        fd.setTextColor(Color.WHITE);
                        ef.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        fd.setTextColor(Color.BLACK);
                        ef.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        fd.setTextColor(Color.WHITE);
                        ef.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 20) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        bd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 21) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        be.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        bd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        be.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        be.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 22) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ce.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        bd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ce.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ce.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 23) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        de.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        bd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        de.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        de.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 24) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ee.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        bd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ee.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ee.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 25) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        bf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        bd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        bf.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        bf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 26) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        fe.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        bd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        fe.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        fe.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 27) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        cf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        bd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        cf.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        cf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 28) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        df.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        bd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        df.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        df.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 29) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ef.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        bd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ef.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        bd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ef.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 30) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 31) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        be.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        be.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        be.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 32) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ce.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ce.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ce.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 33) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        de.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        de.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        de.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 34) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ee.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ee.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ee.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 35) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        bf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        bf.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        bf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 36) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        fe.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        fe.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        fe.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 37) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        cf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        cf.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        cf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 38) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        df.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        df.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        df.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 39) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ef.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        cd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ef.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        cd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ef.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 40) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        dd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 41) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        be.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        dd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        be.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        be.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 42) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ce.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        dd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ce.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ce.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 43) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        de.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        dd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        de.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        de.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 44) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ee.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        dd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ee.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ee.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 45) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        bf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        dd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        bf.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        bf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 46) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        fe.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        dd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        fe.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        fe.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 47) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        cf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        dd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        cf.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        cf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 48) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        df.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        dd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        df.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        df.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 49) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ef.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        dd.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ef.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        dd.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ef.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 50) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ed.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 51) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        be.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ed.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        be.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        be.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 52) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ce.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ed.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ce.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ce.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 53) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        de.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ed.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        de.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        de.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 54) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ee.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ed.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ee.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ee.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 55) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        bf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ed.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        bf.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        bf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 56) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        fe.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ed.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        fe.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        fe.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 57) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        cf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ed.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        cf.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        cf.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 58) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        df.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ed.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        df.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        df.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 59) {

                    if (sets.getInt("lock_color", 1) == 1)//white
                    {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ef.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                    if (sets.getInt("lock_color", 1) == 2)//black
                    {
                        ed.setTextColor(Color.BLACK);
                        fd.setTextColor(Color.BLACK);
                        ef.setTextColor(Color.BLACK);
                        ff.setTextColor(Color.BLACK);
                    } else {
                        ed.setTextColor(Color.WHITE);
                        fd.setTextColor(Color.WHITE);
                        ef.setTextColor(Color.WHITE);
                        ff.setTextColor(Color.WHITE);
                    }
                }

                if (min == 60 || min == 0) {

                    if (hour == 12)//정오
                    {
                        if (sets.getInt("lock_color", 1) == 1)//white
                        {
                            ae.setTextColor(Color.WHITE);
                            af.setTextColor(Color.WHITE);
                        }
                        if (sets.getInt("lock_color", 1) == 2)//black
                        {
                            ae.setTextColor(Color.BLACK);
                            af.setTextColor(Color.BLACK);
                        } else {
                            ae.setTextColor(Color.WHITE);
                            af.setTextColor(Color.WHITE);
                        }
                    }

                    if (hour == 60 || hour == 0)//자정
                    {
                        if (sets.getInt("lock_color", 1) == 1)//white
                        {
                            ad.setTextColor(Color.WHITE);
                            ae.setTextColor(Color.WHITE);
                        }
                        if (sets.getInt("lock_color", 1) == 2)//black
                        {
                            ad.setTextColor(Color.WHITE);
                            ae.setTextColor(Color.BLACK);
                        } else {
                            ad.setTextColor(Color.WHITE);
                            ae.setTextColor(Color.WHITE);
                        }
                    }

                }
            }


    public void unlock(View v) {
        finish();
    }

    @Override
    public void onAttachedToWindow() {

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON |
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
//                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON|
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        super.onAttachedToWindow();

    }

    @Override
    protected void onResume() {
        super.onResume();
        ((LockApplication) getApplication()).lockScreenShow = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        ((LockApplication) getApplication()).lockScreenShow = false;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return false;
    }


}
