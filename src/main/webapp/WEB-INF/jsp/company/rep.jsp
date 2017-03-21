<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <title>结伴</title>
</head>
<body>

<form id="rep">

    活动标题：<input type="text" name="title"> <br>
    联系方式：<input type="text" name="contact"> <br>
    目的地：<input type="text" name="dest.id"> <br>
    出发地：<input type="text" name="start.id"> <br>
    出发日期:<input type="text" name="date"> <br>
    活动天数:<input type="text" name="last"> <br>
    限制人数：<input type="text" name="num"> <br>
    结伴描述：<textarea name="desc"></textarea> <br>
    <input type="hidden" name="user.id" value="123456">
    <button type="button" onclick="rep()">发布问题</button>

</form>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.form.js" type="text/javascript"></script>
<script>

    function rep() {
        $('#rep').ajaxSubmit({
            url: 'comins',
            type: 'post',
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    alert('success');
                    location.href = 'company/detail/' + data.msg;
                } else {
                    alert(data.msg);
                }
            }
        })
    }
</script>
</body>
</html>
