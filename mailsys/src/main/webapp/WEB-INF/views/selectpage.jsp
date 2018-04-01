<%--
  Created by IntelliJ IDEA.
  User: a9915
  Date: 2018/3/26
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SelectAcc</title>
    <link rel="stylesheet" href="/res/bootstrap/css/bootstrap.css">
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container">
    <div class="selacc container">
        <select class="sel" id="selectedacc" name="selectedAcc">
            <option value="-1">选择邮箱账号</option>
            <c:forEach items="${bindlist}" var="vo">
                <option value="${vo.mailAcc}" ${selectedval==vo.mailAcc?'selected':''}>${vo.mailAcc}</option>
            </c:forEach>
        </select>
    </div>
    <div id="maillist" class="container">
        <c:choose>
            <c:when test="${not empty acc}">
                <c:import url="/listmail"></c:import>
            </c:when>
            <c:otherwise>
                <c:out value="请先选择一个已绑定的邮箱账号"></c:out>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<script type="text/javascript" src="/res/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/res/js/popper.js"></script>
<script type="text/javascript" src="/res/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $("document").ready(function() {
        $("#selectedacc").change(function () {

            var bindac = $("#selectedacc").val();
            if(bindac=='-1')
                return false;
            alert(bindac);
            $.ajax({
                type:"post",
                async:"true",
                url:"/listmail",
                data:{mailacc:bindac},
                success:function(data){
                    $("#maillist").html(data);
                }
            });

        });
    });
</script>
</body>
</html>
