package com.nf147.shopping.Web;

import com.google.gson.Gson;
import com.nf147.shopping.dao.ShoppinglistDAO;
import com.nf147.shopping.entity.Shoppinglist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.nf147.shopping.entity.ShoppingTrolley;

@WebServlet("/ShoppingCar")
//购物车
public class ShoppingCar extends HttpServlet {
    ShoppinglistDAO dao = new ShoppinglistDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //乱码处理
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //从会话中获取用户进行判断
        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();
        String action = req.getParameter("action");
        //判断用户有没有登录
        if ("query".equals(action)) {
            if (session.getAttribute("u_id") != null) {
                int u_id = (int) session.getAttribute("u_id");
                List<ShoppingTrolley> list = dao.listAll(u_id);
                Gson gson = new Gson();
                writer.write(gson.toJson(list));
            } else {
                writer.write("{\"msg\":\"请先登录\"}");
            }
        }
    }

    //添加数据
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //乱码处理
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        HttpSession session = req.getSession();
        String account = "";
        PrintWriter writer = resp.getWriter();
        int u_id = (int) session.getAttribute("u_id");//从会话获取用户id
        int c_id = Integer.parseInt(req.getParameter("c_id"));//获取商品id
        int s_count = Integer.parseInt(req.getParameter("s_count"));//获取数量
        int s_state = Integer.parseInt(req.getParameter("s_state"));//获取状态
        System.out.println(c_id);
        //获取商品的数量
        int  getcidcount= dao.getById(c_id);
        if (session.getAttribute("account") != null) {
            if (getcidcount==c_id) {
                //有相同的商品数量加一
                System.out.println("数量相同");
                int nuber=dao.update(c_id,u_id);
                writer.write("{\"msg\":\"添加成功\"}");
                System.out.println("添加成功");
            } else {
                //没有添加一条
                Shoppinglist shoppinglist = new Shoppinglist(c_id, s_count, s_state, u_id);
                int count = dao.shoppingadd(shoppinglist);
                if (count>0) {
                    writer.write("{\"msg\":\"添加成功\"}");
                    System.out.println("添加成功");
                }
            }
        } else {
            writer.write("{\"msg\":\"请先登录\"}");
        }
    }
}
