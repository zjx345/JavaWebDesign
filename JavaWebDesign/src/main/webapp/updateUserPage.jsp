<%@ page import="com.jsu.zjx.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑用户</title>
    <link rel="stylesheet" type="text/css" href="css/updateUserPage.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
</head>
<body>
<div class="updateUser">
    <form action="/userManagementServlet?action=update" method="post">
        <div class="title"><h2>编辑用户</h2></div>
        <%
            User user=(User)request.getAttribute("user");
        %>
        <div class="updateUser_area">
            编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<input id="id" class="form-control" name="id" type="text" readonly="readonly" value="<%= user.getId()%>"><br/>
            名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<input id="name" class="form-control" name="name" type="text" placeholder="请输入名称" value="<%= user.getName()%>"><br/>
            账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<input id="account" class="form-control" name="account" type="text" readonly="readonly" value="<%= user.getAccount()%>"><span id="account_error"></span><br/>
            密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input id="password" class="form-control" name="password" type="text" placeholder="请输入密码" value="<%= user.getPassword()%>"><br/>
            手&nbsp;&nbsp;机&nbsp;号：<input id="phoneNumber" class="form-control" name="phoneNumber" type="text" placeholder="请输入手机号" value="<%= user.getPhoneNumber()%>"><br/>
            <input class="btn btn-primary" type="submit" value="确   定" onclick="check()">
        </div>
    </form>
</div>
<script>
    function check() {
        if(confirm("确定修改吗？")){
            window.location.href="/userManagementServlet?action=update&id="+$("#id").val()+"&name="+$("#name").val()+"&account="+$("#account").val()+"&password="+$("#password").val()+"&phoneNumber="+$("#phoneNumber").val();
        }
    }
</script>
</body>
</html>
