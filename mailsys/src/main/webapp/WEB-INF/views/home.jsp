<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Mailsys</title>
    <link rel="stylesheet" href="/res/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/res/css/login.css">
    <script src="/res/jquery/jquery-3.3.1.min.js"></script>
    <script src="/res/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div class="bg"></div>
<div class="container">
    <form action="/user/login" method="post" class="formclass">
        <h3 class="loginheader">邮件代收发系统</h3>
        <input value="${user.username}" type="text" name="username" class="form-control" placeholder="用户名">
        <input type="password" name="password" class="form-control" placeholder="密码">
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
        <a class="reg" href="/register">注册</a>
    </form>
</div>
</body>
</html>
