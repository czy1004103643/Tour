<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="g-doc">
    <div class="n-show f-cb" id="reply-panel">
        <br/>
        <span style="font-weight: bold;margin-top: 10px;margin-bottom: 50px;font-size: larger">用户评论</span>
    </div>
    <div class="cnt" style="margin-left: 10px">
        <div id="reply" class="common">
            <div class="comm">
                <div class="bilibili-reply">
                    <div class="comm_send">
                        <div class="tg_send_post">
                            <div class="dcmp_content">
                                <div class="user_face">
                                    <img src="images/photo.jpg">
                                </div>
                                <div id="dcmp_textarea_container"
                                     class="dcmp-textarea-container focus">
                                    <div class="login-link-wrp">
                                        请先 <a href="#inline-content"  class="login_button" id="innerlogin" style="margin-left: 3px;margin-right: 3px;background-color: #00b5e5;border: 2px solid #00b5e5;border-radius: 4px;color:#fff" >&nbsp;&nbsp;登录&nbsp;&nbsp;</a> 后发表评论
                                    </div>
                                    <i class="b-icon b-icon-triangle-gray-left"></i>
                                    <textarea cols="80" name="msg" rows="5" id="comment_text"
                                              placeholder="请自觉遵守互联网相关的政策法规，严禁发布色情、暴力、反动的言论。"
                                              class="b-input ipt-txt"></textarea>
                                    <button type="submit" class="b-btn submit-reply disabled">发表评论</button>
                                    <div id="textarea_size_tester"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <ul id="comment_info" class="comm_list">
                    </ul>
                </div>
            </div>

        </div>
    </div>
    <div id="comemntpage" class="M-box3" style="margin: 0 auto; width: 100%">
    </div>
</div>

<div style="display: none">
    <div id="inline-content">
        <div class="form">
            <div id="landing">登录</div>
            <div id="registered">注册</div>
            <div class="fix"></div>
            <div id="landing-content">
                <form id="login">
                    <div id="photo">
                        <img src="images/photo.jpg"/>
                    </div>
                    <div class="inp">
                        <input type="text" name="username" placeholder="账号"/>
                    </div>
                    <div class="inp">
                        <input type="password" name="password" placeholder="密码"/>
                    </div>
                    <button class="login_button" type="button" onclick="Login()">登录</button>
                </form>
            </div>
            <div id="registered-content">
                <div class="inp">
                    <input type="text" id="rusername" name="rusername"
                           placeholder="请输入账号"/>
                </div>
                <div class="inp">
                    <input type="text" id="rnickName" name="rnickName"
                           placeholder="请输入昵称"/>
                </div>
                <div class="inp">
                    <input type="password" id="rpassword" name="rpassword"
                           placeholder="请输入密码"/>
                </div>
                <div class="inp">
                    <input type="password" id="rrpassword" name="rrpassword"
                           placeholder="请重复密码"/>
                </div>
                <div class="login_button" type="button" onclick="Register()">注册</div>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.form.js" type="text/javascript"></script>
