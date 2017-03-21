<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">

    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/responsiveslides.css">
</head>
<body>

<jsp:include page="header.jsp"/>

<a name="top"></a>

<div class="image-slider">
    <ul class="rslides" id="slider1">
        <c:forEach var="pic" items="${pics}">
            <li>
                <a href="destination/detail/${pic.id}">
                    <img style="width: 100%;height: 75%" src="${pic.picture}" alt="${pic.address}">
                </a>
            </li>
        </c:forEach>
    </ul>
</div>

<div class="content">
    <div class="content_top">
        <div class="wrap">
            <h1><a>欢迎</a></h1>

            <p>无拘无束的旅游是偕意的飞翔

                走走跑跑

                拖着行李去流浪

                不要去思考

                也不用想象

                随意的在他乡游荡

                真想去游荡

                游荡在下雨的地方

                小雨滴答的声响

                像是催眠的迷茫

                滴答滴答滴滴答

                响在睡眠地前方

                梦想在飞翔

                不去看天空的风向

                因为我的执着

                坚持着梦想

                高山也为我让路

                海洋也会移向远方

                上帝都在为我指明方向
            </p>
            <span><a class="learnmore" href="destination/list">指南搜索</a></span>
        </div>
    </div>
    <div class="content-grids" style="height: 350px">
        <div class="wrap">
            <c:forEach var="top" items="${top3}" varStatus="status">
            <c:if test="${status.index != 2}">
            <div class="grid"></c:if>
                <c:if test="${status.index == 2}">
                <div class="grid spe-grid"></c:if>
                    <a href="destination/detail/${top.id}">
                        <img src="${top.picture}" title="image-name" height="150px" width="367px"/>
                    </a>
                    <h3>${top.address}<img src="images/hot.png" width="32px" height="16px"/></h3>
                    <p style="height: 100px">${top.outline}</p><a class="button"
                                                                  href="destination/detail/${top.id}">更多</a></div>
                </c:forEach>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    <div class="specials">
        <div class="wrap">
            <div class="specials-heading">
                <h3>精彩旅行</h3>
            </div>
            <div class="specials-grids">
                <c:forEach var="ran" items="${ran3}" varStatus="status">
                <c:if test="${status.index != 2}">
                <div class="special-grid" style="text-align: left"></c:if>
                    <c:if test="${status.index == 2}">
                    <div class="special-grid spe-grid" style="text-align: left"></c:if>
                        <img src="${ran.picture}" title="image-name" height="150px" width="100%"/>
                        <span style="width:100%;display: block;text-align: center;margin-bottom: 20px;margin-top: 15px;font-weight: bold;font-size: large">
                            <a href="destination/detail/${ran.id}">${ran.address}</a>
                            <img src="images/rec.png" width="32px" height="16px"/></span>
                        <p style="height: 100px;text-align: center">${ran.outline}</p>
                    </div>
                    </c:forEach>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
        <div class="testmonials">
            <div class="wrap">
                <div class="testmonial-grid">
                    <p>&#34; 世界那么大，不想去看看吗&#34;</p>
                    <p>&#34; 来一场说走就走的旅行吧&#34; </p>
                    <a href="#top"> - 返回顶部 - </a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="clear"></div>

<jsp:include page="footer.jsp"/>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/responsiveslides.min.js" type="text/javascript"></script>
<script>
    $(function () {
        $('#slider1').responsiveSlides({
            maxwidth: 2500,
            speed: 600
        });
    });
</script>
</body>
</html>


