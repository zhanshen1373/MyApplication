package com.panpass.myapplication;

import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class ProxyInformationFragmentAdapter extends FragmentStateAdapter {

    private String[] tabTitle;


    public ProxyInformationFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1){
            //委托信息
//            ProxyInformationFragment proxyInformationFragment = new ProxyInformationFragment();
//            return proxyInformationFragment;
        } else if (position == 0){
            //附近信息
            return new AnnexInformationFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {

        return tabTitle.length;
    }


    public void setTitle(String[] title) {
        tabTitle = title;
    }

}
