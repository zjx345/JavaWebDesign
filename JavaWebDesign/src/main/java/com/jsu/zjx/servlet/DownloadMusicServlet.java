package com.jsu.zjx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/downloadMusicServlet")
public class DownloadMusicServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        // 获取音乐路径,把中文转换程url编码
        String resultURL="";
        String saveURL="";
        String musicURL=request.getParameter("url");
        for(int i=0;i<musicURL.length();i++){
            char c=musicURL.charAt(i);
            if(String.valueOf(c).matches("[\u4e00-\u9fa5]")){
                saveURL+=c;
                String temp= URLEncoder.encode(c+"","UTF-8");
                resultURL+=temp;
            }else{
                resultURL+=c;
            }
        }
        InputStream inputStream=this.getInputStream(resultURL);
        byte[] data=new byte[1024];
        int len=0;
        FileOutputStream fileOutputStream=null;
        try{
            fileOutputStream=new FileOutputStream("D:\\"+saveURL+".mp3");
            while((len=inputStream.read(data))!=-1){
                fileOutputStream.write(data,0,len);
            }
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('下载成功！');");
            writer.write("window.location.href='folkMusicRankList.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    // 从服务器获得一个输入流
    public InputStream getInputStream(String musicUrl){
        InputStream inputStream=null;
        HttpURLConnection httpURLConnection=null;
        try{
            URL url=new URL(musicUrl);
            httpURLConnection=(HttpURLConnection)url.openConnection();
            // 设置网络连接超时时间
            httpURLConnection.setConnectTimeout(3000);
            // 设置应用程序要从网络连接读取数据
            httpURLConnection.setDoInput(true);

            httpURLConnection.setRequestMethod("GET");
            int responseCode=httpURLConnection.getResponseCode();
            if(responseCode==200){
                inputStream=httpURLConnection.getInputStream();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }
}
