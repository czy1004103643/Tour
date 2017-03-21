<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">

    <link href="../../css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="../../css/responsiveslides.css">
    <link rel="stylesheet" href="../../css/colorbox.css">
    <link rel="stylesheet" href="../../css/logincolorbox.css">
    <style>
        .form {
            position: absolute;
            top: 56%;
            left: 80%;
            margin-left: -185px;
            margin-top: -210px;
            height: 420px;
            width: 340px;
            font-size: 18px;
            -webkit-box-shadow: 0px 0px 10px #A6A6A6;
            z-index: 3;
        }

        body {
           
        }
        .image-slider {
            height: auto;
        }
        .rslides img{
        height: 750px;
        }
        .footer:after{
        z-index:5;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="image-slider">
    <ul class="rslides" id="slider1">

        <%

            for(int i=1;i<25;i++){
                out.println("<li>\n" +
                        "            <img src=\"images/1 ("+i+").jpg\">\n" +
                        "        </li>");
            }

        %>

    </ul>
</div>
<div class="form">
    <div id="landing">登录</div>
    <div id="registered">注册</div>
    <div class="fix"></div>
    <div id="landing-content">
        <form id="login">
            <div id="photo"><img src="../../images/photo.jpg"/></div>
            <div class="inp"><input type="text" name="username" placeholder="账号"/></div>
            <div class="inp"><input type="password" name="password" placeholder="密码"/></div>
            <div class="login_button" type="button" onclick="Login()">登录</div>
        </form>
    </div>
    <div id="registered-content">
        <form id="register">
            <div class="inp"><input type="text" id="rusername" name="rusername" placeholder="请输入账号"/></div>
            <div class="inp"><input type="text" id="rnickName" name="rnickName" placeholder="请输入昵称"/></div>
            <div class="inp"><input type="password" id="rpassword" name="rpassword" placeholder="请输入密码"/></div>
            <div class="inp"><input type="password" id="rrpassword" name="rrpassword" placeholder="请重复密码"/></div>
            <div class="login_button" type="button" onclick="Register()">注册</div>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp"/>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.form.js" type="text/javascript"></script>
<script src="js/responsiveslides.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        $("#landing").addClass("border-btn").click(function () {
            $("#registered").removeClass("border-btn");
            $(this).addClass("border-btn");
            $("#landing-content").show(500);
            $("#registered-content").hide(500);
        });

        $("#registered").click(function () {
            $("#landing").removeClass("border-btn");
            $("#landing-content").hide(500);
            $(this).addClass("border-btn");
            $("#registered-content").show(500);
        });
        $('#slider1').responsiveSlides({
            maxwidth: 2500,
            speed: 600
        });

        if ('${requestScope.msg}' != '') {
            alert('${requestScope.msg}');
        }

    });
    function Login() {
        $('#login').ajaxSubmit({
            url: 'login',
            type: 'post',
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    if (data.msg == '') {
                        location.href = 'index.jsp';
                    } else {
                        location.href = data.msg;
                    }
                } else {
                    alert(data.msg);
                }
            }
        })
    }
    function Register() {
        //TODO 验证插件验证
        if ($('#rusername').val() == '') {
            alert("账号不能为空");
            return;
        }
        if ($('#rnickName').val() == '') {
            alert("昵称不能为空");
            return;
        }
        if ($('#rpassword').val() != $('#rrpassword').val()) {
            alert("前后密码不一致");
            return;
        }
        $('#register').ajaxSubmit({
            url: 'userInsertResult',
            type: 'post',
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    location.href = 'userDetail.do';
                } else {
                    alert(data.msg);
                }
            }
        })
    }
</script>
</body>
</html>
