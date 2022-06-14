// PictureAidlInterface.aidl
package com.panpass.myapplication;

// Declare any non-default types here with import statements

interface PictureAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    void setPicture(in Bitmap bitmap);
    Bitmap getPicture(in Bitmap bitmap);
}