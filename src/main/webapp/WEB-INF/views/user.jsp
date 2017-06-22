<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <h4 class="sub-header">Takipçiler</h4>
                    </thead>
                    <thead>
                    <tr>
                        <th>Adı</th>
                        <th>Kullanıcı Adı</th>
                        <th>Takipçi Sayısı</th>
                        <th>Takip Edilen Sayısı</th>
                        <th>Açıklama</th>
                        <th>Takip Ediyor muyum?</th>
                        <th>Bilgi</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${followers}" var="user">
                            <tr>
                                <td>${user.name}</td>
                                <td>${user.screenName}</td>
                                <td>${user.followersCount}</td>
                                <td>${user.friendsCount}</td>
                                <td>${user.description}</td>
                                <td>
                                    <c:if test="${user.following==false}">
                                        <h5 class="list-group-item list-group-item-danger">Hayır</h5>
                                    </c:if>
                                    <c:if test="${user.following==true}">
                                        <h5 class="list-group-item list-group-item-success">Evet</h5>
                                    </c:if>
                                </td>
                                <td><a href="/user?username=${user.screenName}">${user.screenName}</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="<%=request.getContextPath()%>/resources/js/holder.min.js"></script>
</body>
</html>

