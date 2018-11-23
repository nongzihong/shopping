package com.nf147.shopping.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.nf147.shopping.dao.JDBCUtil.close;
import static com.nf147.shopping.dao.JDBCUtil.getConn;

public class MyJDBCUtil {

    //驱动
    public static String driver = "com.mysql.jdbc.Driver";
    //连接字符串
    public static String url = "jdbc:mysql://localhost:3306/shoppingDB?useSSL=false";
    //用户名
    public static String name = "root";
    //密码
    public static String pwd = "666666";

    //查询单个值
    public static  int  preparedQueryCount(String sql){
        //获取连接对象
        Connection conn = getConn();
        //定义语句执行对象(预编译)
        PreparedStatement stmt = null;
        //定义结果集对象
        ResultSet rs = null;

        try {
            //获取语句执行对象(预编译)
            stmt = conn.prepareStatement(sql);

            //发送接收到的语句到数据库并执行
            return stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //释放资源
            close(conn,stmt,null);
        }
        return 0;
    }


}
