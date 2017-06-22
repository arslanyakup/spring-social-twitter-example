<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: Arslan
  Date: 20.6.2017
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="icon" href="<%=request.getContextPath()%>/resources/favicon.ico">

    <title>Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/resources/css/signin.css" rel="stylesheet">

</head>

<body>

<div class="container">
    <div class="col-md-4"></div>
    <c:url value="${pageContext.request.contextPath}/user" var="url"/>
        <form:form action="${url}" modelAttribute="user" method="GET" class="col-md-4 form-group" style="margin-bottom: 200px;margin-top: 200px;">
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon">@</span>
                    <form:input path="username" type="text" id="inputEmail" class="form-control" placeholder="Kullanıcı Adı"/>
                </div>
                <input class="btn btn-lg btn-primary btn-block" style="margin-top: 10px;" type="submit" value="Sorgula"/>
            </div>
        </form:form>
    <div class="col-md-4"></div>
</div> <!-- /container -->

</body>
</html>

