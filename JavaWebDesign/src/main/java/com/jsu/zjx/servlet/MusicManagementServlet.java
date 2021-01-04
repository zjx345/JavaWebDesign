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
import java.util.List;

@WebServlet(urlPatterns="/musicManagementServlet")
public class MusicManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String action=request.getParameter("action");
        if("add".equals(action)){
            addMusic(request,response);
        }else if("remove".equals(action)){
            removeMusic(request,response);
        }else if("initUpdatePage".equals(action)){
            initUpdatePage(request,response);
        }else if("update".equals(action)){
            updateMusic(request,response);
        }else if("query".equals(action)){
            queryMusic(request,response);
        }else if("showAll".equals(action)){
            showAllMusic(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    private void showAllMusic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MusicDao musicDao=new MusicDao();
        List<User> musicList=musicDao.getAllMusic();
        request.getSession().setAttribute("SESSION_MUSIC_LIST", musicList);
        request.getRequestDispatcher("musicManagementPage.jsp").forward(request,response);
    }

    private void queryMusic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        MusicDao musicDao=new MusicDao();
        List<Music> musicList=musicDao.getMusicByName(name);
        request.getSession().setAttribute("SESSION_MUSIC_LIST", musicList);
        request.getRequestDispatcher("musicManagementPage.jsp").forward(request,response);
    }

    private void initUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        MusicDao musicDao=new MusicDao();
        Music music=musicDao.getMusicById(id);
        request.setAttribute("music",music);
        request.getRequestDispatcher("updateMusicPage.jsp").forward(request,response);
    }

    private void updateMusic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String url=request.getParameter("url");
        String type=request.getParameter("type");
        String singerName=request.getParameter("singerName");
        int visitorCount=Integer.parseInt(request.getParameter("visitorCount"));
        int downloadCount=Integer.parseInt(request.getParameter("downloadCount"));
        double price=Double.parseDouble(request.getParameter("price"));
        Music music=new Music(name,url,type,singerName,visitorCount,downloadCount,price);
        music.setId(id);
        MusicDao musicDao=new MusicDao();
        musicDao.updateMusic(music);
        List<Music> musicList=musicDao.getAllMusic();
        request.getSession().setAttribute("SESSION_MUSIC_LIST", musicList);
        request.getRequestDispatcher("musicManagementPage.jsp").forward(request,response);
    }

    private void removeMusic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str=request.getParameter("id");
        int id=Integer.parseInt((String)request.getParameter("id"));
        MusicDao musicDao=new MusicDao();
        musicDao.removeMusic(id);
        List<Music> musicList=musicDao.getAllMusic();
        request.getSession().setAttribute("SESSION_MUSIC_LIST", musicList);
        request.getRequestDispatcher("musicManagementPage.jsp").forward(request,response);
    }

    private void addMusic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String url=request.getParameter("url");
        String type=request.getParameter("type");
        String singerName=request.getParameter("singerName");
        int visitorCount=Integer.parseInt(request.getParameter("visitorCount"));
        int downloadCount=Integer.parseInt(request.getParameter("downloadCount"));
        double price=Double.parseDouble(request.getParameter("price"));
        Music music=new Music(name,url,type,singerName,visitorCount,downloadCount,price);
        MusicDao musicDao=new MusicDao();
        musicDao.insertMusic(music);
        List<Music> musicList= musicDao.getAllMusic();
        request.getSession().setAttribute("SESSION_MUSIC_LIST", musicList);
        request.getRequestDispatcher("musicManagementPage.jsp").forward(request,response);
    }
}
