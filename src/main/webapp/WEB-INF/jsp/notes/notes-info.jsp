<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <title>notes->${notes.id}</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>

<img src="${notes.coverPic}"> ----- <a href="notes/modify/${notes.id}" target="_self">修改</a><a href="javascript:void(0)" class="delete">删除</a>
<h1>${notes.title}</h1>

<span>发表时间:${notes.date}</span>

<div>
    ${notes.content}
</div>
<script>
    $(function () {
        $('.delete').click(function () {
            if (confirm('是否删除')) {
                $.post('notes/delete', {id: '${notes.id}'}, function (data) {
                    if (data.status == 200) {
                        alert(88);
                    } else {
                        alert(data.msg);
                    }
                })
            }
        })
    })
</script>
</body>
</html>
