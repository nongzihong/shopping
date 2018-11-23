package com.nf147.shopping.Test;
import com.nf147.shopping.dao.ShoppinglistDAO;

public class a {

    public static void main(String[] args) {
     /*   LoginDAO loginDao = new LoginDAO();
        List<User> list=loginDao.getcount("admin","123456");
        System.out.println(list);
*/
        int id=3;
       ShoppinglistDAO dao=new ShoppinglistDAO();
        //List<ShoppingTrolley>list=dao.listAll(id);
       // System.out.println(list);
       int count= dao.getById(id);
        System.out.println(count);
       // ShoppinglistDAO dao=new ShoppinglistDAO();
       // ShoppingTrolley shoppingTrolley=new ShoppingTrolley(s_count,c_id);
        //int nuber=dao.update(4,4);

      /*  RegDAO dao=new RegDAO();
       String name="农梓鸿";
       int id=dao.getuserByid(name);
        System.out.println(id);
        */
    }
}
