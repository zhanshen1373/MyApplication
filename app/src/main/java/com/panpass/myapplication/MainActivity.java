package com.panpass.myapplication;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.panpass.myapplication.bean.RecyclerViewUseBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private int[] a;
    private int n =0;
    private String name = "name";
    private String gender = "gender";
    private AtomicReference<A[]> mn;
    private int q=-1;
    private int p=1;
    private MainActivity.serviceConnect serviceConnect;
    private LinearLayout bottom_ll;
    private EditText edit;
    private Bitmap bitmap;

    @SuppressLint("AutoDispose")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication application = (MyApplication) getApplication();
        WeakReference weakReference = new WeakReference(this);
        application.pushStack(weakReference);
        setContentView(R.layout.activity_main);

        ArrayList<String> xxx = new ArrayList<>();
        xxx.add("7");
        xxx.add("2");
        if (xxx.contains("7"))
            Log.e("www","222222");
        String bbb = "17|8|0";
        if (bbb.contains("7"))
            Log.e("www","111111");
        new MainActivity.A(5);
        //输出的还是A的write();
        ((B)new A(2)).write();
        new B(3);
        a = new int[3];
        a[++n]=1;
        q = p++;
        Log.e("www","q的值是"+q);
        if (1==1)
            Log.e("www","1111111");
        else
            Log.e("www","222222");
        double v1 = -1;
        try {
             v1 = Double.parseDouble("0.00");
        } catch (Exception e) { }
        if (v1==0) {
            Log.e("www","异常");
        } else {
            Log.e("www","正常");
        }
        Log.e("www",a[0]+"--length");
        Log.e("www",a[1]+"--length");
        int www = (int) 5.2;
        TTbean t = new TTbean(Parcel.obtain());
        t.setName("my name");
        TTbean.setInstance(t);
        Log.e("www", t.getName()+"");
        bottom_ll = findViewById(R.id.linear);
        TextView tv1 = new TextView(this);
        tv1.setText("1");
        addButton(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText("2");
        addButton(tv2);
        RecyclerViewUseBean bean1 = new RecyclerViewUseBean();
        bean1.setFieldName("field1");
        bean1.setRealName("张三");
        bean1.setOrder(2);
        RecyclerViewUseBean bean2 = new RecyclerViewUseBean();
        bean2.setFieldName("field2");
        bean2.setRealName("王五");
        bean2.setOrder(3);
        RecyclerViewUseBean bean3 = new RecyclerViewUseBean();
        bean3.setFieldName("field3");
        bean3.setRealName("李四");
        bean3.setOrder(1);
        ArrayList<RecyclerViewUseBean> li = new ArrayList<RecyclerViewUseBean>();
        li.add(bean1);
        li.add(bean2);
        li.add(bean3);
        double aaa = 1999999512;
        Log.e("www",aaa+"---");

        Wx wsx = new Gson().fromJson("{\"a\":\"1\"}", Wx.class);
        Log.e("www",wsx.getX());
        Log.e("www",wsx.getQqq()+"...");
        Log.e("www",new Wx("bb",1).getQqq()+"...");


        View inflate = LayoutInflater.from(this).inflate(R.layout.mm, null);
        Dialog dialog = new Dialog(this, R.style.Theme_AppCompat);
        Window window = dialog.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.dimAmount = 0.7f;
        lp.gravity = Gravity.CENTER;
        window.setAttributes(lp);
        dialog.addContentView(inflate,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        edit = findViewById(R.id.edit);
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//              15607145693
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //0000000000 9999999999 ..........

               if (!TextUtils.isEmpty(s)){
//                 if (s.toString().contains(".")){
//                     if (s.length() - s.toString().indexOf(".") > 3) {
//                         CharSequence charSequence = s.toString().subSequence(0, s.length() - 1);
//                         edit.setText(charSequence);
//                     }
//                 }
//                   if (s.toString().contains("。")) {
//                       String replace = s.toString().replace("。", ".");
//                       edit.setText(replace);
//                   }


               }

            }
        });


//        Collator instance = Collator.getInstance(Locale.CHINA);
//        Collections.sort(li, new Comparator<RecyclerViewUseBean>() {
//            @Override
//            public int compare(RecyclerViewUseBean o1, RecyclerViewUseBean o2) {
//                return instance.compare(o1.getRealName(),o2.getRealName());
//            }
//        });
//        Collections.sort(li);





        findViewById(R.id.iiii).setOnClickListener(v->
        {
            Log.e("www",Double.parseDouble(edit.getText().toString())+"----");
            if (aaa > Double.parseDouble(edit.getText().toString())) {
                Log.e("www", "大于");
            } else {
                Log.e("www", "小于");
            }
        });

        BehaviorSubject<String> objectPublishSubject = BehaviorSubject.create();
//        objectPublishSubject.onComplete();
        objectPublishSubject.onNext("1");

        objectPublishSubject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e("www", "接收到的数据是" + s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.e("www", "这里是完成complete");
            }
        }, new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
