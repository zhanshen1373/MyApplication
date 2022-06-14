package com.panpass.myapplication;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dbj on 2021/5/14
 */
public class MyApplication extends Application {


    private static final Stack<WeakReference<Activity>> activityList = new Stack<>();
    private int i;

    @Override
    public void onCreate() {
        super.onCreate();
        i = Process.myPid();
        String mainProcessName = getMainProcessName();
        String packageName = getPackageName();
        if (packageName.equals(mainProcessName)) {
            Log.e("www","主进程初始化");
        }
    }

    private String getMainProcessName() {
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo processInfo:activityManager.getRunningAppProcesses()) {
            if (processInfo.pid == i){
                return processInfo.processName;
            }
        }
        return null;
    }

    /**
     * activity入栈
     * @param activity
     */
    public void pushStack (WeakReference<Activity> activity) {
        if (!activityList.contains(activity))
            activityList.push(activity);
    }

    /**
     * 移除单个activity
     * @param activity
     */
    public void popStackBy(WeakReference<Activity> activity) {
        for (int i = 0; i < activityList.size(); i++) {
            if (activity == activityList.get(i))
            activityList.pop();
        }

    }

    /**
     * 移除所有activity
     */
    public void popStackAll() {
        for (int i = 0; i < activityList.size(); i++) {
            WeakReference<Activity> activity = activityList.get(i);
            Activity activity1 = activity.get();
            if (activity1!=null)
                activity1.finish();
        }
        activityList.clear();
    }

    public Stack<WeakReference<Activity>> showAll() {
        return activityList;
    }

    public   Activity getActivity(WeakReference<Activity> act){

        for (WeakReference<Activity> activity : activityList) {
            Activity activity1 = activity.get();
            Activity activity2 = act.get();
            if(activity1.getPackageName().equals(activity2.getPackageName())){

                return activity1;
            }
        }

        return null;
    }

}
