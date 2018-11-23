package com.nf147.shopping.Web;
import com.google.gson.Gson;
import com.nf147.shopping.dao.ShoppinglistDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/shoppingCount")
//查询购物车的数量
public class ShoppingCount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       PrintWriter writer = resp.getWriter();
        ShoppinglistDAO dao = new ShoppinglistDAO();
        HttpSession session = req.getSession();
        if(session.getAttribute("u_id")!=null){
            int id = (int) session.getAttribute("u_id");
              int count= dao.getnumber(id);
                Gson gson = new Gson();
                writer.write(gson.toJson(count));
        }
    }
}
