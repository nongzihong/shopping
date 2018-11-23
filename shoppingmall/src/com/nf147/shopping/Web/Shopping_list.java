package com.nf147.shopping.Web;
import com.google.gson.Gson;
import com.nf147.shopping.dao.CommodityDataoperationDAO;
import com.nf147.shopping.dao.ShoppingDAO;
import com.nf147.shopping.entity.Commodity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Shopping_list")
public class Shopping_list extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        ShoppingDAO dao =new CommodityDataoperationDAO();
        List<Commodity> commodityList=dao.listAll();
        Gson gson=new Gson();
        writer.write(gson.toJson(commodityList));
    }
    //搜索
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //商品查询
        //获取要查询的值
       String val=req.getParameter("val");
       //调用数据层进行查询
       ShoppingDAO dao=new  CommodityDataoperationDAO();
        List<Commodity> list=dao.getByName(val);
        PrintWriter writer = resp.getWriter();
        writer.write(new Gson().toJson(list));
       /* System.out.println(list);*/
    }
}

