<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>欧美排行榜</title>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link href="css/rankList.css" rel='stylesheet' type='text/css' />
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</head>
<body>
<div class="music_container">
    <div class="head">
        <!--图标及搜索框-->
        <div class="header">
            <!--logo-->
            <div class="image">
                <a href="homePage.jsp">
                    <img src="img/musicLogo.png" alt="logo未找到" />
                </a>
            </div>
            <!--搜索框-->
            <div class="search">
                <form action="#" method="get">
                    <input placeholder="李荣浩-爸爸妈妈" class="text" type="text" />
                    <button><i class="fa fa-search"></i></button>
                    <!--<input class="submit" type="submit" width="30px" height="30px"/>-->
                </form>
            </div>
            <!--管理中心-->
            <div class="manager">
                <dl>
                    <dd><a href="JavaScript:void(0);">客服中心</a></dd>
                    <dd><a href="JavaScript:void(0);">招贤纳士</a></dd>
                    <dd><a href="JavaScript:void(0);">会员中心</a></dd>
                </dl>
            </div>
            <div class="delimiter">
                <font>|</font>
            </div>
            <!--登录-->
            <div class="username">
                <a href="#">${sessionScope.SESSION_USER.name}</a>
            </div>
            <div class="exit">
                <a href="/userExitServlet"><input class="btn btn-primary" type="button" value="退  出"></a>
            </div>
        </div>
        <!--轮播图-->
        <div class="rotationChart">
            <img src="img/轮播图1.png" id="imgRotationChart" alt="轮播图"/>
        </div>
    </div>
    <!--排行榜-->
    <div class="rankList">
        <p>欧美排行榜</p>
        <div class="title">
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link" href="folkMusicRankList.jsp">民谣</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="chineseMusicRankList.jsp">华语</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="eaMusicRankList.jsp">欧美</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="koreaMusicRankList.jsp">韩国</a>
                </li>
            </ul>
        </div>
        <div class="content">
            <table class="table table-hover">
                <c:forEach items="${sessionScope.SESSION_EA_MUSIC}" var="music" varStatus="id">
                    <tr>
                        <td>
                            <a href="/playServlet?id=${music.id}"><span>${music.name}</span><span class="time">04:27</span></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>
<script>
    var num = 0;
    function fun(){
        num ++;
        var nums= (num % 4) + 1;
        var img = document.getElementById("imgRotationChart");
        img.src ="img/轮播图" + nums + ".png";
    }
    setInterval(fun,3000);
</script>
</body>
