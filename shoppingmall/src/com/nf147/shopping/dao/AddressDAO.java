package com.nf147.shopping.dao;


import com.nf147.shopping.entity.Address;

import java.util.List;

public class AddressDAO {


    //根据用查询地址
    public List<Address> getAddRessAll(int id){
        String sql="select * from address where u_id=?;";
        return  JDBCUtil.preparedQuery(Address.class,sql,id);
    }

    //添加地址
    public int Add(String contacts,String phoneNumber,String address,int u_id){
        String sql="insert into address values(default,?,?,?,?);";
        return JDBCUtil.preparedUpdate(sql,contacts,phoneNumber,address,u_id);
    }
}
