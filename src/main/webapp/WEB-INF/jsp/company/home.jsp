<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <title>问答</title>
</head>
<body>

<jsp:include page="../header.jsp"/>

<h1>结伴专区</h1>

<a>结伴首页</a>

<br>


<a href="company/rep" target="_blank">发布结伴</a>

<br>

<c:forEach var="com" items="${companies}">
    <h3><a href="company/detail/${com.id}" target="_blank">${com.title}</a></h3> <br><br>
</c:forEach>

</body>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script>
</script>
</html>
