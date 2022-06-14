package com.panpass.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.MiddlewareWebChromeBase;
import com.just.agentweb.MiddlewareWebClientBase;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;

public class AgentWebActivity extends AppCompatActivity {

    private TextView tv;
    private FrameLayout fl;
    private AgentWeb mAgentWeb;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_web);
        tv = findViewById(R.id.tv);
        fl = findViewById(R.id.fl);
        bt = findViewById(R.id.bt);
        initNotification();
//        initAgentWeb();
        bt.setOnClickListener(v->startActivity(new Intent(this,AgentWebJumpActivity.class)));
    }

    private void initNotification() {
        NotificationChannel notificationChannel=null;
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            notificationChannel=new NotificationChannel("001","channel_name",NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"001");

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("酷我音乐");
        builder.setContentText("正在播放的音乐：两只老虎");
        notificationManager.notify(0,builder.build());

    }

    private void initAgentWeb() {
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(fl, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator(-1, 3)
                .setWebViewClient(new WebViewClient(){
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        Log.e("www","urlllll");
                        return super.shouldOverrideUrlLoading(view, url);
                    }

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                        Log.e("www","urllrequest");
                        return super.shouldOverrideUrlLoading(view, request);
                    }
                })
                .setWebChromeClient(new WebChromeClient(){
                    @Override
                    public void onProgressChanged(WebView view, int newProgress) {
                        Log.e("www", "onProgressChanged ... 通知主程序当前加载页面进度 ");
                        super.onProgressChanged(view, newProgress);
                    }
                })
                .useMiddlewareWebChrome(new MiddlewareWebChromeBase(){
                    @Override
                    public void onProgressChanged(WebView view, int newProgress) {
                        super.onProgressChanged(view, newProgress);
                        Log.e("www","onProgressChanged:");
                    }
                })
                .useMiddlewareWebClient(new MiddlewareWebClientBase(){
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                        Log.e("www", "MiddlewareWebViewClient -- >  shouldOverrideUrlLoading:" + request.getUrl().toString() + "  c:" );
                        return super.shouldOverrideUrlLoading(view, request);

                    }

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        Log.e("www", "MiddlewareWebViewClient -- >  shouldOverrideUrlLoading:" + url + "  c:" );
                        return super.shouldOverrideUrlLoading(view, url);

                    }
                })
                .createAgentWeb()
                .ready()
                .go("https://m.jd.com/");
    }

    @Override
    protected void onPause() {
        super.onPause();
//        mAgentWeb.getWebLifeCycle().onPause();
    }
}