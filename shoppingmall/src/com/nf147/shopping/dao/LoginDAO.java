package com.nf147.shopping.dao;

import com.nf147.shopping.entity.User;

import java.util.List;

public class LoginDAO {
    //查询所有的用户
    public List<User>getAll(){
        String sql="select  * from User;";
        return JDBCUtil.preparedQuery(User.class,sql);
    }
    //查询用户名和密码
    public List<User> getcount(String username, String pwd){
        String sql="select * from User where u_name =? and u_pwd=?;";
        return JDBCUtil.preparedQuery(User.class,sql,username,pwd);
    }
    //根据用户名查询
    public List<User>getByName(String name){
        String sql="select * from user where u_name=?;";
        return JDBCUtil.preparedQuery(User.class,sql,name);
    }

}
