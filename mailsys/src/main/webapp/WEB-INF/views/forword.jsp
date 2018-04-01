<%--
  Created by IntelliJ IDEA.
  User: a9915
  Date: 2018/3/27
  Time: 8:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SendMail</title>
    <link rel="stylesheet" href="/res/bootstrap/css/bootstrap.css">
    <script type="text/javascript">
        function send() {

            var formData = new FormData($("#sendmailForm")[0]);

            alert("发送成功");
            $.ajax({
                url: '/send',
                type: "POST",
                data: formData,
                async:true,
                contentType:false,
                processData:false,
                cache:false,
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
</head>
<body>
<%@ include file="header.jsp"%>
<div class="sendmail container">
    <header class="shd" style="font-size: 40px">发邮件</header>
    <form  class="sform" id="sendmailForm"  method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="receiver" class="control-label">收件人</label>
            <input id="receiver" type="text" name="email_recipientTo" class="form-control" value="${replyfrom}">
        </div>
        <div class="form-group">
            <label for="sel" class="control-label">选择邮箱</label>
            <select id="sel" name="email_from" class="form-control">
                <option value="">请选择邮箱账号</option>
                <c:forEach items="${bindlist}" var="vo">
                    <option value="${vo.mailAcc}" ${acc==vo.mailAcc?'selected':''}>${vo.mailAcc}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="att" class="layui-form-label">上传附件</label>
            <input id="att" class="form-control" type="file" name="file" multiple>
        </div>

        <div class="form-group">
            <label for="subj" class="control-label">邮件主题</label>
            <input id="subj" type="text" name="email_subject"  class="form-control" value="Fw: ${forwordmsg.mailMsgSubject}">
        </div>
        <div class="form-group">
            <label for="email_content" class="control-label">邮件内容</label>
            <textarea id="email_content" name="email_content" class="form-control">


                -------- 转发邮件信息 --------
            发件人：${forwordmsg.mailMsgFrom}
            发送日期：${forwordmsg.mailMsgDate}
            收件人：${acc}<br>
            主题：${forwordmsg.mailMsgSubject}
            ${forwordmsg.mailMsgContent}
            </textarea>


        </div>
        <button onclick="send();return false;" class="btn btn-primary">发送</button>
    </form>

</div>

<script type="text/javascript" src="/res/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/res/js/popper.js"></script>
<script type="text/javascript" src="/res/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>

