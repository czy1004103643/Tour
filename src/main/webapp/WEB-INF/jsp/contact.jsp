<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">

    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <style type="text/css">
        #container {
            width: 25%;
            height: 25%;
        }
    </style>
</head>

<body>

<jsp:include page="header.jsp"/>

<div class="content">
    <div class="wrap">
        <div class="section group">
            <div class="col span_1_of_3">
                <div class="contact_info">
                    <h3>我们在这儿</h3>
                    <div class="map">
                        <div id="container" style="margin-left: 85px;margin-top: 200px"></div>
                    </div>
                </div>
            </div>
            <div class="col span_2_of_3">
                <div class="contact-form">
                    <h3>联系我们</h3>
                    <form id="fm">
                        <div>
                            <span><label>姓名</label></span>
                            <span><input name="userName" type="text" class="textbox"></span>
                        </div>
                        <div>
                            <span><label>邮箱</label></span>
                            <span><input name="userEmail" type="text" class="textbox"></span>
                        </div>
                        <div>
                            <span><label>手机</label></span>
                            <span><input name="userPhone" type="text" class="textbox"></span>
                        </div>
                        <div>
                            <span><label>您的建议</label></span>
                            <span><textarea name="userMsg"> </textarea></span>
                        </div>
                        <div>
                            <span><input type="button" class="mybutton" onclick="Submit()" value="提交"></span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div class="clear"></div>

<jsp:include page="footer.jsp"/>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script src="http://cache.amap.com/lbs/static/es5.min.js"></script>
<script src="http://webapi.amap.com/maps?v=1.3&key=a7de736c21c683a64d24a247879d9ca7"></script>
<script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
<script>
    //创建地图,设定地图的中心点和级别
    var map = new AMap.Map('container', {
        resizeEnable: true,
        zoom:14,
        center: [125.2747, 43.820999]

    });
    //TODO  创建控件并添加
    //信息窗体的创建与设定
    var infowindow = new AMap.InfoWindow({
        offset: new AMap.Pixel(0, -30),
        size:new AMap.Size(230,0)
    });
    //点标记的创建与添加
    var marker = new AMap.Marker({
        position: [120.2, 30.3],
        map:map
    });

</script>
</body>
</html>


