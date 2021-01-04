<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <link rel="stylesheet" type="text/css" href="css/addUserPage.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
</head>
<body>
<div class="addUser">
    <form action="/userManagementServlet?action=add" method="post">
        <div class="title"><h2>添加用户</h2></div>
        <div class="addUser_area">
            名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<input id="name" class="form-control" name="name" type="text" placeholder="请输入名称"><br/>
            账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<input id="account" class="form-control" name="account" type="text" placeholder="请输入账号"><span id="account_error"></span><br/>
            密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input id="password" class="form-control" name="password" type="text" placeholder="请输入密码"><br/>
            手&nbsp;&nbsp;机&nbsp;号：<input id="phoneNumber" class="form-control" name="phoneNumber" type="text" placeholder="请输入手机号"><br/>
            <input class="btn btn-primary" type="submit" value="添   加" onclick="alert('添加成功！')">
        </div>
    </form>
</div>
</body>
</html>
