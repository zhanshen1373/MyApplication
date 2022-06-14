package com.panpass.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Layout;
import android.util.AndroidException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;

public class ZdyView extends RelativeLayout {



    public ZdyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
        if (attrs!=null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
            if (typedArray.hasValue(R.styleable.MyView_tt)){
                String string = typedArray.getString(R.styleable.MyView_tt);
                Log.e("www",string);
            }
            if (typedArray.hasValue(R.styleable.MyView_xx)){
                int anInt = typedArray.getInteger(R.styleable.MyView_xx, 0);
                Log.e("www",anInt+"");

            }
            TypedArray typedArray1 = context.obtainStyledAttributes(attrs, R.styleable.www);
            if (typedArray1.hasValue(R.styleable.www_qaz)){
                boolean aBoolean = typedArray1.getBoolean(R.styleable.www_qaz, false);
                Log.e("www",String.valueOf(aBoolean));
            }
            TypedArray typedArray2 = context.obtainStyledAttributes(attrs, R.styleable.wsx);
            if (typedArray2.hasValue(R.styleable.wsx_ccc)) {
                int anInt = typedArray2.getInt(R.styleable.wsx_ccc, 0);
                Log.e("www",String.valueOf(anInt));
            }


        }
    }

    public ZdyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        LayoutInflater.from(context).inflate(R.layout.yy,this,true);
//        setOrientation(VERTICAL);

//        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(180,180);
//        ViewGroup.LayoutParams vi = new ViewGroup.LayoutParams(50,50);
        /*
        TextView tv = new TextView(context);
        tv.setWidth(100);
        tv.setHeight(100);
        tv.setText("wwwww");
        LayoutParams layoutParams = new LayoutParams(30, 30);
        addView(tv,layoutParams);
         */

    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Log.e("www",getWidth()+"width");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int size1 = MeasureSpec.getSize(heightMeasureSpec);

        Log.e("www",getMeasuredWidth()+"measurewidth");

        Log.e("www",size+"viewgroupwidth");
        Log.e("www",getLayoutParams().width+"viewgrouplayoutparamswidth");
        View childAt = getChildAt(0);
//        childAt.post(new Runnable() {
//            @Override
//            public void run() {
//                Log.e("www",childAt.getHeight()+"...");
//            }
//        });
        if (childAt!=null){
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Log.e("www",layoutParams.height+"????");
            Log.e("www",layoutParams.width+"///");
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("www","zdyview--dispatchTouchEvent");
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                Log.e("www","zdyview--dispatchTouchEvent--down");
//                return true;
//            case MotionEvent.ACTION_MOVE:
//                Log.e("www","zdyview--dispatchTouchEvent--move");
//                return false;
//            case MotionEvent.ACTION_UP:
//                Log.e("www","zdyview--dispatchTouchEvent--up");
//                return true;
//        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("www","zdyview--intercept");
        switch (ev.getAction()){

            case MotionEvent.ACTION_DOWN:
                Log.e("www","zdyview--intercept--down");
                return false;
            case MotionEvent.ACTION_MOVE:
                Log.e("www","zdyview--intercept--move");
                return super.onInterceptTouchEvent(ev);
            case MotionEvent.ACTION_UP:
                Log.e("www","zdyview--intercept--up");
                return true;

        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("www","zdyview--ontouchevent");
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                Log.e("www","zdyview--down");
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.e("www","zdyview--move");
                return false;
            case MotionEvent.ACTION_UP:
                Log.e("www","zdyview--up");
                return true;

        }
        return super.onTouchEvent(event);
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }
}
