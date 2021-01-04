<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>播放界面</title>

    <link type="text/css" href="css/playPage.css" rel="stylesheet" />
    <link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="Title">${param.name}</div>
<div class="btns-bg">
    <div class="PlayEy"></div>
    <div class="Btn"></div>
    <div class="Play">
        <audio id="audios" src="${param.url}"></audio>
    </div>

</div>

<script type="text/javascript" src="js/playPage.js"></script>
<script src="js/bootstrap.js"></script>

</body>
</html>