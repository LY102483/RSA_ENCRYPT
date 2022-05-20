<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="/assets/js/jquery-1.4.4.min.js" type="text/javascript"></script>
    <script src="/assets/js/jquery.form.js" type="text/javascript"></script>
</head>

<body>
<form id="loginForm" action="/login/login" method="post">
    <label for="name">账号：</label>
    <input type="text" id="name" name="name"/>
    <label for="name">密码：</label>
    <input type="password" id="password" name="password"/>
    <input type="button" value="登陆" id="login"/>
</form>
<script type="text/javascript">
    $(document).ready(function () {
        $("#login").click(function () {
            $("#loginForm").ajaxSubmit({
                dataType: "json",
                type:"post",
                success: function (data) {
                    var data=eval("("+data+")");//转换为json对象
                    if (data.flag) {
                        window.location = "manage";
                    } else {
                        alert(data.msg);
                    }
                }
            });
        });
    });
</script>
</body>
</html>
