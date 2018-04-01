<%--
  Created by IntelliJ IDEA.
  User: a9915
  Date: 2018/3/27
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ListUser</title>
    <link rel="stylesheet" href="/res/bootstrap/css/bootstrap.css">
</head>
<body>
<%@ include file="adminheader.jsp"%>
<div class="container">
        <table class="table">
            <thead>
            <tr>
                <th>用户id</th>
                <th>用户名</th>
                <th>用户昵称</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="u">
                <tr>
                    <td><c:out value="${u.id}"></c:out></td>
                    <td><c:out value="${u.username}"></c:out></td>
                    <td><c:out value="${u.nickname}"></c:out></td>
                    <td>  <button onclick="deluser(this)" class="btn btn-danger"  sid="${u.id}">删除</button></td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
</div>
    <script type="text/javascript" src="/res/jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/res/js/popper.js"></script>
    <script type="text/javascript" src="/res/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function deluser(btn) {
        var id = $(btn).attr("sid");
        alert("id: "+id)
        $.ajax({
            url: '/deluser?id='+id,
            type: "GET",
            async:true,
            error: function(request) {
                alert("Connection error");
            },
            success:function (result) {
                console.log(result);
                window.location.reload(true);
            }
        });
    }
</script>
</body>
</html>
