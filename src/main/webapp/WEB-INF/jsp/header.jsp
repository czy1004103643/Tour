<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
    <div class="wrap">
        <div class="logo">
            <a href="index.jsp"><img src="images/logo.png" title="logo"/></a>
        </div>
        <div class="top-nav">
            <ul>
                <li><a href="index">主页</a></li>
                <li><a href="destination/list">目的地</a></li>
                <li><a href="tactic/list">旅游攻略</a></li>
                <li><a href="ques/hm">社区[问答]</a></li>
                <li><a href="company/hm">社区[游记、组团]</a></li>
                <li><a href="contact">联系我们</a></li>
                <c:if test="${sessionScope.user == null}">
                    <li><a href="login.jsp">登录/注册</a></li>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <li><a href="logout">你好，${sessionScope.user.nickName}![登出]</a></li>
                </c:if>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="clear"></div>