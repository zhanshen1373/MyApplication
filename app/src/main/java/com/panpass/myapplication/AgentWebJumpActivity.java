package com.panpass.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.panpass.myapplication.databinding.ActivityAgentWebJumpBinding;

public class AgentWebJumpActivity extends AppCompatActivity {

    private WebView webView;
    private ActivityAgentWebJumpBinding activityAgentWebJumpBinding;
    private TTbean tTbean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tTbean = new TTbean("nnnnn", "qqqqq", 2);
        activityAgentWebJumpBinding = DataBindingUtil.setContentView(this, R.layout.activity_agent_web_jump);
        activityAgentWebJumpBinding.setTTbean(tTbean);
        activityAgentWebJumpBinding.setAgentwebjumpactivity(this);
        activityAgentWebJumpBinding.setA("你好");
//        activityAgentWebJumpBinding.getTTbean().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
//            @Override
//            public void onPropertyChanged(Observable sender, int propertyId) {
//                if (propertyId == BR.name) {
//                    String name = activityAgentWebJumpBinding.getTTbean().getName();
//                    activityAgentWebJumpBinding.setTTbean(new TTbean(name,2));
//                }
//            }
//        });
//        activityAgentWebJumpBinding.getTTbean().setImageView(activityAgentWebJumpBinding.iv,R.drawable.a);
        activityAgentWebJumpBinding.et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
               Log.e("www",tTbean.toString());
            }
        });
        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("http://")||url.startsWith("https://")) {
                    view.loadUrl(url);
                    return true;
                } else {
                    try {
                        Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
            }

        });
        webView.loadUrl("https://m.jd.com/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

    }

    public void click(View view) {
        Log.e("www","触发了点击事件");
    }
    public void click(){     Log.e("www","触发了点击事件...");}
    public void click(View view,String name){
        Log.e("www","hhhhh");
    }
    public void click(String name) {
        Log.e("www",name);
    }

    @BindingAdapter("src")
    public static void loadPic(ImageView iv,String url) {
        Log.e("www",url);
    }
}