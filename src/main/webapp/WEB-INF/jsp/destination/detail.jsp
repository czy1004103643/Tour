<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/guidestyle.css"/>
    <link rel="stylesheet" type="text/css" href="css/pagination.css"/>
    <link rel="stylesheet" type="text/css" href="css/colorbox.css"/>
    <link rel="stylesheet" type="text/css" href="css/logincolorbox.css"/>
    <link rel="stylesheet" type="text/css" href="css/page-core.css"/>
</head>
<body style="background-color: #fff">

<jsp:include page="../header.jsp"/>

<div style="background-color: #fff">
    <div class="g-doc" style="border-bottom:1px solid #c0ecf4">
        <div class="img">
            <img src="${destination.picture}" alt="" height="250" width="100%">
        </div>
        <div class="n-show f-cb" id="showContent">
            <div class="cnt" style="margin-left: 10px">
                <span style="font-size: xx-large;font-weight: bolder;margin-top: 10px;margin-bottom: 50px">${destination.address}</span>
                <span style="color: #6d757a;font-size: large"><img src="images/pageviews.png"/>(${destination.hit})</span>
                <br/>
                <p><br/></p>
                <span style="font-weight: bold;margin-top: 10px;margin-bottom: 50px;font-size: larger">概述</span>
                <div align=""
                     style="margin-left: 40px; margin-right: 40px; margin-top: 40px; margin-bottom: 30px">
                    <p style="color: #505050">${destination.outline}</p>
                </div>
            </div>
        </div>
        <div class="cnt" style="margin-left: 10px">
            <span style="font-weight: bold;margin-top: 10px;margin-bottom: 50px;font-size: larger">详细信息</span>
            <div
                    style="margin-left: 40px; margin-right: 40px; margin-top: 40px; margin-bottom: 30px">
                <ul style="color: #505050">
                    <li>
                        <br/> <font size="3" face="微软雅黑">电话：</font>${destination.tel} <br/>
                        <br/> <font size="3" face="微软雅黑">开放时间：</font>${destination.open}</li>
                </ul>
            </div>
        </div>
        <div class="cnt" style="margin-left: 10px">
            <div class="n-detail">
                <span style="font-weight: bold;margin-top: 10px;margin-bottom: 50px;font-size: larger">特色</span>
                <br/>
                <div
                        style="margin-left: 40px; margin-right: 40px; margin-top: 40px; margin-bottom: 30px">
                    <p style="color: #505050">${destination.features}</p>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="../news/list.jsp">
        <jsp:param name="parid" value="${destination.id}"/>
    </jsp:include>

    <jsp:include page="../reply/list.jsp">
        <jsp:param name="parid" value="${destination.id}"/>
    </jsp:include>

</div>

<jsp:include page="../footer.jsp"/>

</body>
</html>
