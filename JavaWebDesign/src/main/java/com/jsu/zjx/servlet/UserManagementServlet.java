package com.jsu.zjx.servlet;

import com.jsu.zjx.bean.User;
import com.jsu.zjx.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;

@WebServlet(urlPatterns = "/userManagementServlet")
public class UserManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String action=request.getParameter("action");
        if("add".equals(action)){
            addUser(request,response);
        }else if("remove".equals(action)){
            removeUser(request,response);
        }else if("initUpdatePage".equals(action)){
            initUpdatePage(request,response);
        }else if("update".equals(action)){
            updateUser(request,response);
        }else if("query".equals(action)){
            queryUser(request,response);
        }else if("showAll".equals(action)){
            showAllUser(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String phoneNumber=request.getParameter("phoneNumber");
        User user=new User(account,password,name,phoneNumber);
        UserDao userDao=new UserDao();
        userDao.insertUser(user);
        List<User> userList=userDao.getAllUser();
        request.getSession().setAttribute("SESSION_USER_LIST", userList);
        request.getRequestDispatcher("userManagementPage.jsp").forward(request,response);
    }
    public void removeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str=request.getParameter("id");
        int id=Integer.parseInt((String)request.getParameter("id"));
        UserDao userDao=new UserDao();
        userDao.removeUser(id);
        List<User> userList=userDao.getAllUser();
        request.getSession().setAttribute("SESSION_USER_LIST", userList);
        request.getRequestDispatcher("userManagementPage.jsp").forward(request,response);
    }

    // 初始化修改界面中的文本
    public void initUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        UserDao userDao=new UserDao();
        User user=userDao.getUserById(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("updateUserPage.jsp").forward(request,response);
    }
    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String phoneNumber=request.getParameter("phoneNumber");
        User user=new User(account,password,name,phoneNumber);
        user.setId(id);
        UserDao userDao=new UserDao();
        userDao.updateUser(user);
        List<User> userList=userDao.getAllUser();
        request.getSession().setAttribute("SESSION_USER_LIST", userList);
        request.getRequestDispatcher("userManagementPage.jsp").forward(request,response);
    }

    public void queryUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account=request.getParameter("account");
        UserDao userDao=new UserDao();
        List<User> userList=userDao.getUserByAccount(account);
        request.getSession().setAttribute("SESSION_USER_LIST", userList);
        request.getRequestDispatcher("userManagementPage.jsp").forward(request,response);
    }

    public void showAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao=new UserDao();
        List<User> userList=userDao.getAllUser();
        request.getSession().setAttribute("SESSION_USER_LIST", userList);
        request.getRequestDispatcher("userManagementPage.jsp").forward(request,response);
    }
}
