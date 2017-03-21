<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/guidestyle.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<jsp:include page="../header.jsp"/>
<c:set var="user" value="${sessionScope.user}"/>

<div class="g-doc" style="width: 600px;height: 450px;">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>修改密码</h2>
    </div>
    <div class="n-public">
        <form class="m-form m-form-ht" id="form" method="post"
              autocomplete="off">
            <input name="id" type="hidden" value="${user.id}"/>
            <input id="oldPassword_1" type="hidden" value="${user.password}"/>
            <div class="fmitem">
                <Label class="fmlab">请输入密码：</Label>
                <div class="fmipt">
                    <input class="u-ipt ipt" id="oldPassword" type="password" required/>
                    <Label id="oldEmpty" class="fmlab" style="padding-left: 10px; color: red">请输入原密码！</Label>
                    <Label id="verifyFail" class="fmlab" style="padding-left: 10px; color: red">密码验证未通过！</Label>
                </div>

            </div>
            <div class="fmitem">
                <Label class="fmlab">输入新密码：</Label>
                <div class="fmipt">
                    <input class="u-ipt ipt" id="newPassword" name="password" type="password" required/>
                    <Label id="newEmpty" class="fmlab" style="padding-left: 10px; color: red">请输入新密码！</Label>
                    <Label id="different" class="fmlab" style="padding-left: 10px;color: red">不得使用旧密码！</Label>
                </div>

            </div>
            <div class="fmitem">
                <Label class="fmlab">确认新密码：</Label>
                <div class="fmipt">
                    <input class="u-ipt ipt" id="newPassword_1" type="password" required/>
                    <Label id="newEmpty_1" class="fmlab" style="padding-left: 10px; color: red">请确认新密码！</Label>
                    <Label id="inconsistent" class="fmlab" style="padding-left: 10px;color: red">两次密码不一致！</Label>
                </div>

            </div>
            <br>
            <div class="fmitem fmitem-nolab fmitem-btn">
                <div class="fmipt" style="padding-left:100px;">
                    <input type="button" class="mybutton" value="确认修改" onclick="modify();"/>
                </div>
            </div>
        </form>

    </div>
</div>

<jsp:include page="../footer.jsp"/>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.form.js" type="text/javascript"></script>
<script type="text/javascript">

    $("#verifyFail").hide();
    $("#different").hide();
    $("#inconsistent").hide();
    $("#oldEmpty").hide();
    $("#newEmpty").hide();
    $("#newEmpty_1").hide();

    function modify() {
        $("#oldEmpty").hide();
        $("#newEmpty").hide();
        $("#newEmpty_1").hide();
        $("#verifyFail").hide();
        $("#inconsistent").hide();

        var existEmpty = 0;
        if ($("#oldPassword").val() == "") {
            $("#oldEmpty").show();
            existEmpty = 1;
        }
        if ($("#newPassword").val() == "") {
            $("#newEmpty").show();
            existEmpty = 1;
        }
        if ($("#newPassword_1").val() == "") {
            $("#newEmpty_1").show();
            existEmpty = 1;
        }
        
        if (existEmpty == 1) {
            return;
        }

        var notFormat = 0;
        if ($("#oldPassword").val() != $("#oldPassword_1").val()) {
            $("#verifyFail").show();
            notFormat = 1;
        }
        if ($("#newPassword").val() == $("#oldPassword_1").val()) {
            $("#different").show();
            notFormat = 1;
        }
        if ($("#newPassword").val() != $("#newPassword_1").val()) {
            $("#inconsistent").show();
            notFormat = 1;
        }
        if (notFormat == 0) {
            $('#form').ajaxSubmit({
                url: 'pwdModifyResult.do',
                type: 'post',
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        alert(data.msg);
                        location.href = 'userDetail.do';
                    } else {
                        alert(data.msg);
                    }
                }
            });
        }
    }
</script>
</body>
</html>
