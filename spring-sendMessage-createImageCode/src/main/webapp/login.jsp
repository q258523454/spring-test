<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆界面</title>
</head>
<body>

    username:<input id="usernameId" type="text" name = "username" ><p>
    password:<input id="passwordId" type="password" name = "password" ><p>
    <input id="clickLogin" type="button" value="login">
    <input type="button" value="register" onclick="window.location.href='register.jsp'"></input>

</body>


<script language="JavaScript" type="text/javascript">
    $(function () {
        $("#clickLogin").click(function () {
            $.ajax({
                type: "POST",                   // 请求方式
                url: "/login.do",              // 请求路径：页面/方法名字
                data: {
                    username: $('#usernameId').val(),
                    password: $('#passwordId').val(),
                },// 注意参数名要注意和后台参数名要一致, 如果是bean, 要和bean中的成员变量名一致
                dataType: "json",
                async : false,                    // 是否异步执行
                success: function (data) {       // data 返回一定要是一个封装类, 我返回普通的字符串报错
                    if (data.res == "success"){
                        alert("success.");
                    }else if (data.res == "passwordError"){
                        alert("passwordError.");
                    }else{
                        alert("nothing.");
                    }
                },
                error: function (obj, msg, e) { // 异常
                    alert("异常.");
                }
            });
        });
    });
</script>


</html>