package com.nf147.shopping.entity;

//地址实体类
public class Address {
    private int a_id; //编号
    private String a_contacts;//收货人
    private String a_phoneNumber;//电话
    private String a_address;//收货人地址
    private int u_id;//归属用户外键

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public void setA_contacts(String a_contacts) {
        this.a_contacts = a_contacts;
    }

    public void setA_phoneNumber(String a_phoneNumber) {
        this.a_phoneNumber = a_phoneNumber;
    }

    public void setA_address(String a_address) {
        this.a_address = a_address;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getA_id() {
        return a_id;
    }

    public String getA_contacts() {
        return a_contacts;
    }

    public String getA_phoneNumber() {
        return a_phoneNumber;
    }

    public String getA_address() {
        return a_address;
    }

    public int getU_id() {
        return u_id;
    }

    public Address(int a_id, String a_contacts, String a_phoneNumber, String a_address, int u_id) {
        this.a_id = a_id;
        this.a_contacts = a_contacts;
        this.a_phoneNumber = a_phoneNumber;
        this.a_address = a_address;
        this.u_id = u_id;
    }
    public Address(){

    }

    @Override
    public String toString() {
        return "Address{" +
                "a_id=" + a_id +
                ", a_contacts='" + a_contacts + '\'' +
                ", a_phoneNumber='" + a_phoneNumber + '\'' +
                ", a_address='" + a_address + '\'' +
                ", u_id=" + u_id +
                '}';
    }
}
