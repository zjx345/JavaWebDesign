<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/1/2
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加音乐</title>
    <link rel="stylesheet" type="text/css" href="css/addMusicPage.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
</head>
<body>
<div class="addMusic">
    <form action="/musicManagementServlet?action=add" method="post">
        <div class="title"><h2>添加音乐</h2></div>
        <div class="addMusic_area">
            歌&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input id="name" class="form-control" name="name" type="text" placeholder="请输入歌名"><br/>
            路&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;径：<input id="url" class="form-control" name="url" type="text" placeholder="请输入路径"><span id="account_error"></span><br/>
            类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型：<input id="type" class="form-control" name="type" type="text" placeholder="请输入类型"><br/>
            歌&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手：<input id="singer" class="form-control" name="singerName" type="text" placeholder="请输入歌手"><br/>
            访&nbsp;问&nbsp;&nbsp;&nbsp;量：<input id="visitorCount" class="form-control" name="visitorCount" type="text" readonly="readonly" value="0"><br/>
            下&nbsp;载&nbsp;&nbsp;&nbsp;量：<input id="downloadCount" class="form-control" name="downloadCount" type="text" readonly="readonly" value="0"><br/>
            价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：<input id="price" class="form-control" name="price" type="text" placeholder="请输入价格"><br/>
            <input class="btn btn-primary" type="submit" value="添   加" onclick="alert('添加成功！')">
        </div>
    </form>
</div>
</body>
</html>
