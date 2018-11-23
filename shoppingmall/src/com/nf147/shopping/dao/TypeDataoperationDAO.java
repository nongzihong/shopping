package com.nf147.shopping.dao;
import com.nf147.shopping.entity.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//商品数据操作
public class TypeDataoperationDAO{
    //连接对象
    Connection conn = null;
    //语句执行对象
    Statement statement = null;
    //结果集
    ResultSet rs = null;

    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    String url = "jdbc:mysql://localhost:3306/shoppingDB";
    //MySQL配置时的用户名
    String user = "root";
    //MySQL配置时的密码
    String password = "666666";
    List<Type>types=new ArrayList<>();

    public List<Type> listAll() {
        //加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //getConnection()方法，连接MySQL数据库！！
            conn = DriverManager.getConnection(url, user, password);
            statement = conn.createStatement();
            rs = statement.executeQuery("select * from type");
            while (rs.next()) {
                int id=rs.getInt("t_id");
                String type=rs.getString("t_name");
                Type type1=new Type(id,type);
                types.add(type1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(rs!=null)rs.close();
                if(statement!=null)statement.close();
                if(conn!=null)conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return types;
    }



}
