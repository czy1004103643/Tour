
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

id:${com.id}  <br>

dest:${com.dest.value} <br>

start:${com.start.value} <br>

date:${com.date} <br>




<form id="reg">
    <button type="button" onclick="reg()">发布问题</button>
</form>


<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.form.js" type="text/javascript"></script>
<script>

    function reg() {
        $('#reg').ajaxSubmit({
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
