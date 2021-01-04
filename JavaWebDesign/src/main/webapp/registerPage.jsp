<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册用户</title>

    <link rel="stylesheet" type="text/css" href="css/registerPage.css"/>

    <style>
        .register .register_area span{
            color: red;
        }
    </style>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script type="text/javascript" src="js/registerPage.js"></script>
    <script type="text/javascript">
        function validate() {
            var name=document.getElementById("name").value;
            var account=document.getElementById("account").value;
            var password=document.getElementById("password").value;
            var againPassword=document.getElementById("againPassword").value;
            var phoneNumber=document.getElementById("phoneNumber").value;
            if(name=''||account==''||password==''||againPassword==''||phoneNumber==''){
                alert("文本不能为空");
                return false;
            }else if(password!=againPassword){
                alert("两次密码不一致");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="register">
    <form action="/registerServlet" method="post" onsubmit="return validate()">
        <h2 align="center">注册账号</h2>
        <div class="register_area">
            名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<input id="name" name="name" type="text" placeholder="请输入名称"><br/>
            账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<input id="account" name="account" type="text" placeholder="请输入账号"><span id="account_error"></span><br/>
            密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input id="password" name="password" type="text" placeholder="请输入密码"><br/>
            重复密码：<input id="againPassword" name="againPassword" type="text" placeholder="请再一次输入密码"><span id="password_error"></span><br/>
            手&nbsp;&nbsp;机&nbsp;号：<input id="phoneNumber" name="phoneNumber" type="text" placeholder="请输入手机号"><br/>
            <input type="submit" value="注   册">
        </div>
    </form>
</div>
</body>
</html>
