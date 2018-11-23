package com.nf147.shopping.dao;
import com.nf147.shopping.entity.ShoppingTrolley;
import com.nf147.shopping.entity.Shoppinglist;
import java.sql.*;
import java.util.List;

//查询购物车数量
public class ShoppinglistDAO {
    //连接对象
    Connection conn = null;
    //语句执行对象
    PreparedStatement Ps= null;
    //结果集
    //ResultSet rs = null;

    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    String url = "jdbc:mysql://localhost:3306/shoppingDB";
    //MySQL配置时的用户名
    String user = "root";
    //MySQL配置时的密码
    String password = "666666";
    //保存数量
    int count;
    public  int getnumber(int id) {
        //加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //getConnection()方法，连接MySQL数据库！！
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select count(*) as s_count from shoppinglist where u_id="+id+";";
            Ps= conn.prepareStatement(sql);
            ResultSet rs = Ps.executeQuery();
            while (rs.next()) {
                count=rs.getInt("s_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    //往购物表添加数据
    public int shoppingadd(Shoppinglist shoppinglist) {
        String sql = "insert into shoppinglist (c_id,s_count,s_state,u_id) values(?,?,?,?);";
        return JDBCUtil.preparedUpdate(sql,shoppinglist.getC_id(),shoppinglist.getS_count(),shoppinglist.getS_state(),shoppinglist.getU_id());
    }
    //查询用户的购物车
    public List<ShoppingTrolley>listAll(int id){
        String sql="select c.c_id,c_particulars,c_price,c_img,t_id,s_id,s_count,s.s_state from commodity c inner join shoppinglist s on s.c_id=c.c_id where u_id=?;";
        return JDBCUtil.preparedQuery(ShoppingTrolley.class,sql,id);
    }
    //修改购物车的数量
    public int update(int c_id,int u_id){
        String sql="update shoppinglist set s_count=s_count+1  where c_id=? and u_id=?;";
        return JDBCUtil.preparedUpdate(sql,c_id,u_id);
    }

    //设置数量
   /* public int updata(ShoppingTrolley shoppingTrolley,int count){
        String sql=" update shoppinglist set s_count=? where c_id=3 and u_id=4;";
        return JDBCUtil.preparedUpdate(sql,shoppingTrolley.getS_count(),count);
    }*/
    public int getById(int id){
        int count=0;
        //加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //getConnection()方法，连接MySQL数据库！！
            conn = DriverManager.getConnection(url, user, password);
            String sql="select c_id as c_id from shoppinglist  where c_id="+id+";";
            Ps= conn.prepareStatement(sql);
            ResultSet rs = Ps.executeQuery();
            while (rs.next()) {
                count=rs.getInt("c_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
}
