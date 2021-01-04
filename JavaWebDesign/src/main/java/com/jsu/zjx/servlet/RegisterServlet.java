package com.jsu.zjx.servlet;

import com.jsu.zjx.bean.User;
import com.jsu.zjx.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String name=request.getParameter("name");
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String phoneNumber=request.getParameter("phoneNumber");
        System.out.print(name+""+account);
        User user=new User(account,password,name,phoneNumber);
        UserDao userDao=new UserDao();
        //判断是否有相同的email
        Integer count = userDao.getCountByAccount(account);

        if (count > 0) {
            //数据库中已经有相同email的用户
            //通过response 对象给客户端一个提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('申请注册的账号已经被占用！');");
            writer.write("window.location.href = 'registerPage.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        } else {
            //flag是否注册成功
            boolean flag = userDao.insertUser(user);
            if (flag) {
                //注册成功就跳转到登录界面  重定向
                response.sendRedirect("/index.jsp");
            } else {
                //注册失败就返回注册页面  ，请求转发
                request.getRequestDispatcher("/registerPage.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
