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
    <title>MailDetail</title>
    <link rel="stylesheet" href="/res/bootstrap/css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <button class="btn btn-default">返回</button>
    <div>
    <table class="table">
        <tr>
            <td><span>主题：</span></td>
            <td><span>${mailMessage.mailMsgSubject}</span></td>
        </tr>
    </table>
    <table class="table">
        <tr>
            <td><span>收件人：</span></td>
            <td><span>${acc}</span></td>
        </tr>
    </table>
    <table class="table">
        <tr>
            <td><span>发件人:</span></td>
            <td><span>${mailMessage.mailMsgFrom}</span></td>
        </tr>
    </table>
    <table class="table">
        <tr>
            <td><span>发送时间：</span></td>
            <td><span>${mailMessage.mailMsgDate}</span></td>
        </tr>
    </table>
        <table class="table">
            <tr>
                <td><span>附件：</span></td>
                <td><span>${attachments}</span></td>
            </tr>
        </table>
    </div>

    <div id="content" class="contentdiv" style="margin-top: 20px">
        ${mailMessage.mailMsgContent}
    </div>
</div>

<script type="text/javascript" src="/res/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/res/js/popper.js"></script>
<script type="text/javascript" src="/res/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
