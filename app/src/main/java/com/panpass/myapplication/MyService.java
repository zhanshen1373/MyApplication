package com.panpass.myapplication;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.preference.PreferenceFragment;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.FileDescriptor;

public class MyService extends Service {


    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.e("www","--onCreate--");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("www","--onStartCommand--");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("www","--onUnbind--");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.e("www","--onDestroy--");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.e("www","--onBind--");
        return new ppp();
    }

    class MyBinder extends IMyAidlInterface.Stub{


        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getName() throws RemoteException {
            return null;
        }

        @Override
        public void setName(String name) throws RemoteException {

        }
    }

      class PictureBinder extends PictureAidlInterface.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void setPicture(Bitmap bitmap) throws RemoteException {
           Log.e("qqq",bitmap.getByteCount()/1024+"kb");
        }

        @Override
        public Bitmap getPicture(Bitmap bitmap) throws RemoteException {
            return null;
        }
    }

    class ppp extends Binder {
        public ppp() {
        }
        @Override
        protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {

            switch (code) {
                case 1:
                    String message = data.readString();
                    Log.e("www", "showMessage " + message);
                    if (reply != null) {
                        reply.writeNoException();
                    }
                    return true;
            }
            return super.onTransact(code, data, reply, flags);
        }
    }


}