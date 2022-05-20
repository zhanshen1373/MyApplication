package com.panpass.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class BlankView extends View {
    public BlankView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public BlankView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("www","this is blankview--dispatch");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("www","this is blankview--touchevent");
        return true;
    }
}
