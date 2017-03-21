<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="g-doc">
    <div class="n-show f-cb" id="info-panel">
        <br/>
        <span style="font-weight: bold;margin-top: 10px;margin-bottom: 50px;font-size: larger">景点资讯</span>
    </div>
    <div class="cnt" style="margin-left: 10px">
        <ul id="info">

        </ul>
    </div>
    <div id="page" class="M-box3" style="margin: 0 auto; width: 100%">
    </div>
</div>

<div id="infoDetail"></div>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.colorbox.js" type="text/javascript"></script>
<script>
    $(function () {
        Query(1);
    });

    function Query(page) {
        $.ajax({
            url: 'newslist',
            type: 'post',
            data: {
                page: page,
                rows: 10,
                destination: '${destination.id}'
            },
            dataType: 'json',
            success: function (data) {
                var currentPage = data.currentPage;
                var totalPage = data.totalPage;
                var totalCount = data.totalCount;
                $('#info').html('');
                $('#infoDetail').html('');
                if (data.list == null || data.list.length == 0) {
                    $('#page').hide();
                    $('#info').append('暂无资讯');
                    return;
                }
                $.each(data.list, function () {
                    $('#info')
                            .append(
                                    '<li><div style="margin-left:40px;margin-right: 40px; margin-top: 40px; margin-bottom: 30px"> <a id="' + this.id + 'luajk" href="#' + this.id + '"><font size="2" face="微软雅黑"> '
                                    + this.title
                                    + '</font></a></div></li>');
                    $('#infoDetail')
                            .append(
                                    ' <div style="display:none" >'
                                    + '<div class="inline" style="background-color:#fff; margin:20px"  id="' + this.id + '">' +

                                    '<div style=" background-color: inherit"><div style="text-align: center;margin-bottom: 10px" ><span style="font-weight:bold;">' + this.title + '</span><br><span style="font-size: small;font-weight: lighter;text-align: center">' + this.time + '</span></div><hr><br/><div>' + this.content + '</div><br><div style="text-align: right"><span style="font-style: italic">' + this.source +
                                    '</span></div></div></div>');
                    $("#" + this.id + "luajk").colorbox({
                        inline: true,
                        width: "50%",
                        opacity: 0.4
                    });
                });
                $("#page").pagination({
                    pageCount: totalPage,
                    totalData: totalCount,
                    showData: 2,
                    current: currentPage,
                    count: 5,
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
            }
        });
    }
</script>