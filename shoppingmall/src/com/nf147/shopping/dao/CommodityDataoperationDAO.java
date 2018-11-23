package com.nf147.shopping.dao;

import com.nf147.shopping.entity.Commodity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommodityDataoperationDAO implements ShoppingDAO {
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
    List<Commodity> commodityList = new ArrayList<>();

    @Override
    public List<Commodity> listAll() {
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
            rs = statement.executeQuery("select * from commodity");
            while (rs.next()) {
                int c_id = rs.getInt("c_id");           //编号
                String c_name = rs.getString("c_name");       //商品名称
                String c_particulars = rs.getString("c_particulars"); //商品详情
                double c_price = rs.getDouble("c_price");         //商品价格
                String c_state = rs.getString("c_state");          //商品状态
                String c_img = rs.getString("c_img");            //商品图片
                int t_id = rs.getInt("t_id");
                Commodity commodity = new Commodity(c_id, c_name, c_particulars, c_price, c_state, c_img, t_id);
                commodityList.add(commodity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } /* finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/

        return commodityList;
    }


    @Override
    public Commodity getById(int id) {
        return null;
    }


    //模糊查询
    @Override
    public List<Commodity> getByName(String name) {
        String sql ="select * from commodity WHERE c_name LIKE ? or c_name LIKE ? or c_name like ?;";
        return JDBCUtil.preparedQuery(Commodity.class, sql,"%"+name+"%","%"+name+"%","%"+name+"%");

    }


    @Override
    public boolean update(Commodity commodity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Commodity add(Commodity commodity) {
        return null;
    }
}
