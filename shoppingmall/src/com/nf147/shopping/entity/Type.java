package com.nf147.shopping.entity;
//类型实体类
public class Type {
    private int t_id; //编号
    private String t_name;//类型

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public int getT_id() {
        return t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public Type(int t_id, String t_name) {
        this.t_id = t_id;
        this.t_name = t_name;
    }
    public  Type(){}

    @Override
    public String toString() {
        return "Type{" +
                "t_id=" + t_id +
                ", t_name='" + t_name + '\'' +
                '}';
    }
}
