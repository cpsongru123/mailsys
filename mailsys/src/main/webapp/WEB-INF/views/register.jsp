<%--
  Created by IntelliJ IDEA.
  User: a9915
  Date: 2018/3/22
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="/res/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/res/css/register.css">
    <script type="text/javascript" src="/res/jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/res/js/popper.js"></script>
    <script type="text/javascript" src="/res/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="regbg"></div>
<div id="ft" class="container">
    <div class="title"><span style="font-size: 40px">注册</span></div>
    <form action="/user/add" class="regform">
        <input name="username" type="text" class="form-control" placeholder="用户名">
        <input name="nickname" type="text" class="form-control" placeholder="昵称">
        <input class="form-control" name="password" type="password" placeholder="密码">
        <input class="form-control" type="password" placeholder="重复密码">
        <button type="submit" class="btn btn-lg btn-primary btn-block">注册</button>
        <a class="login" href="/">登陆</a>
    </form>
</div>
</body>
</html>
