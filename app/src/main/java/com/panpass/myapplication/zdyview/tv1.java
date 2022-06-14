package com.panpass.myapplication.zdyview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

/**
 * 反选背景色改变的textview
 */
public class tv1 extends androidx.appcompat.widget.AppCompatTextView implements View.OnClickListener {

    private onBackStatusListener onBackStatusListener;
    private boolean isClick;

    public tv1(@NonNull Context context) {
        super(context);
        setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(217,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,5,30,5);
        setLayoutParams(layoutParams);
        setOnClickListener(this);
        updateBackground();
    }

    public void setOnBackStatusListener(onBackStatusListener onBackStatusListener) {
        this.onBackStatusListener = onBackStatusListener;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    private void updateBackground() {
        if (isClick) {
            //淡黄背景
            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadii(new float[]{(float) 33.0, (float) 33.0, (float) 33.0, (float) 33.0,
                    (float) 33.0, (float) 33.0, (float) 33.0, (float) 33.0});
            drawable.setColor(-3649);
            drawable.setStroke(0, -3649);
            setBackground(drawable);
            setTextColor(Color.parseColor("#00FF00"));
        } else {
            //灰色背景
            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadii(new float[]{(float) 33.0, (float) 33.0,(float) 33.0, (float) 33.0,
                    (float) 33.0, (float) 33.0,(float) 33.0, (float) 33.0});
            drawable.setColor(-657931);
            drawable.setStroke(0, -657931);
            setBackground(drawable);
            setTextColor(Color.parseColor("#333333"));
        }
    }

    @Override
    public void onClick(View v) {
        if (isClick){
            isClick = false;
            onBackStatusListener.onBackStatus(isClick);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadii(new float[]{(float) 33.0, (float) 33.0,(float) 33.0, (float) 33.0,
                    (float) 33.0, (float) 33.0,(float) 33.0, (float) 33.0});
            drawable.setColor(-657931);
            drawable.setStroke(0, -657931);
            setBackground(drawable);
            setTextColor(Color.parseColor("#000000"));
        } else {
            isClick = true;
            onBackStatusListener.onBackStatus(isClick);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadii(new float[]{(float) 33.0, (float) 33.0,(float) 33.0, (float) 33.0,
                    (float) 33.0, (float) 33.0,(float) 33.0, (float) 33.0});
            drawable.setColor(-3649);
            drawable.setStroke(0, -3649);
            setBackground(drawable);
            setTextColor(Color.parseColor("#00FF00"));
        }
    }
    public interface onBackStatusListener {
        void onBackStatus(boolean clicked);
    }
}
    /**
     *  使用的例子
     *  增加了单选功能。只有1个有选中的背景色
     *                 tv1 x1 = new tv1(activity);
     *                 x1.setText("全部");
     *
     *                 tv1 x2 = new tv1(activity);
     *                 x2.setText("否");
     *
     *                 tv1 x3 = new tv1(activity);
     *                 x3.setText("是");
     *
     *                 vvvv.addView(x1);
     *                 vvvv.addView(x2);
     *                 vvvv.addView(x3);
     *                 for (int i = 0; i < vvvv.getChildCount(); i++) {
     *         tv1 childAt = (tv1) vvvv.getChildAt(i);
     *         childAt.setOnBackStatusListener(new onBackStatusListener() {
     * @Override
     * public void onBackStatus(boolean clicked) {
     *         childAt.setClick(clicked);
     *         if (clicked) {
     *         for (int k = 0 ; k < vvvv.getChildCount(); k++) {
     *         tv1 tempView = (tv1) vvvv.getChildAt(k);
     *         if (childAt != tempView) {
     *         tempView.isClick = false;
     *         tempView.updateBackground();
     *         }
     *         }
     *
     *         }
     *
     *         }
     *         });
     *         }
     *
     *
     */




