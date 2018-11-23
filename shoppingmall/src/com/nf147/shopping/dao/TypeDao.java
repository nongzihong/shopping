package com.nf147.shopping.dao;

import com.nf147.shopping.entity.Commodity;
import com.nf147.shopping.entity.Type;

import java.util.List;

public class TypeDao {
    //查询所有类型
    public List<Type> listAll() {
        String sql="select * from type";
        return JDBCUtil.preparedQuery(Type.class,sql);
    }
    //查询相应类型的数据
    public List<Commodity> getType(int id){
        String sql="select * from commodity where t_id=?;";
        return JDBCUtil.preparedQuery(Commodity.class,sql,id);
    }
}
