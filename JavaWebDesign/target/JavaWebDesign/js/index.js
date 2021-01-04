//登录按钮点击事件
$(function () {
    $(".firstPage .head .header .login .login_button").on("click",function () {
        $(".firstPage .head .loginFrame").css("display","block");
        $(".firstPage .head .loginArea").css("display","block");
    })
});
$(function () {
    $(".firstPage .head .loginArea .login_close").on("click",function () {
        $(".firstPage .head .loginFrame").css("display","none");
        $(".firstPage .head .loginArea").css("display","none");
    })
});
$(function(){
    $(".firstPage .head .loginArea .login_button").click(function () {
        var account=$(".firstPage .head .loginArea .login_account").val();
        var password=$(".firstPage .head .loginArea .login_password").val();
        var radioValue=$(".firstPage .head .loginArea input:radio[name=identity]:checked").val();
        if(radioValue=="用户"){
            $.ajax({
                url: "loginServlet",
                type: "POST",
                data: {account: account,password: password},
                success: function (msg) {
                    if(msg=="登陆成功"){
                        window.location.href="/homePage.jsp";
                    }else {
                        alert("用户名或密码错误");
                    }
                },
                error: function (msg) {
                    alert("出错了");
                }
            });
        }else{
            $.ajax({
                url: "adminLoginServlet",
                type: "POST",
                data: {account: account,password: password},
                success: function (msg) {
                    if(msg=="登陆成功"){
                        window.location.href="/personalCenterPage.jsp";
                    }else {
                        alert("用户名或密码错误");
                    }
                },
                error: function (msg) {
                    alert("出错了");
                }
            });
        }
    });
});

//注册按钮点击事件

$(function () {
    $(".firstPage .head .header .register .register_button").on("click",function () {
        window.location.href="/registerPage.jsp";
    })
});