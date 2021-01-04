package com.jsu.zjx.servlet;

import com.jsu.zjx.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registerAjaxServlet")
public class RegisterAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String account=request.getParameter("account");
        UserDao userDao=new UserDao();
        int count=userDao.getCountByAccount(account);
        if(count>0){
            response.getWriter().print("账号已存在，请换个牛逼的");
        }else{
            String regex="[a-z0-9A-Z]+";
            if(account.matches(regex)){
                response.getWriter().print("账号合法");
            }else{
                response.getWriter().print("账号不合法");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
