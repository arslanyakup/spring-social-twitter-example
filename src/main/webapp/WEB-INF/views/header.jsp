<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: Arslan
  Date: 21.6.2017
  Time: 04:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <title>Dashboard Template for Bootstrap</title>
    <link rel="icon" href="<%=request.getContextPath()%>/resources/favicon.ico">
    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/resources/css/dashboard.css" rel="stylesheet">

</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Twitter Statistics is ${profile.name}</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/">Home</a>
                </li>
                <li>
                    <a href="/shareflood">Share Flood</a>
                </li>
            </ul>
            <c:url value="${pageContext.request.contextPath}/user" var="url"/>
            <form:form modelAttribute="user" action="${url}" method="get" class="navbar-form navbar-right">
                <div class="input-group">
                    <span class="input-group-addon">@</span>
                    <form:input path="username" type="text" class="form-control" placeholder="Kullanıcı Adı"/>
                </div>
                <input class="btn btn-default btn-primary" type="submit" value="Sorgula"/>
            </form:form>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="container">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-12 col-md-12 main">
                <h1 class="page-header">${profile.name}</h1>

                <div class="row placeholders">
                    <div class="col-xs-4 col-sm-4 placeholder">
                    </div>
                    <div class="col-xs-4 col-sm-4 placeholder">
                        <img src="${profile.profileImageUrl}" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                        <a href="${profile.profileUrl}"><h4>@${profile.screenName}</h4></a>
                        <span class="text-muted">Followers count: ${profile.followersCount}</span>
                        <span class="text-muted">Following count: ${profile.friendsCount}</span>
                    </div>
                    <div class="col-xs-4 col-sm-4 placeholder">
                    </div>
                </div>