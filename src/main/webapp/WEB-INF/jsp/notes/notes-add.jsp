<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <title>notes-add</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.form.js"></script>
    <script type="text/javascript" src="js/kindeditor-4.1.10/kindeditor.js"></script>
    <script type="text/javascript" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
</head>
<body>

<form id="notesAddForm">
    标题：<input type="text" name="title"> <br>
    <input type="hidden" name="coverPic">
    <textarea name="content"></textarea>
    <input type="hidden" name="userId" value="luajk">
    <button type="button" class="submit">确认</button>
</form>

<script>
    $(function () {
        var ed = KindEditor.create($('#notesAddForm textarea[name=content]'), {
            //指定上传文件参数名称
            filePostName: "uploadFile",
            //指定上传文件请求的url。
            uploadJson: 'pic/upload',
            afterUpload: function (url) {
                $('#notesAddForm input[name=coverPic]').val(url);
            },
            afterBlur: function () {
                this.sync();
            }
        });

        $('.submit').click(function () {
            $('#notesAddForm').ajaxSubmit({
                url: 'notes/create',
                type: 'post',
                dataType: 'json',
                success: function (data) {
                    if (data.status == 200) {
                        alert(data.msg);
                        window.location.href = 'notes/' + data.data.id;
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
