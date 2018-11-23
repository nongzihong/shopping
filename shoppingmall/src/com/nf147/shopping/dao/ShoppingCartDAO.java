package com.nf147.shopping.dao;

import com.nf147.shopping.entity.Commodity;

import java.util.List;

public class ShoppingCartDAO {
    //查询购物车商品
    public List<Commodity> listAll(int id) {
        String sql = "select * from commodity where c_id=?;";
        return JDBCUtil.preparedQuery(Commodity.class, sql, id);
    }

}
