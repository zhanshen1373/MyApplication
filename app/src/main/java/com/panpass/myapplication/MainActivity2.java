package com.panpass.myapplication;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.panpass.myapplication.activity.RecyclerViewActivity;
import com.panpass.myapplication.zdyview.ProgressBarView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private RadioCallManagerAdapter mRadioCallManagerAdapter;
    private TextView textView;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText(msg.what+"");
            progressBar.setProgress(progress);
            progressBar.setSecondaryProgress(secondProgress);
        }
    };
    private final AtomicBoolean mPending = new AtomicBoolean(false);
    private WeakReference weakReference = new WeakReference(this);
    private Chronometer chronometer;
    private ProgressBar progressBar;
    private int progress;
    private int secondProgress;
    private ProgressBarView progressBarView;
    private ProgressBar mmmm;
    private String objectA = "objectA";
    private String objectB = "objectB";
    @Nullable
    @BindView(R.id.ttt)
    TextView ttt;
    @BindView(R.id.spinner)
    Spinner spinner;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ((MyApplication)getApplication()).pushStack(weakReference);
        new Thread(new Runnable() {
            @Override
            public void run() {
                CountDown();
            }
        }, "thread-1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                CountDown();
            }
        }, "thread-2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                CountDown();
            }
        }, "thread-3").start();
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        mRecycleView = findViewById(R.id.lv_call_sequence);
        textView = findViewById(R.id.tv_empty);
        chronometer = findViewById(R.id.Chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime()-60*60*1000*24);
//        chronometer.setCountDown(true);
//        chronometer.setFormat("%");
        chronometer.start();
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
//                if (SystemClock.elapsedRealtime()-chronometer.getBase()>=5*1000){
//                    chronometer.stop();
//                }
            }
        });
//        chronometer.setBase(SystemClock.elapsedRealtime());
        progressBar = findViewById(R.id.progressbar);
        progressBarView = findViewById(R.id.xxxx);
        mmmm = findViewById(R.id.mmmmm);


        //数据源
        ArrayList<String> spinners = new ArrayList<>();
        spinners.add("今日");
        spinners.add("昨日");
        spinners.add("本周");
        spinners.add("上周");
        spinners.add("本月");
        spinners.add("上月");
        //设置ArrayAdapter内置的item样式-这里是单行显示样式
//        R.layout.hhh,R.id.ll,
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,  spinners);
        //这里设置的是Spinner的样式 ， 输入 simple_之后会提示有4人，如果专属spinner的话应该是俩种，在特殊情况可自己定义样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        R.layout.mm
        //设置Adapter了
        spinner.setAdapter(adapter);
        Drawable background = spinner.getBackground();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                progress += 1;
                secondProgress +=2;
                Message obtain = Message.obtain();
                obtain.what = 0;
                handler.sendMessage(obtain);
                progressBarView.setProgress(progress);
            }
        },0,1000);


        Intent intent = getIntent();
        TTbean aa = (TTbean) intent.getSerializableExtra("aa");
//        Log.e("ww",aa.toString());
        mRadioCallManagerAdapter = new RadioCallManagerAdapter(this);
        AViewModel aViewModel = new ViewModelProvider(this).get(AViewModel.class);
        aViewModel.ml.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {

            }
        });
        ArrayList<String> arrayList=new ArrayList();
        for (int i = 0; i < 2; i++) {
            arrayList.add(i+"");
        }

//        ttt = findViewById(R.id.ttt);
        SpannableString spanableInfo = new SpannableString("这是一个测试点击我");
        spanableInfo.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
