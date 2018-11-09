<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 18/3/2
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<html>
<head>
    <title>register jsp </title>
</head>
<style type="text/css">
    .spanuinfo_checkCode {
        width: 82px;
        border: 1px solid #eee;
        background: #f4f4f4;
        line-height: 32px;
        text-align: center;
        color: red;
        display: inline-block;
        *display: inline;
        *zoom: 1;
        font-weight: 600;
        vertical-align: middle;
    }
</style>
<body>


<form action="register.do" method="post">
        username:<input id="usernameID" type="text" name="username"><small id="usernameSpanId"><span>*</span></small>
    <p>
        password:<input id="passwordID" type="password" name="password">
    <p>
        telephone:<input id="telephoneID" type="telephone" name="telephone">
    <p>
        verifyCode:<input id="verifyCodeID" type="verifyCode" name="verifyCode">
        <small id="verifyCodeSpanId"><span>*</span></small>
        <a href="javaScript:void(0)" id="sendSMS">发送短信</a>
        <p class="wcatFont"></p>
    <p>
        <span>imgCode<em class="red">*</em></span>
        <input type="text" id="imgVerifyCodeId" maxlength="4" placeholder="Please type the image code.">
        <%-- new Date().getTime() 必须要写, 由于浏览器每次点击url请求一样, 浏览器不会refres图片, 所以强制性加一个参数, 保持每次点击的链接url请求不同--%>
        <label class="spanuinfo_checkCode"><img id="imgVcode" onclick="changeImage()" src="/getCheckImage?"+new Date().getTime() /></label>
        <small id="imgVerifyCodeSpan"><img src="" style="top: 8px;"><span></span></small>
    <p>
        email:<input id="emailID" type="email" name="email">
        <a href="javaScript:void(0)" id="sendEmailId">发送邮件</a>
    <p>
        <input type="submit" value="register">
        <%--<input value="Send message" id="sendSMS" type="button">--%>
</form>


</body>

<script language="JavaScript" type="text/javascript">

    var smsVerifyCode=''; //短信验证码
    var imgVerCode=''; //图形验证
    var msgWaitTime=10;//短信验证码等待时间

    // username输入框-失焦事件
    $("#usernameID").blur(function () {
        ajaxAccountName($("#usernameID"), "#usernameSpanId");
    });

    // 验证码输入框-键盘按键[按下-松开]事件, 按键松开后出发, 即输入每一个验证码单个字符的时候都进行检测
    $("#verifyCodeID").keyup(function(){
        smsCodeKeyup($("#verifyCodeID"),"#verifyCodeSpanId");
    });

    $("#imgVerifyCodeId").keyup(function(){
        imgCodeKeyup($("#imgVerifyCodeId"),"#imgVerifyCodeSpan");
    });

    // 发送短信, 点击时间
    $("#sendSMS").click(function () {
        if( ( msgWaitTime>=0 && msgWaitTime<=5) || (msgWaitTime === 10)) {
            $.ajax({
                type: "POST",                   // 请求方式
                url: "/sendSMS",              // 请求路径：页面/方法名字
                data: {
                    username: $('#usernameID').val(),
                    password: $('#passwordID').val(),
                    telephone: $('#telephoneID').val(),
                },      // 注意参数名要注意和后台方法参数名要一致
                dataType: "json",
                async: false,                   // 是否异步执行
                success: function (msg) {       // 成功
                    if (msg.verifyCode != "") {
                        smsVerifyCode = msg.verifyCodeJson;
                        msgWaitTime = 10;//每次点击重置时间
                        wTime($("#sendSMS"), $(".wcatFont"));
                    } else {
                        alert("Can not create msg vertify code.");
                    }
                },
                error: function (obj, msg, e) { // 异常
                    alert("ERROR:404");
                }
            });
        }
    });

    // 发送邮箱注册
    $("#sendEmailId").click(function () {
        $.ajax({
            type: "POST",                   // 请求方式
            url: "/sendEmail",              // 请求路径：页面/方法名字
            data: {
                toEmail: $('#emailID').val(),
            },      // 注意参数名要注意和后台方法参数名要一致
            dataType: "json",
            async: false,                   // 是否异步执行
            success: function (msg) {       // 成功
                if (msg.res == "ok") {
                    alert("Yes.");
                } else {
                    alert("No.");
                }
            },
            error: function (obj, msg, e) { // 异常
                alert("ERROR:404");
            }
        });
    });

    function wTime(sendSMS,spaninfoSMS){
        if(msgWaitTime>5 && msgWaitTime<=10){
            spaninfoSMS.html("短信验证码已发送至您的手机，请在"+msgWaitTime+"秒内输入");
            sendSMS.html((msgWaitTime-5)+"s后重试");
            msgWaitTime--;
            wsetTime = setTimeout(function(){
                wTime(sendSMS,spaninfoSMS);
            },1000)
        }else if(msgWaitTime>=0 && msgWaitTime<=5) {
            spaninfoSMS.html("短信验证码已发送至您的手机，请在"+msgWaitTime+"秒内输入");
            sendSMS.html("发送短信");
            msgWaitTime--;
            wsetTime = setTimeout(function(){
                wTime(sendSMS,spaninfoSMS);
            },1000)
        }else{
            spaninfoSMS.html("请点击发送短信，重新获取验证码");
            sendSMS.html("发送短信");
        }
    }

    function replaceSpan(id,content){
        $(id).find("span").html(content);
    }

    //账号唯一性验证
    function ajaxAccountName($usernameID,spaninfo) {
        $.ajax({
            data : "username="+ $usernameID.val(),
            type : "GET",
            dataType : 'json',
            url : "/checkUserNameUnique",
            async : false,
            error : function(data) {
            },
            success : function(data) {
                if (data.res === "isExist") {  //已存在
                    replaceSpan(spaninfo,"Already exist.");
                }else if(data.res === "notExist")
                    replaceSpan(spaninfo,"Can use");
                }
        });
    }

    // 短信验证码验证
    function smsCodeKeyup($verifyCodeID,spaninfo){
        if($verifyCodeID.val()===smsVerifyCode){
            replaceSpan(spaninfo,"success.");
        }else {
            replaceSpan(spaninfo,"error");
        }
    }

    function changeImage(){
        var img = document.getElementById("imgVcode");
        img.src = "/getCheckImage?"+new Date().getTime();
    }

    function imgCodeKeyup($imgVerifyCodeId,imgVerifyCodeSpan){
        if($imgVerifyCodeId.val().length === 4){
            $.ajax({
                type : "post",
                dataType : 'json',
                url : "/getImageVerifyCode?sessionCode="+$imgVerifyCodeId.val(), // 注意 imgCode 与 controller 中的类或者参数保持一致
                async : false,
                error : function(data) {
                },
                success : function(data) {
                    if(data.res === "true"){
                        replaceSpan(imgVerifyCodeSpan,"Correct");
                    }else{
                        replaceSpan(imgVerifyCodeSpan,"Error");
                    }
                }
            });
        }
    }


</script>

</html>
