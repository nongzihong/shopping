package com.nf147.shopping.entity;

//用户实体类
public class User {
    private int u_id;  //编号
    private String u_name;    //用户名
    private String u_pwd;        //密码
    private String u_emeail;  //邮箱
    private String u_phone;  //电话

    public User(String u_name, String u_pwd, String u_emeail, String u_phone) {
        this.u_name = u_name;
        this.u_pwd = u_pwd;
        this.u_emeail = u_emeail;
        this.u_phone = u_phone;
    }

    public User(int u_id, String u_name, String u_pwd, String u_emeail, String u_phone) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_pwd = u_pwd;
        this.u_emeail = u_emeail;
        this.u_phone = u_phone;
    }
    public  User(){}

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public void setU_emeail(String u_emeail) {
        this.u_emeail = u_emeail;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public int getU_id() {
        return u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public String getU_emeail() {
        return u_emeail;
    }

    public String getU_phone() {
        return u_phone;
    }
}