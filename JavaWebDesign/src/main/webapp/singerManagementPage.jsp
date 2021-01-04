<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>歌手管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords" content="" />
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />

    <!-- Custom CSS -->
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <!-- font-awesome icons -->
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
    <!-- //Custom Theme files -->

    <!-- side nav css file -->
    <link href='css/SidebarNav.min.css' media='all' rel='stylesheet' type='text/css' />
    <!-- //side nav css file -->
    <!--webfonts-->
    <!-- logo -->
    <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
    <!-- titles -->
    <link href="http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:200,300,400,700" rel="stylesheet">
    <!-- body -->
    <link href="http://fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i" rel="stylesheet">
    <!--//webfonts-->
</head>
<body class="cbp-spmenu-push">
<div class="main-content">
    <div class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
        <!--left-fixed -navigation-->
        <aside class="sidebar-left">
            <h1>
                <a href="personalCenterPage.jsp" class="logo">
                    yunMusic
                </a>
            </h1>
            <ul class="sidebar-menu">
                <li class="treeview">
                    <a href="personalCenterPage.jsp">
                        <i class="fa fa-home"></i>
                        <span>个人中心</span>
                    </a>
                </li>
                <li class="treeview">
                    <a href="userManagementPage.jsp">
                        <i class="fa fa-user"></i>
                        <span>用户管理</span>
                    </a>
                </li>
                <li class="treeview">
                    <a href="musicManagementPage.jsp">
                        <i class="fa fa-music"></i>
                        <span>音乐管理</span>
                    </a>
                </li>
                <li class="treeview active">
                    <a href="singerManagementPage.jsp">
                        <i class="fa fa-user-circle-o"></i>
                        <span>歌手管理</span>
                    </a>
                </li>
                <li class="treeview">
                    <a href="orderManagementPage.jsp">
                        <i class="fa fa-first-order"></i>
                        <span>订单管理</span>
                    </a>
                </li>
            </ul>
        </aside>
    </div>
</div>
<!--left-fixed -navigation-->
<!-- header-starts -->
<header class="header-section">
    <div class="header-left  clearfix">
        <!--logo start-->
        <div class="brand">
            <button id="showLeftPush">
                <i class="fa fa-bars"></i>
            </button>
        </div>
        <!--logo end-->
    </div>
    <div class="header-right">
    </div>
</header>

<div class="content">
    <div class="top">
        <input id="account" class="form-control" type="text" placeholder="请输入要查询的账号">
        <input id="query" class="btn btn-primary" type="button" value="查    询" onclick="window.location.href='/userManagementServlet?action=query&account='+$('#account').val()">
        <input id="showAll" class="btn btn-primary" type="button" value="显示全部" onclick="window.location.href='/userManagementServlet?action=showAll'">
        <input id="add" class="btn btn-primary" type="button" value="添    加" onclick="window.location.href='addUserPage.jsp'">
    </div>
    <table class="table table-striped">
        <tr>
            <td>编号</td>
            <td>歌手</td>
            <td>性别</td>
            <td>出生日期</td>
            <td>爱好</td>
            <td>访问量</td>
            <td>操作</td>
        </tr>
        <%--<%
            List<User> userList=new ArrayList<User>();
            userList=(List<User>) request.getAttribute("userList");
        %>--%>
        <c:forEach items="${sessionScope.SESSION_SINGER_LIST}" var="singer" varStatus="id">
            <tr>
                <td>${singer.id}</td>
                <td>${singer.name}</td>
                <td>${singer.sex}</td>
                <td>${singer.birthday}</td>
                <td>${singer.hobby}</td>
                <td>${singer.visitorCount}</td>
                <td>
                    <i class="fa fa-pencil-square"></i>&nbsp;&nbsp;&nbsp;<input class="btn btn-primary" type="button" value="编    辑">
                    <i class="fa fa-trash-o"></i>&nbsp;&nbsp;&nbsp;<input class="btn btn-primary" type="button" value="删    除">
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<!-- js-->
<script src="js/jquery-2.2.3.min.js"></script>
<!-- js-->

<!-- for toggle left push menu script -->
<script src="js/classie.js "></script>
<script>
    var menuLeft = document.getElementById('cbp-spmenu-s1'),
        showLeftPush = document.getElementById('showLeftPush'),
        body = document.body;

    showLeftPush.onclick = function () {
        classie.toggle(this, 'active');
        classie.toggle(body, 'cbp-spmenu-push-toright');
        classie.toggle(menuLeft, 'cbp-spmenu-open');
        disableOther('showLeftPush');
    };


    function disableOther(button) {
        if (button !== 'showLeftPush') {
            classie.toggle(showLeftPush, 'disabled');
        }
    }
</script>

</body>

</html>
