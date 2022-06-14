package com.panpass.myapplication;

import android.annotation.SuppressLint;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * Description  倒计时帮助
 * Author zhenliang
 * Date   2019/4/22
 **/
public class CountDownHelp {
    private long startTime;
    private CountDownCallback countDownCallback;
    private Disposable subscribe;
    private Disposable disposable;
    private long showTime = 500;

    public CountDownHelp(long startTime) {
        this.startTime = startTime;
    }

    public CountDownHelp(){}

    public void setCountDownCallback(CountDownCallback countDownCallback) {
        this.countDownCallback = countDownCallback;
    }

    @SuppressLint("CheckResult")
    public void countDown() {
        subscribe = Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(startTime + 1)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return startTime - aLong;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (countDownCallback != null) {
                            countDownCallback.countDown(aLong);
                        }
                    }
                });
    }

    public void release() {
        if (subscribe != null && !subscribe.isDisposed()) {
            subscribe.dispose();
        }
        subscribe = null;
        countDownCallback = null;
    }

    public interface CountDownCallback {
        void countDown(long time);
    }

    public void countDownTime(TextView textView, Long time) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
        if (time < 0) {
            return;
        }
        disposable = Observable.interval(1, 1, TimeUnit.SECONDS)
                .take(time)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        showTime = time - aLong - 1;
                        if (showTime >= 0) {
                            textView.setText(showTime+"");
                            if (showTime == 0) {
                                showTime = 500;
                            }
                        }
                    }
                });
    }

    public long getLocalTime(){
        return showTime;
    }

    public void releaseCountDown() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
            disposable = null;
            showTime = 500;
        }
    }

}
