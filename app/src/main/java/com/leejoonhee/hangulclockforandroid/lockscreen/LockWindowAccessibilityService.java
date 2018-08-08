package com.leejoonhee.hangulclockforandroid.lockscreen;

import android.accessibilityservice.AccessibilityService;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;

/**
 * Created by andika on 2/25/17.
 */

public class LockWindowAccessibilityService extends AccessibilityService {

    @Override
    protected boolean onKeyEvent(KeyEvent event) {

        LockScreen.getInstance().init(this);
        if(  ((LockApplication) getApplication()).lockScreenShow ){
            // disable home
            if(event.getKeyCode()==KeyEvent.KEYCODE_HOME || event.getKeyCode() == KeyEvent.KEYCODE_DPAD_CENTER){
                return true;
            }
        }

        return super.onKeyEvent(event);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        //Log.d("onAccessibilityEvent","onAccessibilityEvent");
    }

    @Override
    public void onInterrupt() {

    }

}

