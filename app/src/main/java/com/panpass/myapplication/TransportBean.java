package com.panpass.myapplication;

import java.io.Serializable;

public class TransportBean implements Serializable {

    private static TransportBean transportBean;

    private TransportBean() { }

    public static TransportBean getInstance() {
        if (transportBean == null) {
            transportBean = new TransportBean();
        }
        return transportBean;
    }

    public static void setInstance(TransportBean bean) {
        transportBean = bean;
    }

    private int old;
    private String name;

    public int getOld() {
        return old;
    }

    public TransportBean setOld(int old) {
        this.old = old;
        return transportBean;
    }

    public String getName() {
        return name;
    }

    public TransportBean setName(String name) {
        this.name = name;
        return transportBean;
    }

}
