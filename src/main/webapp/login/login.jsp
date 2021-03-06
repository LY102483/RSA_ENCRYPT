<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>登陆</title>

    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">

    <link rel="stylesheet"
          href="/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="/assets/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="/assets/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="/assets/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="/assets/plugins/iCheck/square/blue.css">

    <script
            src="/assets/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script
            src="/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script
            src="/assets/plugins/iCheck/icheck.min.js"></script>
    <script src="/assets/js/jquery.form.js" type="text/javascript"></script>

    <script>
        $(function () {
            $('input').iCheck({
                checkboxClass: 'icheckbox_square-blue',
                radioClass: 'iradio_square-blue',
                increaseArea: '20%' // optional
            });
        });
    </script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#login").click(function () {
                $("#loginForm").ajaxSubmit({
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        var data = eval("(" + data + ")");//转换为json对象
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
</head>

<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>欢迎使用加密系统</b></a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <h3 class="login-box-msg">登录</h3>

        <form id="loginForm" action="/login/login" method="post">
            <div class="form-group has-feedback">
                <input type="text" name="name" class="form-control"
                       placeholder="用户名"> <span
                    class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" name="password" class="form-control"
                       placeholder="密码"> <span
                    class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row" style="display: flex;justify-content: center">
                <div class="col-xs-4">
                    <input type="button" id="login" class="btn btn-primary btn-block btn-flat" value="登陆"></input>
                </div>
            </div>
        </form>
        <a href="/register" style="display: flex;justify-content: center;margin-top: 30px">注册账号</a><br>
    </div>
</div>

</body>

</html>