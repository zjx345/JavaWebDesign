package com.jsu.zjx.servlet;

import com.jsu.zjx.bean.Music;
import com.jsu.zjx.dao.MusicDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/playServlet")
public class PlayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String str=request.getParameter("id");
        System.out.print(str+123);
        int id=Integer.parseInt(str);
        MusicDao musicDao=new MusicDao();
        Music music=musicDao.getMusicById(id);
        String name=music.getName();
        String url=music.getUrl();
        request.getRequestDispatcher("/playPage.jsp?name="+name+"&"+"url="+url).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
