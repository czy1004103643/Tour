<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/guidestyle.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>

<jsp:include page="../header.jsp"/>

<c:set var="user" value="${sessionScope.user}"/>

<div class="g-doc" style="width: 600px;height: 750px;">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>用户信息</h2>
    </div>
    <div class="n-public">
        <form class="m-form m-form-ht" id="form" method="post"
              autocomplete="off" enctype="multipart/form-data" >
            <input name="id" type="hidden" value="${user.id}"/>
            <span class="imgpre" id="image"><img src="${user.photo}"></span>
            <div class="fmitem">
                <label class="fmlab">账　　号：</label>
                <div class="fmipt" style="vertical-align:middle">
                    <span id="username">
                        <p >${user.username}</p>
                    </span>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab" >昵　　称：</label>
                <div class="fmipt" style="vertical-align:middle">
                    <span id="nickName">
                        <p>${user.nickName}</p>
                    </span>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">真实姓名：</label>
                <div class="fmipt" style="vertical-align:middle">
                    <span id="realName">
                        <p>${user.realName}</p>
                    </span>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">性　　别：</label>
                <div class="fmipt" style="vertical-align:middle">
                   <span id="sex">
                       <c:if test="${user.sex == 0}">
                           <p >男</p>
                       </c:if>
                       <c:if test="${user.sex == 1}">
                           <p >女</p>
                       </c:if>
                   </span>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab" >出生日期：</label>
                <div class="fmipt" style="vertical-align:middle">
                    <span id="birthDate">
                        <p><fmt:formatDate  type="date" value="${user.birthDate}" dateStyle="default"/> </p>
                    </span>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">手机号码：</label>
                <div class="fmipt" style="vertical-align:middle">
                    <span id="phone">
                        <p>${user.phone}</p>
                    </span>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">电子邮箱：</label>
                <div class="fmipt" style="vertical-align:middle">
                    <span id="email">
                        <p>${user.email}</p>
                    </span>
                </div>
            </div>
            <div class="fmitem">
                <label id="photoLabel" class="fmlab">头　　像：</label>
                <div class="fmipt">
                    <span id="photo"></span>
                </div>
            </div>
            <br>
            <div class="fmitem">
                <label class="fmlab"></label>
                <div class="fmipt">
                    <button type="button" class="mybutton" id="modify" onclick="Button()">修改信息
                    </button>
                    <div style="padding-left:100px;">
                    <button type="button" class="mybutton"  id="submit" onclick="Submit()">确认提交
                    </button>
                    </div>
                </div>
                <div class="fmipt">
                    <A href="pwdModify.do">
                        <button type="button" class="mybutton" id="pwdModify">修改密码
                        </button>
                    </A>
                </div>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../footer.jsp"/>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.form.js" type="text/javascript"></script>
<script type="text/javascript">

    $('#submit').hide();
    $('#photoLabel').hide();

    function Button() {
        $('#image').hide();
        $('span').each(function () {
            var id = $(this).attr('id');
            var val = $(this).text();
            if(id==image){
                return;
            }
            if (id == 'username') {
                $(this).html('').append('<input class="u-ipt ipt" type="hidden" name="' + id + '" value="' + val.trim() + '">'+
                    '<p>'+val+'</p>');
                return;
            }
            if(id=='nickName'){
                $(this).html('').append('<input class="u-ipt ipt" type="text" id="nickname" name="' + id + '" value="' + val.trim()  + '" >'
                    +'<Label id="nickNameEmpty" class="fmlab" style="padding-left: 10px;color: red" >昵称不得为空！　　</Label>');
                return;
            }
            if(id=='realName'){
                $(this).html('').append('<input class="u-ipt ipt" type="text" id="realname" name="' + id + '" value="' + val.trim()  + '" required >'
                +'<Label id="realNameEmpty" class="fmlab" style="padding-left: 10px;color: red" >真实姓名不得为空！</Label>');
                return;
            }
            if (id == 'sex') {
                $(this).html('').append('<input style="vertical-align: center" type="radio" name="' + id + '" value="0"> 男　')
                    .append('<input style="vertical-align: center" type="radio" name="' + id + '" value="1"> 女');
                if (val == '男') {
                    $('input[type="radio"][value="0"]').attr('checked', true);
                } else {
                    $('input[type="radio"][value="1"]').attr('checked', true);
                }
                return;
            }
            if (id == 'birthDate') {
                $(this).html('').append('<input class="u-ipt ipt" type="date" name="' + id + '" value="' + val.trim()  + '">');
                return;
            }
            if (id == 'email') {
                $(this).html('').append('<input class="u-ipt ipt" type="email" name="' + id + '" value="' + val.trim() + '">');
                return;
            }
            if (id == 'photo') {
                $(this).html('').append('<input style="padding-top: 4px;" type="file" name="' + id + '" value="' + val.trim() + '">');
                return;
            }
            $(this).html('').append('<input class="u-ipt ipt" type="text" name="' + id + '" value="' + val.trim() + '">');
        });
        $("#submit").show();
        $("#photoLabel").show();
        $("#modify").hide();
        $("#pwdModify").hide();
        $("#nickNameEmpty").hide();
        $("#realNameEmpty").hide();

    }

    function Submit() {
        var flag=0;
        if ($("#nickname").val() == "") {
            $("#nickNameEmpty").show();
            flag=1;
        }
        if ($("#realname").val() == "") {
            $("#realNameEmpty").show();
            flag=1;
        }

        if(flag==0)
        $('#form').ajaxSubmit({
            url: 'userModifyResult.do',
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
        })
    }

</script>
</body>
</html>
