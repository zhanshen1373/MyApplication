package com.panpass.myapplication.bean;

public class RecyclerViewUseBean  {

    private String fieldName;
    private String realName;
    private int order;



    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }



//    @Override
//    public int compare(Object o1, Object o2) {
//        if (o1 instanceof RecyclerViewUseBean && o2 instanceof RecyclerViewUseBean) {
//         return ((RecyclerViewUseBean) o1).order-((RecyclerViewUseBean) o2).order;
//        }
//        return 0;
//    }

//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof RecyclerViewUseBean){
//            return ((RecyclerViewUseBean) o).order-this.order;
//        }
//        return 0;
//    }




}