<script src="js/jquery.pagination.js" type="text/javascript"></script>
<script src="js/jquery.colorbox.js" type="text/javascript"></script>
<script>
    $(function () {
        $("#innerlogin").colorbox({
            inline: true,
            width: "350px"
        });
        $("#landing").addClass("border-btn").click(function () {
            $("#registered").removeClass("border-btn");
            $(this).addClass("border-btn");
            $("#landing-content").show(500);
            $("#registered-content").hide(500);
        });
        $("#registered").click(function () {
            $("#landing").removeClass("border-btn");
            $("#landing-content").hide(500);
            $(this).addClass("border-btn");
            $("#registered-content").show(500);
        });
    });

    QueryComment(1);

    function QueryComment(page) {
        $.ajax({
            url: 'comlist',
            type: 'post',
            data: {
                page: page,
                rows: 5,
                destination: '${param.parid}'
            },
            dataType: 'json',
            success: function (data) {
                var currentPage = data.currentPage;
                var totalPage = data.totalPage;
                var totalCount = data.totalCount;
                var html = '';
                var com = '';
                if ('${sessionScope.user}' != null
                        && '${sessionScope.user}' != '') {
                    $('.user_face').children().attr("src",
                            "${sessionScope.user.photo}");
                    $('.login-link-wrp').remove();
                    $('.b-btn').attr("class",
                            "b-btn submit-reply");
                    $('.b-btn').bind("click", insertComment);
                }
                if (data.list == null || data.list.length == 0) {
                    $('#comment_info').html('暂无评论');
                    return;
                }
                $.each(data.list, function () {
                    $.each(this.replies, function () {
                        com += '<li style="margin-left:80px;height: 55px" class="re_ul"><div style="margin-left:80px" class="facebox"><img src="' + this.user.photo + '"></div><div class="w"><span style="width:100%;margin-right:18px" class="name">'
                                + this.user.nickName
                                + " :  "
                                + '</span><span class="content">'
                                + this.content
                                + '</span></div></li>'
                    });
                    html += '<li class="main-floor"><div class="facebox"><a target="_blank"><img src="' + this.user.photo + '" class="face"></a></div><div class="t"><a>'
                            + this.user.nickName
                            + '</a></div><div class="content">'
                            + this.content
                            + '</div><button style="margin-top: 10px;margin-bottom: 10px" onclick="reply('
                            + "'"
                            + this.id
                            + "',event"
                            + ')">回复</button><div style="width : 100%" id=' + this.id + '></div><div class="reply"><ul class="re_ul"> ';
                    if (com != '') {
                        html += com;
                    }
                    html += '<ul></div></li>';
                    com = '';
                });
                $('#comment_info').html('').append(html);
                $('#comment_counts').text(totalCount);
                $('#reply').bind("click", function () {
                    $('#replyDIV').remove();
                });
                $("#comemntpage").pagination({
                    pageCount: totalPage,
                    totalData: totalCount,
                    current: currentPage,
                    homePage: '首页',
                    endPage: '末页',
                    prevContent: '上页',
                    nextContent: '下页',
                    jump: true,
                    callback: function (index) {
                        QueryComment(index.getCurrent());
                    }
                });
            }
        });
    }

    function reply(replyid,event) {
        if ('${sessionScope.user}' == null || '${sessionScope.user}' == '') {
            $('#inpuntID').remove();
            alert('请先登录');
            $('#innerlogin').click();
            return;
        }
        $('#replyDIV').remove();
        var html = '';
        html += '<div id="replyDIV"><textarea id="replyText"  style="width: 89%;height: 60px;text-align: left;" type="text"></textarea><button class="b-btn submit-reply" style="float:right;width: 70px;height: 60px" onclick="insertReply('
                + "'" + replyid + "'" + ')">确定</button></div>';
        $('#' + replyid + '').html('').append(html);
        $('#replyDIV').bind("click", function (event) {
            event.stopPropagation();
        });
        event.stopPropagation();
    }
    function stopPropagation(e){
        e=window.event||e;
        if(document.all){  //只有ie识别
            e.cancelBubble=true;
        }else{
            e.stopPropagation();
        }
    }
    function insertComment() {
        if ($('#comment_text').val() == null
                || $('#comment_text').val() == '') {
            alert("评论不能为空");
            return;
        }
        $.ajax({
            url: 'comins',
            type: 'post',
            data: {
                content: $('#comment_text').val(),
                type: 2,
                parent: '${destination.id}'
            },
            success: function (data) {
                $('#comment_text').val('');
                QueryComment(1);
            }
        });
    }
    function insertReply(replyid) {
        if ($('#replyText').val() == null || $('#replyText').val() == '') {
            alert("评论不能为空");
            return;
        }
        $.ajax({
            url: 'comins',
            type: 'post',
            data: {
                content: $('#replyText').val(),
                type: 1,
                parent: replyid
            },
            success: function (data) {
                $('#inpuntID').remove();
                QueryComment(1);
            }
        });
    }

    function Login() {
        $('#login').ajaxSubmit({
            url: 'login',
            type: 'post',
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    location.reload();
                } else {
                    alert(data.msg);
                }
            }
        })
    }
    function Register() {
        if ($('#rusername').val() == '') {
            alert("账号不能为空");
            return;
        }
        if ($('#rnickName').val() == '') {
            alert("昵称不能为空");
            return;
        }
        if ($('#rpassword').val() != $('#rrpassword').val()) {
            alert("前后密码不一致");
            return;
        }
        $('#register').ajaxSubmit({
            url: 'userInsertResult.do',
            type: 'post',
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    location.reload();
                } else {
                    alert(data.msg);
                }
            }
        })
    }
</script>