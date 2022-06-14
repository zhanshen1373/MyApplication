package com.panpass.myapplication;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableChar;


public class TTbean  implements Parcelable  {

    private String name;

    private int old;
    private String ww;
    private String imageUrl;

    private static TTbean p;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWw() {
        return ww;
    }

    public void setWw(String ww) {
        this.ww = ww;
    }

    protected TTbean(Parcel in) {
        name = in.readString();
        old = in.readInt();
    }

    public TTbean(String ww,String name, int old) {
        this.ww = ww;
        this.name = name;
        this.old = old;
    }

    public static final Creator<TTbean> CREATOR = new Creator<TTbean>() {
        @Override
        public TTbean createFromParcel(Parcel in) {
            return new TTbean(in);
        }

        @Override
        public TTbean[] newArray(int size) {
            return new TTbean[size];
        }
    };

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getName() {

        return name!=null?name:"aaa";
    }

    public void setName(String name) {
        this.name = name;
//        notifyChange();
    }

    public static void setInstance(TTbean bean){
        p = bean;
    }
    public static TTbean getInstance(){
        return p;
    }
    public String aa(){
        return "1";
    }

    @Override
    public String toString() {
        return "TTbean{" +
                "name='" + name + '\'' +
                ", old=" + old +
                ", ww='" + ww + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(old);
    }
    public void tvClick(View view) {
        setName("jjjjj");
        setOld(0);
    }
//    @BindingAdapter({"src"})
//    public void setImageView(ImageView imageView, int imageResource){
//      imageView.setImageResource(imageResource);
//    }

}
