package com.nf147.shopping.entity;

//购物实体类
public class Shoppinglist {
    private int s_id;//编号
    private int c_id;//商品编号外键
    private int s_count;//商品数量
    private int s_state;//购物车状态
    private int u_id;//归属用户外键
    private int o_id;//订单编号外键

    public Shoppinglist(int s_id, int c_id, int s_count, int s_state, int u_id, int o_id) {
        this.s_id = s_id;
        this.c_id = c_id;
        this.s_count = s_count;
        this.s_state = s_state;
        this.u_id = u_id;
        this.o_id = o_id;
    }
    public Shoppinglist() {
    }

    public Shoppinglist(int c_id, int s_count, int s_state, int u_id) {
        this.c_id = c_id;
        this.s_count = s_count;
        this.s_state = s_state;
        this.u_id = u_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getS_count() {
        return s_count;
    }

    public void setS_count(int s_count) {
        this.s_count = s_count;
    }

    public int getS_state() {
        return s_state;
    }

    public void setS_state(int s_state) {
        this.s_state = s_state;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    @Override
    public String toString() {
        return "Shoppinglist{" +
                "s_id=" + s_id +
                ", c_id=" + c_id +
                ", s_count=" + s_count +
                ", s_state=" + s_state +
                ", u_id=" + u_id +
                ", o_id=" + o_id +
                '}';
    }
}
