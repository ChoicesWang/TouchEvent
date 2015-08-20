package com.choices.touchevent;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;


public class CusFrameLayout extends FrameLayout {

    public CusFrameLayout(Context context) {
        super(context);
    }

    public CusFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CusFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 获取当前Layout的名字
     *
     * @return name
     */
    private String getName() {
        switch (getId()) {
            case R.id.red:
                return "Red_Layout";
            case R.id.blue:
                return "Blue_Layout";
            case R.id.yellow:
                return "Yellow_Layout";
            default:
                return "00000";
        }
    }


    private void showLog(String method, String action) {
        Log.d("WoW", getName() + " ---- " + method + " ---- " + action);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                showLog("dispatchTouchEvent()", "ACTION_DOWN");
                if (getId() == R.id.red) {
                    return true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                showLog("dispatchTouchEvent()", "ACTION_MOVE");

                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                showLog("dispatchTouchEvent()", "ACTION_CANCEL & ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                showLog("onInterceptTouchEvent()", "ACTION_DOWN");
//                if (getId() == R.id.blue) {
//                    return true;
//                }
                break;
            case MotionEvent.ACTION_MOVE:
                showLog("onInterceptTouchEvent()", "ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                showLog("onInterceptTouchEvent()", "ACTION_CANCEL & ACTION_UP");
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                showLog("onTouchEvent()", "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                showLog("onTouchEvent()", "ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                showLog("onTouchEvent()", "ACTION_CANCEL & ACTION_UP");
                break;
        }

//        if (getId() == R.id.yellow) {
//            return true;
//        }

        return super.onTouchEvent(ev);
    }
}
