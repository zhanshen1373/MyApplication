package com.panpass.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity7 extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ProxyInformationFragmentAdapter proxyInformationFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        tabLayout = findViewById(R.id.tabs);
        viewPager2 = findViewById(R.id.view_pager);
        String tabTitle[] = new String[]{"委托信息","附件详情"};
        proxyInformationFragmentAdapter = new ProxyInformationFragmentAdapter(getSupportFragmentManager(),getLifecycle());
        proxyInformationFragmentAdapter.setTitle(tabTitle);
        viewPager2.setAdapter(proxyInformationFragmentAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                TextView tabView = new TextView(MainActivity7.this);
//                tabView.setText(tabTitle[position]);
//                tabView.setTextSize(16);
//                tabView.setGravity(Gravity.CENTER);
//                tab.setCustomView(tabView);
//                tab.setText(tabTitle[position]);

                  tab.setText(tabTitle[position]);


            }
        }).attach();



    }


}