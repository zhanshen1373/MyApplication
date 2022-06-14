package com.panpass.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity4 extends AppCompatActivity implements Serializable {


    private TextView ttt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent = getIntent();
//        if (intent != null) {
//            TTbean p = intent.getParcelableExtra("p");
//
//            Bundle extras = intent.getExtras();
//            BitmapBinder bitmapBinder = (BitmapBinder) extras.getBinder("binder");
//            Bitmap bitmap = bitmapBinder.getBitmap();
//            Log.e("www",bitmap.getByteCount()/1024+"kb");
//            Log.e("www", p.getName());
//        }
//        Log.e("ppp", TTbean.getInstance().getName());
        ttt = findViewById(R.id.ttt);
        ttt.getParent().requestDisallowInterceptTouchEvent(true);
        SpannableString spanableInfo = new SpannableString("这是一个测试点击我");
        spanableInfo.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Log.e("www","就将计就计");
            }
        }, 4, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ttt.setText(spanableInfo);
    }



    static class PictureBinder2 extends PictureAidlInterface.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void setPicture(Bitmap bitmap) throws RemoteException {
            Log.e("aaa",bitmap.getByteCount()/1024+"kb");
        }

        @Override
        public Bitmap getPicture(Bitmap bitmap) throws RemoteException {
            return null;
        }
    }
}