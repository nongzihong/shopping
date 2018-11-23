package com.nf147.shopping.entity;

public class ShoppingTrolley {
    private int c_id;           //编号
    private String c_particulars; //商品详情
    private double c_price;         //商品价格
    private String c_img;            //商品图片
    private int t_id;                //商品类型外键
    private int s_id;//编号
    private int s_count;//商品数量
    private int s_state;//购物车状态

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public void setC_particulars(String c_particulars) {
        this.c_particulars = c_particulars;
    }

    public void setC_price(double c_price) {
        this.c_price = c_price;
    }

    public void setC_img(String c_img) {
        this.c_img = c_img;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public void setS_count(int s_count) {
        this.s_count = s_count;
    }

    public void setS_state(int s_state) {
        this.s_state = s_state;
    }

    public int getC_id() {
        return c_id;
    }

    public String getC_particulars() {
        return c_particulars;
    }

    public double getC_price() {
        return c_price;
    }

    public String getC_img() {
        return c_img;
    }

    public int getT_id() {
        return t_id;
    }

    public int getS_id() {
        return s_id;
    }

    public int getS_count() {
        return s_count;
    }

    public int getS_state() {
        return s_state;
    }

    public ShoppingTrolley(int c_id, String c_particulars, double c_price, String c_img, int t_id, int s_id, int s_count, int s_state) {
        this.c_id = c_id;
        this.c_particulars = c_particulars;
        this.c_price = c_price;
        this.c_img = c_img;
        this.t_id = t_id;
        this.s_id = s_id;
        this.s_count = s_count;
        this.s_state = s_state;
    }

    public ShoppingTrolley(int c_id, int s_count) {
        this.c_id = c_id;
        this.s_count = s_count;
    }

    public ShoppingTrolley(){

    }

    @Override
    public String toString() {
        return "ShoppingTrolley{" +
                "c_id=" + c_id +
                ", c_particulars='" + c_particulars + '\'' +
                ", c_price=" + c_price +
                ", c_img='" + c_img + '\'' +
                ", t_id=" + t_id +
                ", s_id=" + s_id +
                ", s_count=" + s_count +
                ", s_state=" + s_state +
                '}';
    }
}