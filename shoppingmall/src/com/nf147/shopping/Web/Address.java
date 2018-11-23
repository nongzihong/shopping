package com.nf147.shopping.Web;

import com.google.gson.Gson;
import com.nf147.shopping.dao.AddressDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//地址
@WebServlet("/Address")
public class Address extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //乱码处理
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //获取地址信息
        String receiveUser=req.getParameter("receiveUser");
        String receiveTell=req.getParameter("receiveTell");
        String receiveAddr=req.getParameter("receiveAddr");
        HttpSession session = req.getSession();
        int id= (int) session.getAttribute("u_id");
        PrintWriter out = resp.getWriter();
        System.out.println(id);
        AddressDAO dao=new AddressDAO();
        int count=dao.Add(receiveUser,receiveTell,receiveAddr,id);
        List<com.nf147.shopping.entity.Address> list =dao.getAddRessAll(id);
        System.out.println(list);
        Gson gson=new Gson();
        if(count>0){
            System.out.println("添加成功");
            out.write("{\"msg\":\"添加成功\",\"list\":"+gson.toJson(list)+"}");
        }
    }
}
