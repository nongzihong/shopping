package com.nf147.shopping.entity;

//商品实体类
public class Commodity {
    private int c_id;           //编号
    private String c_name;       //商品名称
    private String c_particulars; //商品详情
    private double c_price;         //商品价格
    private String c_state;          //商品状态
    private String c_img;            //商品图片
    private int t_id;                //商品类型外键

    public Commodity(int c_id, String c_name, String c_particulars, double c_price, String c_state, String c_img, int t_id) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_particulars = c_particulars;
        this.c_price = c_price;
        this.c_state = c_state;
        this.c_img = c_img;
        this.t_id = t_id;
    }
    public Commodity(){

    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public void setC_particulars(String c_particulars) {
        this.c_particulars = c_particulars;
    }

    public void setC_price(double c_price) {
        this.c_price = c_price;
    }

    public void setC_state(String c_state) {
        this.c_state = c_state;
    }

    public void setC_img(String c_img) {
        this.c_img = c_img;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getC_id() {
        return c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public String getC_particulars() {
        return c_particulars;
    }

    public double getC_price() {
        return c_price;
    }

    public String getC_state() {
        return c_state;
    }

    public String getC_img() {
        return c_img;
    }

    public int getT_id() {
        return t_id;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", c_particulars='" + c_particulars + '\'' +
                ", c_price=" + c_price +
                ", c_state='" + c_state + '\'' +
                ", c_img='" + c_img + '\'' +
                ", t_id=" + t_id +
                '}';
    }
}
