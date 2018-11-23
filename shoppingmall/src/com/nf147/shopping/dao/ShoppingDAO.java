package com.nf147.shopping.dao;

import com.nf147.shopping.entity.Commodity;
import java.util.List;

public interface ShoppingDAO {
    List<Commodity> listAll();//查询所有
    Commodity getById(int id);
    List<Commodity> getByName(String name);
    boolean update (Commodity commodity);
    boolean delete(int id);
    Commodity add(Commodity commodity);
}
