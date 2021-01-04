package com.jsu.zjx.servlet;

import com.jsu.zjx.bean.Music;
import com.jsu.zjx.bean.User;
import com.jsu.zjx.dao.MusicDao;
import com.jsu.zjx.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String account=request.getParameter("account");
        String password=request.getParameter("password");

        UserDao userDao=new UserDao();
        User user=userDao.getUserByAccountAndPassword(account,password);
        String msg=null;
        if(user!=null){
            request.getSession().setAttribute("SESSION_USER",user);
            List<Music> al=new ArrayList<Music>();
            MusicDao musicDao=new MusicDao();
            al=musicDao.getAllMusic();
            request.getSession().setAttribute("SESSION_ALL_MUSIC",al);
            msg="登陆成功";
            System.out.print("登录成功");
        }else{
            System.out.print("登录失败");
            msg="登陆失败";
        }
        PrintWriter writer=response.getWriter();
        writer.write(msg);
    }
}
