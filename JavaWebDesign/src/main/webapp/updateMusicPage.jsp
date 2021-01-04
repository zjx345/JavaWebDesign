<%@ page import="com.jsu.zjx.bean.Music" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/1/2
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑音乐</title>
    <link rel="stylesheet" type="text/css" href="css/updateMusicPage.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
</head>
<body>
<div class="updateMusic">
    <form action="/musicManagementServlet?action=update" method="post">
        <div class="title"><h2>编辑用户</h2></div>
        <%
            Music music=(Music)request.getAttribute("music");
        %>
        <div class="updateUser_area">
            编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<input id="id" class="form-control" name="id" type="text" readonly="readonly" value="<%= music.getId()%>"><br/>
            歌&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input id="name" class="form-control" name="name" type="text" readonly="readonly" value="<%= music.getName()%>"><br/>
            路&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;径：<input id="url" class="form-control" name="url" type="text" placeholder="请输入路径" value="<%= music.getUrl()%>"><span id="account_error"></span><br/>
            类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型：<input id="type" class="form-control" name="type" type="text" placeholder="请输入类型" value="<%= music.getType()%>"><br/>
            歌&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手：<input id="singerName" class="form-control" name="singerName" type="text" placeholder="请输入歌手" value="<%= music.getSingerName()%>"><br/>
            访&nbsp;&nbsp;问&nbsp;量：<input id="visitorCount" class="form-control" name="visitorCount" type="text" readonly="readonly" value="<%= music.getVisitorCount()%>"><br/>
            下&nbsp;&nbsp;载&nbsp;量：<input id="downloadCount" class="form-control" name="downloadCount" type="text" readonly="readonly" value="<%= music.getDownloadCount()%>"><br/>
            价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：<input id="price" class="form-control" name="price" type="text" placeholder="请输入价格" value="<%= music.getPrice()%>"><br/>
            <input class="btn btn-primary" type="submit" value="确   定" onclick="check()">
        </div>
    </form>
</div>
<script>
    function check() {
        if(confirm("确定修改吗？")){
            window.location.href="/musicManagementServlet?action=update";
        }
    }
</script>
</body>
</html>
