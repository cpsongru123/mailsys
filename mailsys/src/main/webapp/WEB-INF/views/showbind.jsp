<%--
  Created by IntelliJ IDEA.
  User: a9915
  Date: 2018/3/14
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>ShowBind</title>
    <link rel="stylesheet" href="/res/bootstrap/css/bootstrap.css">
</head>
<body>
<%@ include file="header.jsp"%>

<div class="container">
    <table class="table">
        <thead>
        <tr>

            <th>绑定邮箱</th>
            <th>邮箱账号</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bindlist}" var="vo">
            <tr>
                <td><c:out value="${vo.mailHostName}"></c:out></td>
                <td><c:out value="${vo.mailAcc}"></c:out></td>
                <td><c:out value="已绑定"></c:out></td>
                <td>
                    <button  class="btn btn-danger" onclick="unbind(${vo.id})">删除</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<script type="text/javascript" src="/res/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/res/js/popper.js"></script>
<script type="text/javascript" src="/res/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/res/js/mailbind.js"></script>
</body>
</html>
