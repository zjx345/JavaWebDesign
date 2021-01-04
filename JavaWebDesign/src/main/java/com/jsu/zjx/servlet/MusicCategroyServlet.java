package com.jsu.zjx.servlet;

import com.jsu.zjx.bean.Music;
import com.jsu.zjx.dao.MusicDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/musicCategroyServlet")
public class MusicCategroyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("html/text;charset=UTF-8");
        MusicDao musicDao=new MusicDao();
        List<Music> folkMusicList=musicDao.getMusicByType("民谣");
        request.getSession().setAttribute("SESSION_FOLK_MUSIC",folkMusicList);
        List<Music> chineseMusicList=musicDao.getMusicByType("华语");
        request.getSession().setAttribute("SESSION_CHINESE_MUSIC",chineseMusicList);
        List<Music> eaMusicList=musicDao.getMusicByType("欧美");
        request.getSession().setAttribute("SESSION_EA_MUSIC",eaMusicList);
        List<Music> koreaMusicList=musicDao.getMusicByType("韩国");
        request.getSession().setAttribute("SESSION_KOREA_MUSIC",koreaMusicList);
        request.getRequestDispatcher("folkMusicRankList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
