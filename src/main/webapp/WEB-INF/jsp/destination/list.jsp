<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">

    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/guidestyle.css">
    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="css/pagination.css">
    <style>
    .thisfooter{
    	
    }
    .footer{
     position:relative;
    }
    </style>
</head>

<body style="background-color: #ffffff">

<jsp:include page="../header.jsp"/>

<div>
    <ul>
        <li style=" margin-bottom: 50px; margin-top: 30px">
            <div id="travelSearch">
                <div name="searchTop" action="guideListResult" class="travelSearch-form clearfix" target="_top">
                    <fieldset>
                        <legend>搜索</legend>
                        <div class="travelSearch-input clearfix">
                            <div class="s-combobox" id="s-combobox-119">
                                <div class="s-combobox-input-wrap">
                                    <input type="text" name="name" style="text-align:left" id="name"
                                           class="s-combobox-input" title="请输入搜索文字" aria-label="请输入搜索文字">
                                </div>
                                <button onclick="Query(1)">搜索<s></s></button>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </div>
        </li>
        <li>
            <div class="product_list qzlist2"
                 style=" height: auto; width: 970px; margin: 0 auto">
                <hr size="1">
                <ul id="guideInfo" style="margin-top: 30px">
                </ul>
                <div class="clear"></div>
                <div id="page" class="M-box3" style="align: center;z-index: -1;margin-top:30px;margin-bottom:30px;z-index: 1">

                </div>
            </div>
        </li>
    </ul>
	
</div>

<div class="thisfooter">
	<jsp:include page="../footer.jsp"/>
</div>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.pagination.js" type="text/javascript"></script>
<script type="text/javascript">

    $(function () {
        Query(1);
    });

    function Query(page) {
        $.ajax({
            url: 'deslist',
            type: 'post',
            data: {
                page: page,
                rows: 5,
                name: $("#name").val()
            },
            dataType: 'json',
            success: function (data) {
                var currentPage = data.currentPage;
                var totalPage = data.totalPage;
                var totalCount = data.totalCount;
                var html = '';
                if (data.list == null || data.list.length == 0) {
                    alert('没有数据');
                    return;
                }
                $.each(data.list, function () {
                    html += '<li id="' + this.id + '"><div style="margin-left: 40px"><div class="product_pic"><img src="' + this.picture + '" height="100px" width="100px"></div><div class="product_con"><div class="pro_info"><h2 style="height: 32px"><span style="text-align: justify">' + this.address + '<span style="color: #6d757a;font-size: large"><img src="images/pageviews.png"/>('+this.hit+')</span></span>';
                    if(this.hit>=500){
                        html += '<img src="images/hot.png" style="margin-left: 10px"/>';
                    }
                    html += '</h2><br/><div style="margin-top: 5px"><span class="txt">' + this.outline + '</span></div></div></div></div></li>';
                });
                $('#guideInfo').html('').append(html);
                $("#page").pagination({
                    pageCount: totalPage,
                    totalData: totalCount,
                    current: currentPage,
                    homePage: '首页',
                    endPage: '末页',
                    prevContent: '上页',
                    nextContent: '下页',
                    jump: true,
                    coping: true,
                    callback: function (index) {
                        Query(index.getCurrent());
                    }
                });
                $('li[id]').each(function () {
                    $(this).click(function () {
                        window.open('destination/detail/' + $(this).attr('id'));
                    })
                })
            }
        });
    }

</script>
</body>
</html>
