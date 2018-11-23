package com.nf147.shopping.Web;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/GetUserName")
public class GetUserName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username= (String) session.getAttribute("account");
       //System.out.println(username);
        PrintWriter writer = resp.getWriter();
        Gson gson = new Gson();
        if(username!=null){
            writer.write(gson.toJson(username));
        }
    }
}
