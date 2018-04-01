<%--
  Created by IntelliJ IDEA.
  User: a9915
  Date: 2018/3/25
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bind</title>
    <link rel="stylesheet" href="/res/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/res/css/bindedit.css">
</head>
<body>
<%@ include file="header.jsp"%>
<div class="bec container">
    <header class="bhd header-panel" style="font-size: 30px">绑定邮箱</header>
    <form class="bindeditform" id="bindform">
        <select name="mailHostName" class="eip form-control">
            <option value="email163">163</option>
            <option value="qq">qq</option>
        </select>
        <input name="username" class="eip hidden" value="${user.username}">
        <input name="mailAcc" class="eip form-control" placeholder="邮箱账号">
        <input name="mailAuth" class="eip form-control" placeholder="授权码">
        <button type="submit" onclick="bind();return false;" class="eip btn btn-primary">绑定</button>
    </form>
</div>
<script type="text/javascript" src="/res/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/res/js/popper.js"></script>
<script type="text/javascript" src="/res/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/res/js/mailbind.js"></script>
</body>
</html>