//                 disposable.dispose();
            }
        });
        objectPublishSubject.onNext("2");
        objectPublishSubject.subscribe(new io.reactivex.Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.e("www", "subscibe的数据是" + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        /*
        ArrayList<HashMap<String,Boolean>>  threadlists = new ArrayList<>();
        ArrayList<Thread> tt = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            HashMap hh = new HashMap();
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    hh.put(Thread.currentThread().getName(), true);
                }
            }, "name" + i);
            hh.put(thread.getName(),false);
            tt.add(thread);
            threadlists.add(hh);
        }
        for (int i=0;i<tt.size();i++){
            tt.get(i).start();
        }
        for (int i=0;i<threadlists.size();i++){
            HashMap<String,Boolean> m= threadlists.get(i);
            Iterator iterator = m.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry next = (Map.Entry) iterator.next();
                Log.e("www",next.getKey()+"--key--"+next.getValue()+"--value--");
            }
            Iterator iterator1 = m.keySet().iterator();
            while (iterator1.hasNext()){
                String key = (String) iterator1.next();
                Log.e("www",key+"--key--"+m.get(key)+"--value--");
            }
            for (Boolean value:m.values()){
                Log.e("www",value+"--value--");
            }
        }
       */

//        GlideApp.with(this).load(R.drawable.ic_launcher_background);
//        Glide.with(this)
//                .load("http://henan.china.com.cn/pic/2021-11/20/2a2f631e-575c-4ee9-84ec-35ae9be4d83d.jpeg")
//                .into((ImageView) findViewById(R.id.iiii));

//        EventBus.getDefault().register(this);
        /** 证明了子线程中可以写入数据
        File file = new File(getCacheDir(),"a.txt");
        String content = "this is content";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(content.getBytes());
                    fileOutputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        */


       /*
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Log.e("www","interceptor");
                        return  chain.proceed(chain.request());
                    }
                })
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Log.e("www","networkinterceptor");
                        return chain.proceed(chain.request());
                    }
                }).build();
        Request request = new Request.Builder().
                url("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%AD%99%E4%B8%80%E5%AE%81&hs=0&pn=5&spn=0&di=188430&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=398057975%2C1483705804&os=3360541148%2C902768142&simid=398057975%2C1483705804&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=%E5%AD%99%E4%B8%80%E5%AE%81&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Fnimg.ws.126.net%2F%3Furl%3Dhttp%3A%2F%2Fdingyue.ws.126.net%2F2021%2F0624%2Ff0f39723j00qv7dfu0055c000pb0190c.jpg%26thumbnail%3D650x2147483647%26quality%3D80%26type%3Djpg%26refer%3Dhttp%3A%2F%2Fnimg.ws.126.net%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1644835116%26t%3Df0634693abca66a1021ec7349bca01bb&fromurl=ippr_z2C%24qAzdH3FAzdH3F1y_z%26e3B8mn_z%26e3Bv54AzdH3Fw6ptvsjAzdH3FGDlFFDRRac9b88WY_z%26e3Bip4s&gsm=6&islist=&querylist=&dyTabStr=MCwzLDQsNSwxLDcsNiwyLDgsOQ%3D%3D").
                get().
                build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("www",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("www",response.toString());
            }
        });
    */

//        SharedPreferences a = getSharedPreferences("a", MODE_PRIVATE);
//        SharedPreferences.Editor edit = a.edit();
//        edit.putBoolean("name",true);
//        edit.apply();


        /*
        HandlerThread handlerThread = new HandlerThread("name");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.e("www","11111");
                pp();
            }
        };
        handler.sendEmptyMessage(0);
        */
        TypeToken<HashMap<Integer,String>> typeToken = new TypeToken<HashMap<Integer,String>>() {
        };


        //getType==HashMap<Integer,String>;getRawType==HashMap
        Log.e("www",typeToken.getType()+"--type--"+typeToken.getRawType()+"--raw");

        Log.e("www",Thread.currentThread().getId()+"--id--");
//        try {
//            throw new NullPointerException("nullpoint");
//        } catch (Exception e) {
//            e.fillInStackTrace();
//            Log.e("www", "sss", e);
//            Log.e("www", Log.getStackTraceString(e));
//        }
        //如果同一个observer多次注册，return出去，不能实现观察者的功能
        AViewModel aViewModel = new ViewModelProvider(this).get(AViewModel.class);
        aViewModel.ml.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.e("www","收到数据了"+integer);
            }
        });


       /*
        for (int i=0;i<10;i++){
            Log.e("www","1111");
            Log.e("www","2222");
            handler的任务会排队主线程阻塞的时间
           new Handler().post(new Runnable() {
               @Override
               public void run() {
                   Log.e("www","3333");
                   Log.e("www","4444");
               }
           });
        }
       */


        run r = new run();


        new Thread(){
            @Override
            public void run() {
                super.run();
//                while (true){
//                    Log.e("www","iiiiiii");
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }

//                jj();

            }
        }.start();

   Thread ss = new Thread(new Runnable() {
       @Override
       public void run() {

           synchronized (MainActivity.this.name){
               Log.e("www","mmmm");
               try {
                   MainActivity.this.name.wait(2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
   });
   ss.start();
//ss.interrupt();


        new Thread(r,"thread-1").start();
        new Thread(r,"thread-2").start();


        new Handler().post(new Runnable() {
            @Override
            public void run() {

            }
        });




        tv = findViewById(R.id.tv);
        tv.setTextColor(Color.parseColor("#fffdc915"));
        ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) tv.getLayoutParams();
//        layoutParams.width = 100;
//        tv.setLayoutParams(layoutParams);
//        tv.measure(10,10);

        Log.e("www",layoutParams.width+"--measuredwidth");
        Log.e("www",tv.getWidth()+"--width");

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("aa");
        MyReceiver myReceiver = new MyReceiver();
        registerReceiver(myReceiver, intentFilter);


        Intent intent = new Intent(this,MyService.class);
//        startService(intent);
        serviceConnect = new serviceConnect();
        bindService(intent, serviceConnect,BIND_AUTO_CREATE);
        TransportBean.getInstance().setOld(1).setName("q");
        File file =  new File(getCacheDir(),"b.txt");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(TransportBean.getInstance());
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
        BitmapBinder bitmapBinder = new BitmapBinder(bitmap);
        Bundle bundle = new Bundle();
        bundle.putBinder("binder",bitmapBinder);



        findViewById(R.id.tv).setOnClickListener(v ->{
                     findViewById(R.id.iiii).setVisibility(View.VISIBLE);

//            Intent intent = new Intent();
//            intent.setAction("aa");
//            sendBroadcast(intent);

//            stopService(intent);
//            unbindService(serviceConnect);
//            handler.sendEmptyMessage(0);

                    Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);

//                    tt.setOld(1);
//                    intent1.putExtra("aa",tt);
//                    intent1.putExtra("trans",TransportBean.getInstance());
//                    intent1.putExtra("p",t);
//                    intent1.putExtras(bundle);
                    startActivity(intent1);

//                    Intent intent = new Intent(this,MyService.class);
//                    bindService(intent,new serviceConnect(),)
                }
//                Log.e("www",aViewModel.ml.getValue()+"second")
    );


    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void a(String msg){
//        if ("xxx".equals(msg))
//            finish();
//    }

    private void jj() throws Exception{
//        throw new NullPointerException();
//        Log.e("www","不走了");
    }

    private void addButton(TextView textView) {
        textView.setTextSize(16);
        textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f));
        textView.setGravity(Gravity.CENTER);
        bottom_ll.addView(textView);
    }



   private void pp(){
        //不同线程中的代码可以同步执行；同一线程中的代码顺序执行
        Log.e("www",Thread.currentThread().getName());
        Log.e("www","1111");
        Log.e("www","2222");
        Log.e("www","3333");
       try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }



//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.e("www","dispatchtouchevent");
//        return super.dispatchTouchEvent(ev);
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//
//            case MotionEvent.ACTION_DOWN:
//                Log.e("www","down");
//                return true;
//            case MotionEvent.ACTION_MOVE:
//                Log.e("www","move");
//                return true;
//            case MotionEvent.ACTION_UP:
//                break;
//
//        }
//        return super.onTouchEvent(event);
//    }


   static class A extends B {

        private int a;

        public A(int a) {
            super(a);
        }

       @Override
       protected void write() {
           Log.e("www","这里是A");
       }
   }

    public static class B {

        private int b;

        public B(int b) {
            Log.e("www", this.getClass().getSimpleName() + "" + b);
        }
        //内部类、外部类都是一个类中
        protected void write(){
            Log.e("www", "可以调用到我");
        }
    }

    class run implements Runnable{

        @Override
        public void run() {


//            synchronized (name){
//                Log.e("www",Thread.currentThread().getName()+"---name");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            synchronized (gender){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Log.e("www",Thread.currentThread().getName()+"---gender");
//            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver();
        Log.e("www","ondestroy");
//        unbindService(serviceConnect);
    }



    PictureAidlInterface pictureAidlInterface;
    class serviceConnect implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {


            //发送数据给服务端进程
            Parcel data = Parcel.obtain();
            Parcel replay = Parcel.obtain();
            if (service != null) {
                try {
                    data.writeString("hello");
                    //发送数据到服务端进程
                    service.transact(1, data, replay, 0);
                    replay.readException();
                } catch (RemoteException e) {
                    e.printStackTrace();
                } finally {
                    replay.recycle();
                    data.recycle();
                }
            }


//            pictureAidlInterface = PictureAidlInterface.Stub.asInterface(service);
//            try {
//                pictureAidlInterface.setPicture(bitmap);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

}