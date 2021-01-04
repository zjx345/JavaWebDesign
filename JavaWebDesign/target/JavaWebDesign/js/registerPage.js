$(function () {
    $("#account").blur(function (){
        var account=$("#account").val();
        $.ajax({
            url:"registerAjaxServlet",
            cache:false,
            data:"account=" + account,
            type:'GET',
            timeout:2000,
            success:function (result) {
                $("#account_error").text("     "+result);
            }
        })
    })
});
$(function(){
   $("#againPassword").blur(function () {
       var password=$("#password").val();
       var againPassword=$("#againPassword").val();
       if(password!=againPassword){
            $("#password_error").text("  两次密码不一致");
       }else{
            $("#password_error").text("  密码一致");
       }
   })
});
