package com.panpass.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Bean implements Parcelable {

    private String name;
    private int t;
    private boolean isShowTime;
    private List<W> w;


    class W {
        private int num;

    }

    protected Bean(Parcel in) {
        name = in.readString();
        t = in.readInt();
        isShowTime = in.readByte() != 0;
        in.readList(w,W.class.getClassLoader());

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(t);
        dest.writeByte((byte) (isShowTime ? 1 : 0));
        dest.writeList(w);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Bean> CREATOR = new Creator<Bean>() {
        @Override
        public Bean createFromParcel(Parcel in) {
            return new Bean(in);
        }

        @Override
        public Bean[] newArray(int size) {
            return new Bean[size];
        }
    };

}
