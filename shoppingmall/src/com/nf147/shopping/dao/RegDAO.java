package com.nf147.shopping.dao;

import com.nf147.shopping.entity.User;

import java.sql.*;
import java.util.List;
public class RegDAO {
    //连接对象
    Connection conn = null;
    //语句执行对象
    PreparedStatement Ps= null;
    //结果集
  //  ResultSet rs = null;

    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    String url = "jdbc:mysql://localhost:3306/shoppingDB";
    //MySQL配置时的用户名
    String user = "root";
    //MySQL配置时的密码
    String password = "666666";
    //保存数量
    int id;


    //查询所有用户
    public List<User> getAll(){
        String sql="select  * from User;";
        return JDBCUtil.preparedQuery(User.class,sql);
    }
    //添加数据用户
    public  int  setAdd(User user){
        String sql="insert into User(u_name,u_pwd,u_emeail,u_phone)values(?,?,?,?);";
        return JDBCUtil.preparedUpdate(sql,user.getU_name(),user.getU_pwd(),user.getU_emeail(),user.getU_phone());
    }
    //根据用户名查询用户id
    public int getuserByid(String name){
        //加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //getConnection()方法，连接MySQL数据库！！
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select u_id as id from user where u_name='"+name+"';";
            Ps= conn.prepareStatement(sql);
            ResultSet rs = Ps.executeQuery();
            while (rs.next()) {
                id=rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
