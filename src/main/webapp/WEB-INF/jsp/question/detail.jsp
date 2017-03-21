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

    <input type="hidden" name="id" value="${ques.id}">
    问题标题：<input type="text" name="title" value="${ques.title}"> <br>
    问题内容：<textarea name="content">${ques.content}</textarea> <br>
    选择目的地：<input type="text" name="dest" value="${ques.dest.id}"> ${ques.dest.value}<br>
    标签分类：${ques.tags[0].value} ${ques.tags[1].value} <br>

</form>


<jsp:include page="../reply/list.jsp">
    <jsp:param name="parid" value="${ques.id}"/>
</jsp:include>


<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.form.js" type="text/javascript"></script>
<script>
    function mdf() {
        $('#rep').ajaxSubmit({
            url: 'quesmdf',
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

    function ans() {
        $('#ans').ajaxSubmit({
            url: 'ansins',
            type: 'post',
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    alert('success');
                } else {
                    alert(data.msg);
                }
            }
        })
    }
</script>
</body>
</html>
