package com.nf147.shopping.Web;
import com.nf147.shopping.dao.LoginDAO;
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


//登录
    @WebServlet("/Login")
    public class Login_web extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //乱码处理
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json;charset=UTF-8");

            PrintWriter out = resp.getWriter();
            String account = req.getParameter("account");
            String password = req.getParameter("pwd");
            LoginDAO loginDao = new LoginDAO();
            List<User> list = loginDao.getcount(account, password);

            //获取用户的id
            int u_id=list.get(0).getU_id();

        /*System.out.println(account);
        System.out.println(password);*/

            for (int i = 0; i < list.size(); i++) {
                if (account.equals(list.get(i).getU_name())) {
                    if (!password.equals(list.get(i).getU_pwd())) {
                        out.write("{\"msg\":\"密码错误！\"}");
                        break;
                    } else {
                        //用户名密码正确
                        //跳转到
                        //把用户放到会话
                        HttpSession session = req.getSession();
                        session.setAttribute("account",account);
                        session.setAttribute("u_id",u_id);
                        out.write("{\"msg\":\"登入成功！\",\"username\":\"" + account + "\"}");
                        break;
                    }
                } else {
                    out.write("{\"msg\":\"用户名错误！\"}");
                    break;
                }
            }

        }
    }
