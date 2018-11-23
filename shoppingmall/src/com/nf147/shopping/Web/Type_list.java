package com.nf147.shopping.Web;

import com.google.gson.Gson;
import com.nf147.shopping.dao.TypeDao;
import com.nf147.shopping.entity.Commodity;
import com.nf147.shopping.entity.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/Type_list")
public class Type_list extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询所有的类型
        TypeDao DAO=new TypeDao();
        PrintWriter writer = resp.getWriter();
        List<Type>types =DAO.listAll();
        writer.write(new Gson().toJson(types));
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取同等类型的id进行查询数据
        int id=Integer.parseInt(req.getParameter("id"));
       // System.out.println(id);
        //调用数据层
        TypeDao DAO=new TypeDao();
        List<Commodity>list=DAO.getType(id);
        PrintWriter writer = resp.getWriter();
        Gson gson = new Gson();
        writer.write(gson.toJson(list));

    }
}
