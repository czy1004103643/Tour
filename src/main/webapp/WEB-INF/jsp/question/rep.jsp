<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <title>提问</title>
</head>
<body>

<form id="rep">

    问题标题：<input type="text" name="title"> <br>
    问题内容：<textarea name="content"></textarea> <br>
    选择目的地：<input type="text" name="dest"> <br>
    标签分类：<input type="text" name="tags"> <br>
    是否匿名:<input type="radio" name="anon" value="0">否<input type="radio" name="anon" value="1">是 <br>

    <button type="button" onclick="rep()">发布问题</button>

</form>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.form.js" type="text/javascript"></script>
<script>

    function rep() {
        $('#rep').ajaxSubmit({
            url: 'quesins',
            type: 'post',
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    alert('success');
                    location.href = 'ques/detail/' + data.msg;
                } else {
                    alert(data.msg);
                }
            }
        })
    }
</script>
</body>
</html>