//                startActivity(new Intent(MainActivity2.this,MainActivity8.class));
                mmmm.setVisibility(View.GONE);
            }


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#44A8F6")); //设置颜色
                ds.setUnderlineText(false);
            }
        }, 4, 6, 0);
        ttt.setText(spanableInfo);
        ttt.setMovementMethod(LinkMovementMethod.getInstance());
        ttt.setHighlightColor(getResources().getColor(android.R.color.transparent));


        try {
            Class<?> aClass = Class.forName("com.panpass.myapplication.MainActivity2");
            Class<? extends MainActivity2> aClass1 = new MainActivity2().getClass();
            Class<MainActivity2> mainActivity2Class = MainActivity2.class;
            if (aClass==aClass1) {
                Log.e("www","yes");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        mRadioCallManagerAdapter.setData(arrayList);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
//        mRecycleView.setHasFixedSize(true);
//        mRecycleView.setNestedScrollingEnabled(false);
        mRecycleView.setAdapter(mRadioCallManagerAdapter);
        mRecycleView.setHasFixedSize(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("bb");
        MyReceiver myReceiver = new MyReceiver();
        registerReceiver(myReceiver,intentFilter);
        textView.setText(3 + "");
        textView.setOnClickListener(v->
                {
//                   arrayList.set(1,"nihao");
//                   mRadioCallManagerAdapter.setData(arrayList);
//                   mRadioCallManagerAdapter.notifyDataSetChanged();
//                    Stack<WeakReference<Activity>> weakReferences = ((MyApplication) getApplication()).showAll();
//                   mRadioCallManagerAdapter.notifyItemChanged(1);
                    Intent intent1 = new Intent(this, RecyclerViewActivity.class);
                    intent1.setFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    startActivity(intent1);
//                   mRadioCallManagerAdapter.notifyItemChanged(1,"lihai");

//                   mRadioCallManagerAdapter.notifyItemInserted(1);

                    /**
                     *    可以保证数据达到效果，即使来回滑动
                     *    mRadioCallManagerAdapter.notifyItemMoved(1,2);
                     *    String a = arrayList.get(1);
                     *    String b = arrayList.get(2);
                     *    arrayList.set(1,b);
                     *    arrayList.set(2,a);
                     *    mRadioCallManagerAdapter.setData(arrayList);
                     *
                     */

//                    sendBroadcast(new Intent().setAction("bb"));
//                    startActivity(new Intent(MainActivity2.this,MainActivity3.class));

//                    mPending.set(true);
//                    if (mPending.compareAndSet(true, false)) {
//                        Log.e("jjj","hhh");
//                    }


//                    Observable.intervalRange(0,10,0,1,TimeUnit.SECONDS)
//                            .subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this, Lifecycle.Event.ON_STOP)))
//                            .subscribe(aLong -> {
//                                        long showTime = aLong ;
//                                        Log.e("jjj",showTime+"???");
//                                    }
//                            );
                }
                );
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int i=5;
//                while (i>0){
//                  handler.sendEmptyMessage(i);
//                  i--;
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();


//          handler.post(new Runnable() {
//              int i=5;
//              @Override
//              public void run() {
//                  textView.setText(i+"");
//                  i--;
//                  handler.postDelayed(this,1000);
//                  if (i==0) {
//                    handler.removeCallbacks(this);
//                }
//              }
//          });

//        Timer timer=new Timer();
//        TimerTask timerTask=new TimerTask() {
//            int i=5;
//            @Override
//            public void run() {
//                handler.sendEmptyMessage(i);
//                i--;
//                if (i==0) {
//                    timer.cancel();
//                }
//            }
//        };
//        timer.schedule(timerTask,0,1000);


//         Observable.interval(1, TimeUnit.SECONDS)
//                .take(50)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this)))
//                .subscribe(aLong -> {
//                            long showTime = aLong ;
//                            Log.e("www",showTime+"???");
//                        }
//                );


//        Observable.interval(1,TimeUnit.SECONDS)
//                .take(0)
//                .doOnNext(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//
//                    }
//                })
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Long value) {
//                       textView.setText("111");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });


    }

    /**
     * 使用锁的必要性是
     * 多个线程共享数据
     * 造成数据错乱
     */
    private int s = 250;
    private void CountDown() {
//        synchronized (objectA) {
//            while (!shutDown) {
//                if (s>=0) {
//                    Log.e("www",Thread.currentThread().getName()+"---"+s);
//                    s--;
//                }
//            }
//        }
    }

    @OnClick(R.id.ccc)
     void wec(){
        Toast.makeText(this,"wwwww",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("www","2activiy-onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("www","2activiy-onresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("www","2activiy-onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("www","2activiy-onstop");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("www","2activity-onnewintent");
    }
    private boolean shutDown = false;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("www","2activity-onDestroy");
        shutDown = true;
//        ((MyApplication)getApplication()).popStackAll();
//        ((MyApplication)getApplication()).popStackBy(weakReference);
    }
}
/**
 *
 *       死锁
 *
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objectA) {
                    Log.e("www","a线程11111");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (objectB) {
                        Log.e("www","a线程22222");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objectB) {
                    Log.e("www","b线程11111");
                    synchronized (objectA) {
                        Log.e("www","b线程22222");
                    }
                }
            }
        }).start();
 */