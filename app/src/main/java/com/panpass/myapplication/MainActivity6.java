package com.panpass.myapplication;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity6 extends AppCompatActivity {

    @BindView(R.id.role_verify_results_group)
    Group group;
    @BindView(R.id.role_verify_results_tv2)
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.ConstraintLayout,new BlankFragment());
//        fragmentTransaction.commit();
        ButterKnife.bind(this);
        getSupportFragmentManager().findFragmentById(R.id.blankfragment);
        PackageManager packageManager = getPackageManager();
        ApplicationInfo applicationInfo;
        try {
             applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0);
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Log.e("www","oncreate--activity");
        TransportBean transportBean = (TransportBean) getIntent().getSerializableExtra("trans");
        if (transportBean!=null)
        Log.e("www", "这里是传输的name" + transportBean.getName());
        Log.e("www", "这里是静态的name" + TransportBean.getInstance().getName());
        File file = new File(getCacheDir(),"b.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            TransportBean o = (TransportBean) objectInputStream.readObject();
            objectInputStream.close();
            Log.e("www", "这里是写到文件中的name" + o.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    @OnClick(R.id.b)
    void xx(){
        group.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);
    }
    @OnClick(R.id.a)
    void t() {
        group.setVisibility(View.GONE);
        tv2.setVisibility(View.GONE);
    }
    @OnClick(R.id.c)
    void p() {
        group.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.GONE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("www","onStart--activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("www","onResume--activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("www","onPause--activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("www","onStop--activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("www","onDestroy--activity");
    }
}