<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <title>问答</title>
</head>
<body>

<jsp:include page="../header.jsp"/>

<h1>问答专区</h1>

<a>问答首页</a>
<a>我的问答【我的提问、我的回答】</a>

<br>

<input type="text" name="q" placeholder="问题搜索">

<a href="ques/rep" target="_blank">我要提问</a>

<br>

<a href="javascript:void(0)" onclick="loadHot()">最热问题</a>
<a href="javascript:void(0)" onclick="loadHot()">最新问题</a>
<a href="javascript:void(0)" onclick="loadHot()">待回答问题</a><br>
<div id="data">

</div>

</body>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script>

    function loadHot() {
        $.ajax({
            url: 'queslist',
            type: 'get',
            dataType: 'json',
            success: function (data) {
                $.each(data,function () {
                    var html = '';
                    html += '<a href="ques/detail/'+this.id+'" target="_blank">' + this.title + '</a><br>';
                    html += '<h6>' + this.date + '</h6><br>';
                    html += '<p>' + this.content + '</p><br>';
                    html += '<p>' + this.tags[0].value + '</p> <p>' + this.tags[1].value + '</p>';
                    $('#data').append(html);
                })
            }
        });
    }

</script>
</html>
