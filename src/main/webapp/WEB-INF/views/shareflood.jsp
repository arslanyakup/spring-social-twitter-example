<%@include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form:form modelAttribute="user" action="/sharefloodtweet" method="get">
            <h2>Flood</h2>
            <form:textarea cssClass="form-control" path="floodTweetContent"/>
            <input style="margin-top: 10px;" class="btn btn-default btn-primary" type="submit" value="Share"/>
        </form:form>
    </div>
    <div class="col-md-2"></div>
</div>
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="<%=request.getContextPath()%>/resources/js/holder.min.js"></script>
</body>
</html>
