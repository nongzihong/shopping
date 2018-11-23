package com.nf147.shopping.Web;

import com.nf147.shopping.dao.LoginDAO;
import com.nf147.shopping.dao.RegDAO;
import com.nf147.shopping.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
//注册
@WebServlet("/Reg")
public class reg_web extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //乱码处理
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //获取注册用户名进行判断
        String name = req.getParameter("account");
        //调用数据层查询数据
        LoginDAO dao=new LoginDAO();
        List<User> list=dao.getByName(name);

        PrintWriter writer = resp.getWriter();
        //System.out.println(name);
        if(name==""){
           writer.write("{\"msg\":\"用户名不能为空\"}");
        }else if (list.size()>0){
            writer.write("{\"msg\":\"用户已存在\"}");
        }else{
            writer.write("{\"msg\":\"用户可使用\"}");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //乱码处理
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //或注册信息
        String name = req.getParameter("account");
        String password = req.getParameter("password");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");

        //调用数据层进行注册
        RegDAO dao=new RegDAO();
        User user=new User(name,password,email,tel);
        PrintWriter writer = resp.getWriter();
        int count=dao.setAdd(user);
        if (count>0){
            //把用户添加到会话
            HttpSession session = req.getSession();
            session.setAttribute("account",name);
            int u_id=dao.getuserByid(name);
            session.setAttribute("u_id",u_id);
            writer.write("{\"msg\":\"用户注册成功\",\"name\":\""+name+"\"}");
        }
        else{
            writer.write("{\"msg\":\"用户注册失败\"}");
        }

    }
}
