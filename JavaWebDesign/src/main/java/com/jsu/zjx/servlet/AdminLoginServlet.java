package com.jsu.zjx.servlet;

import com.jsu.zjx.bean.*;
import com.jsu.zjx.dao.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        // 初始化信息
        AdminDao adminDao=new AdminDao();
        Admin admin=adminDao.getAdminByAccountAndPassword(account,password);

        UserDao userDao=new UserDao();
        List<User> userList=userDao.getAllUser();

        MusicDao musicDao=new MusicDao();
        List<Music> musicList=musicDao.getAllMusic();

        SingerDao singerDao=new SingerDao();
        List<Singer> singerList=singerDao.getAllSinger();

        OrderDao orderDao=new OrderDao();
        List<Order> orderList=orderDao.getAllOrder();
        String msg=null;
        if(admin!=null){
            request.getSession().setAttribute("SESSION_ADMIN",admin);
            request.getSession().setAttribute("SESSION_USER_LIST",userList);
            request.getSession().setAttribute("SESSION_MUSIC_LIST",musicList);
            request.getSession().setAttribute("SESSION_SINGER_LIST",singerList);
            request.getSession().setAttribute("SESSION_ORDER_LIST",orderList);
            msg="登陆成功";
        }else{
            msg="登陆失败";
        }
        PrintWriter writer = response.getWriter();
        writer.write(msg);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
