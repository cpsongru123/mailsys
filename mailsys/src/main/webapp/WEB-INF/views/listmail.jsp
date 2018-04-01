<%--
  Created by IntelliJ IDEA.
  User: a9915
  Date: 2018/3/25
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MailList</title>
    <link rel="stylesheet" href="/res/bootstrap/css/bootstrap.css">
</head>
<body>
<div class="container">
    <header>收件箱</header>
    <table class="table" id="mailtable">
        <thead>
        <tr>
            <th><input type="checkbox" id="selected-all"></th>
            <th>发件人</th>
            <th>主题</th>
            <th>时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${messages}" var="message">
            <tr>
                <td><input type="checkbox" ></td>
                <td><c:out value="${message.mailMsgFrom}"></c:out></td>

                <td><c:out value="${message.mailMsgSubject}"></c:out></td>
                <td><c:out value="${message.mailMsgDate}"></c:out></td>

                <td>
                    <a href="/maildetail/${message.mailMsgId}" id="${message.mailMsgId}" class="btn btn-sm">查看</a>
                    <button onclick="forword(this);return false;" class="fw btn btn-default btn-sm" id="${message.mailMsgId}">转发</button>
                    <button onclick="reply(this);return false;" class="rp btn btn-sm" id="${message.mailMsgId}">回复</button>
                    <button	onclick="deletemsg(this)" class="btn btn-sm btn-danger" id="${message.mailMsgId}">删除</button>
                </td>
            </tr>
        </c:forEach>

        </tbody>

    </table>
</div>

<script type="text/javascript" src="/res/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/res/js/popper.js"></script>
<script type="text/javascript" src="/res/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function reply(btn) {
        var msgid = $(btn).attr("id");
        alert(msgid);
        $.ajax({
            url: '/reply?id='+msgid,
            type: "GET",
            async:true,
            error: function(request) {
                alert("Connection error");
            },
            success:function (result) {
                alert("succeeded!")
                console.log(result);
                $("body").html(result);
            }
        });
    }
    function forword(btn) {
        var msgid = $(btn).attr("id");
        alert(msgid);
        $.ajax({
            url: '/forword?id='+msgid,
            type: "GET",
            async:true,
            error: function(request) {
                alert("Connection error");
            },
            success:function (result) {
                alert("succeeded!")
                console.log(result);
                $("body").html(result);
            }
        });
    }

    function deletemsg(btn) {
        var msgid = $(btn).attr("id");
        alert(msgid);
        $.ajax({
            url: '/deletemsg?id='+msgid,
            type: "GET",
            async:true,
            error: function(request) {
                alert("Connection error");
            },
            success:function (result) {
                alert(result)
                console.log(result);
                window.location.reload(true);
            }
        });
    }



</script>
</body>
</html>
