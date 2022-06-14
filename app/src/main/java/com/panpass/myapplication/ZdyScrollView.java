package com.panpass.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class ZdyScrollView extends ScrollView {

    private boolean isBottom;

    public ZdyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZdyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //重写onmeasure方法应该是父类child.measure影响的，如果只在布局中设置大小，不能生效
        int height = MeasureSpec.makeMeasureSpec(200, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, height);
    }
    float y=0;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){

            case MotionEvent.ACTION_DOWN:
                 y = ev.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float y1 = ev.getY();
                if (isBottom && y1 - y < 0) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                if (getScrollY() == 0 && y1 - y > 0) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;

        }
        return super.onTouchEvent(ev);
    }
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (getScrollY()+getHeight()>=getChildAt(0).getHeight()){
            isBottom = true;
        }else{
            isBottom = false;
        }
//        Log.e("www",getScrollY()+"--scrollY");
//        Log.e("www",getHeight()+"--getheight");
//        int height = getChildAt(0).getHeight();
//        Log.e("www",height+"---childheight");
    }
}
