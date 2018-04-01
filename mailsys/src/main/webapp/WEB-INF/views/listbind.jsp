<%--
  Created by IntelliJ IDEA.
  User: a9915
  Date: 2018/3/27
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListBind</title>
    <link rel="stylesheet" href="/res/bootstrap/css/bootstrap.css">
</head>
<body>
<%@ include file="adminheader.jsp"%>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>用户名</th>
            <th>绑定邮箱</th>
            <th>邮箱帐号</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${binds}" var="bind">
            <tr>
                <td><c:out value="${bind.username}"></c:out></td>
                <td><c:out value="${bind.mailHostName}"></c:out></td>
                <td><c:out value="${bind.mailAcc}"></c:out></td>
                <td> <button onclick="delbind(this)" class="btn btn-danger"  sid="${bind.id}">删除</button></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>
<script type="text/javascript" src="/res/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/res/js/popper.js"></script>
<script type="text/javascript" src="/res/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function delbind(btn) {
        var id = $(btn).attr("sid");
        alert("id: "+id)
        $.ajax({
            url: '/delbind?id='+id,
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
