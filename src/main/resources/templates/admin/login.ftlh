<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="keywords" content="LightYear,LightYearAdmin,光年,后台模板,后台管理系统,光年HTML模板">
    <meta name="description" content="Light Year Admin V5是一个基于Bootstrap v5.1.3的后台管理系统的HTML模板。">
    <meta name="author" content="yinq">
    <title>登录 - ming后台管理系统</title>
    <link rel="shortcut icon" type="image/x-icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <link rel="stylesheet" type="text/css" href="/css/materialdesignicons.min.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="/admin/style.min.css">
    <style>
        .signin-box {
            background-color: rgba(255, 255, 255, .25);
            width: 420px;
        }

        .signin-box p:last-child {
            margin-bottom: 0px;
        }

        .signin-form .form-control {
            background: rgba(0, 0, 0, 0.3);
            color: #fff;
        }

        .signin-form .has-feedback {
            position: relative;
        }

        .signin-form .has-feedback .form-control {
            padding-left: 36px;
        }

        .signin-form .has-feedback .mdi {
            position: absolute;
            top: 0;
            left: 0;
            right: auto;
            width: 36px;
            height: 36px;
            line-height: 36px;
            z-index: 4;
            color: #dcdcdc;
            display: block;
            text-align: center;
            pointer-events: none;
        }

        .signin-form .has-feedback.row .mdi {
            left: 15px;
        }

        .signin-form .form-control::-webkit-input-placeholder {
            color: rgba(255, 255, 255, .8);
        }

        .signin-form .form-control:-moz-placeholder {
            color: rgba(255, 255, 255, .8);
        }

        .signin-form .form-control::-moz-placeholder {
            color: rgba(255, 255, 255, .8);
        }

        .signin-form .form-control:-ms-input-placeholder {
            color: rgba(255, 255, 255, .8);
        }

        .signin-form .custom-control-label::before {
            background: rgba(0, 0, 0, 0.3);
            border-color: rgba(0, 0, 0, 0.1);
        }

        .signin-form .form-check-input {
            background-color: transparent;
            border-color: #fff;
        }
    </style>
</head>

<body class="center-vh" style="background-image: url(/images/login-bg-4.jpg); background-size: cover;">
<div class="signin-box p-5 mb-0 mr-2 ml-2">
    <div class="text-center mb-3">
        <a href="index.html"> <img alt="light year admin" src="/images/logo-sidebar.png"> </a>
    </div>
    <#if errorAuthMsg??>
        <h4 style="color: red">${errorAuthMsg}</h4>
    </#if>
    <form action="#!" method="post" class="signin-form needs-validation" novalidate>
        <div class="mb-3 has-feedback">
            <span class="mdi mdi-account" aria-hidden="true"></span>
            <input type="text" class="form-control" name="username" id="username" placeholder="用户名" required>
        </div>

        <div class="mb-3 has-feedback">
            <span class="mdi mdi-lock" aria-hidden="true"></span>
            <input type="password" class="form-control" name="password" id="password" placeholder="密码" required>
        </div>

        <div class="mb-3 has-feedback row">
            <div class="col-7">
                <span class="mdi mdi-check-all form-control-feedback" aria-hidden="true"></span>
                <input type="text" name="captcha" id="captcha-id" class="form-control" placeholder="验证码" required>
            </div>
            <div class="col-5 text-right">
                <img src="/captcha/generator" class="pull-right" id="captcha" style="cursor: pointer;"
                     onclick="this.src=this.src+'?d='+Math.random();" title="点击刷新" alt="captcha">
            </div>
        </div>

        <div class="mb-3">
            <div class="form-check text-white">
                <input type="checkbox" class="form-check-input" id="rememberme">
                <label class="form-check-label not-user-select" for="rememberme">5天内自动登录</label>
            </div>
        </div>

        <div class="mb-3 d-grid">
            <button class="btn btn-primary" type="submit">立即登录</button>
        </div>
    </form>

    <p class="text-center text-white">Copyright © 2022 <a target="_blank"
                                                          href="http://www.bixiaguangnian.com">笔下光年</a>. All right
        reserved</p>
</div>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/popper.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/lyear-loading.js"></script>
<script type="text/javascript" src="/js/bootstrap-notify.min.js"></script>
<script type="text/javascript">
    var loader;
    $(document).ajaxStart(function () {
        $("button:submit").html('登录中...').attr("disabled", true);
        loader = $('button:submit').lyearloading({
            opacity: 0.2,
            spinnerSize: 'nm'
        });
    }).ajaxStop(function () {
        loader.destroy();
        $("button:submit").html('立即登录').attr("disabled", false);
    });
    $('.signin-form').on('submit', function (event) {
        if ($(this)[0].checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
            $(this).addClass('was-validated');
            return false;
        }
        //提前验证验证码
        var $data = $(this).serialize();
        $.post($(this).attr('action'), $data, function (res) {
            if (res.code === 0) {
                $.notify({
                    message: '登录成功，页面即将跳转~',
                }, {
                    type: 'success',
                    placement: {
                        from: 'top',
                        align: 'right'
                    },
                    z_index: 10800,
                    delay: 1500,
                    animate: {
                        enter: 'animate__animated animate__fadeInUp',
                        exit: 'animate__animated animate__fadeOutDown'
                    }
                });
                setTimeout(function () {
                    location.href = '/admin/index';
                }, 1500);
            } else {
                $.notify({
                    message: '登录失败，错误原因：' + res.msg,
                }, {
                    type: 'danger',
                    placement: {
                        from: 'top',
                        align: 'right'
                    },
                    z_index: 10800,
                    delay: 1500,
                    animate: {
                        enter: 'animate__animated animate__shakeX',
                        exit: 'animate__animated animate__fadeOutDown'
                    }
                });
                $('#password').val('');
                $("#captcha").click();
            }
        }).fail(function () {
            $.notify({
                message: '服务器错误',
            }, {
                type: 'danger',
                placement: {
                    from: 'top',
                    align: 'right'
                },
                z_index: 10800,
                delay: 1500,
                animate: {
                    enter: 'animate__animated animate__shakeX',
                    exit: 'animate__animated animate__fadeOutDown'
                }
            });
        });

        return false;
    });
</script>
</body>
</html>