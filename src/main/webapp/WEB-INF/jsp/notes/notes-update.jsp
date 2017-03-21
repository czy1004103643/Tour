
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <title>notes-update</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.form.js"></script>
    <script type="text/javascript" src="js/kindeditor-4.1.10/kindeditor.js"></script>
    <script type="text/javascript" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
</head>
<body>
<form id="notesUpdateForm">
    <input type="hidden" name="id" value="${notes.id}">
    标题：<input type="text" name="title" value="${notes.title}"> <br>
    <textarea name="content">${notes.content}</textarea>
    <button type="button" class="submit">确认</button>
</form>

<script>
    $(function () {
        var ed = KindEditor.create($('#notesUpdateForm textarea[name=content]'), {
            //指定上传文件参数名称
            filePostName: "uploadFile",
            //指定上传文件请求的url。
            uploadJson: 'pic/upload',
            afterBlur: function () {
                this.sync();
            }
        });

        $('.submit').click(function () {
            $('#notesUpdateForm').ajaxSubmit({
                url: 'notes/update',
                type: 'post',
                dataType: 'json',
                success: function (data) {
                    if (data.status == 200) {
                        alert(data.msg);
                        window.location.href = 'notes/${notes.id}';
                    } else {
                        alert(data.msg);
                    }

                }
            })
        })
    })
</script>
</body>
</html>
