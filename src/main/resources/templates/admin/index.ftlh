<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="author" content="ming">
    <title>ming后台管理系统</title>
    <link rel="shortcut icon" type="image/x-icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <#include "./cssInclude.ftlh"/>
</head>

<body class="lyear-index">
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <aside class="lyear-layout-sidebar">

            <!-- logo -->
            <div id="logo" class="sidebar-header">
                <a href="/admin/index"><span>ming后台管理</span></a>
            </div>
            <div class="lyear-layout-sidebar-info lyear-scroll">

                <nav class="sidebar-main">

                    <ul class="nav-drawer">
                        <li class="nav-item active">
                            <a class="multitabs" href="/admin/main" id="default-page">
                                <i class="mdi mdi-home-city-outline"></i>
                                <span>后台首页</span>
                            </a>
                        </li>
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)">
                                <i class="mdi mdi-television-guide"></i>
                                <span>文章管理</span>
                            </a>
                            <ul class="nav nav-subnav">
                                <li><a class="multitabs" href="/admin/article/main">文章</a></li>
                                <li><a class="multitabs" href="lyear_layout_containers.html">类别</a></li>
                                <li><a class="multitabs" href="lyear_layout_grid.html">标签</a></li>
                                <li><a class="multitabs" href="lyear_layout_grid.html">回复</a></li>
                            </ul>
                        </li>

                        <div class="sidebar-footer">
                            <p class="copyright">
                                <span>Copyright &copy; 2024. </span>
                                <a target="_blank" href="http://www.xujiuming.com">ming</a>
                                <span> All rights reserved.</span>
                            </p>
                        </div>
            </div>

        </aside>
        <!--End 左侧导航-->

        <!--头部信息-->
        <header class="lyear-layout-header">

            <nav class="navbar">

                <div class="navbar-left">
                    <div class="lyear-aside-toggler">
                        <span class="lyear-toggler-bar"></span>
                        <span class="lyear-toggler-bar"></span>
                        <span class="lyear-toggler-bar"></span>
                    </div>
                </div>

                <ul class="navbar-right d-flex align-items-center">
                    <!--顶部消息部分-->
                    <li class="dropdown dropdown-notice">
            <span data-bs-toggle="dropdown" class="position-relative icon-item">
              <i class="mdi mdi-bell-outline fs-5"></i>
              <span class="position-absolute translate-middle badge bg-danger">7</span>
            </span>
                        <div class="dropdown-menu dropdown-menu-end">
                            <div class="lyear-notifications">

                                <div class="lyear-notifications-title d-flex justify-content-between"
                                     data-stopPropagation="true">
                                    <span>你有 10 条未读消息</span>
                                    <a href="#!">查看全部</a>
                                </div>
                                <div class="lyear-notifications-info lyear-scroll">
                                    <a href="#!" class="dropdown-item"
                                       title="树莓派销量猛增，疫情期间居家工作学习、医疗领域都需要它">树莓派销量猛增，疫情期间居家工作学习、医疗领域都需要它</a>
                                    <a href="#!" class="dropdown-item"
                                       title="GNOME 用户体验团队将为 GNOME Shell 提供更多改进">GNOME 用户体验团队将为
                                        GNOME Shell
                                        提供更多改进</a>
                                    <a href="#!" class="dropdown-item"
                                       title="Linux On iPhone 即将面世，支持 iOS 的双启动">Linux On iPhone 即将面世，支持
                                        iOS
                                        的双启动</a>
                                    <a href="#!" class="dropdown-item" title="GitHub 私有仓库完全免费面向团队提供">GitHub
                                        私有仓库完全免费面向团队提供</a>
                                    <a href="#!" class="dropdown-item"
                                       title="Wasmtime 为 WebAssembly 增加 Go 语言绑定">Wasmtime 为 WebAssembly 增加 Go
                                        语言绑定</a>
                                    <a href="#!" class="dropdown-item"
                                       title="红帽借“订阅”成开源一哥，首创者 Cormier 升任总裁">红帽借“订阅”成开源一哥，首创者
                                        Cormier 升任总裁</a>
                                    <a href="#!" class="dropdown-item" title="Zend 宣布推出两项 PHP 新产品">Zend 宣布推出两项
                                        PHP 新产品</a>
                                </div>

                            </div>
                        </div>
                    </li>
                    <!--End 顶部消息部分-->
                    <!--切换主题配色-->
                    <li class="dropdown dropdown-skin">
		    <span data-bs-toggle="dropdown" class="icon-item">
              <i class="mdi mdi-palette fs-5"></i>
            </span>
                        <ul class="dropdown-menu dropdown-menu-end" data-stopPropagation="true">
                            <li class="lyear-skin-title"><p>主题</p></li>
                            <li class="lyear-skin-li clearfix">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="site_theme" id="site_theme_1"
                                           value="default" checked="checked">
                                    <label class="form-check-label" for="site_theme_1"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="site_theme" id="site_theme_2"
                                           value="translucent-green">
                                    <label class="form-check-label" for="site_theme_2"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="site_theme" id="site_theme_3"
                                           value="translucent-blue">
                                    <label class="form-check-label" for="site_theme_3"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="site_theme" id="site_theme_4"
                                           value="translucent-yellow">
                                    <label class="form-check-label" for="site_theme_4"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="site_theme" id="site_theme_5"
                                           value="translucent-red">
                                    <label class="form-check-label" for="site_theme_5"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="site_theme" id="site_theme_6"
                                           value="translucent-pink">
                                    <label class="form-check-label" for="site_theme_6"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="site_theme" id="site_theme_7"
                                           value="translucent-cyan">
                                    <label class="form-check-label" for="site_theme_7"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="site_theme" id="site_theme_8"
                                           value="dark">
                                    <label class="form-check-label" for="site_theme_8"></label>
                                </div>
                            </li>
                            <li class="lyear-skin-title"><p>LOGO</p></li>
                            <li class="lyear-skin-li clearfix">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="logo_bg" id="logo_bg_1"
                                           value="default" checked="checked">
                                    <label class="form-check-label" for="logo_bg_1"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="logo_bg" id="logo_bg_2"
                                           value="color_2">
                                    <label class="form-check-label" for="logo_bg_2"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="logo_bg" id="logo_bg_3"
                                           value="color_3">
                                    <label class="form-check-label" for="logo_bg_3"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="logo_bg" id="logo_bg_4"
                                           value="color_4">
                                    <label class="form-check-label" for="logo_bg_4"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="logo_bg" id="logo_bg_5"
                                           value="color_5">
                                    <label class="form-check-label" for="logo_bg_5"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="logo_bg" id="logo_bg_6"
                                           value="color_6">
                                    <label class="form-check-label" for="logo_bg_6"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="logo_bg" id="logo_bg_7"
                                           value="color_7">
                                    <label class="form-check-label" for="logo_bg_7"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="logo_bg" id="logo_bg_8"
                                           value="color_8">
                                    <label class="form-check-label" for="logo_bg_8"></label>
                                </div>
                            </li>
                            <li class="lyear-skin-title"><p>头部</p></li>
                            <li class="lyear-skin-li clearfix">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="header_bg" id="header_bg_1"
                                           value="default" checked="checked">
                                    <label class="form-check-label" for="header_bg_1"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="header_bg" id="header_bg_2"
                                           value="color_2">
                                    <label class="form-check-label" for="header_bg_2"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="header_bg" id="header_bg_3"
                                           value="color_3">
                                    <label class="form-check-label" for="header_bg_3"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="header_bg" id="header_bg_4"
                                           value="color_4">
                                    <label class="form-check-label" for="header_bg_4"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="header_bg" id="header_bg_5"
                                           value="color_5">
                                    <label class="form-check-label" for="header_bg_5"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="header_bg" id="header_bg_6"
                                           value="color_6">
                                    <label class="form-check-label" for="header_bg_6"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="header_bg" id="header_bg_7"
                                           value="color_7">
                                    <label class="form-check-label" for="header_bg_7"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="header_bg" id="header_bg_8"
                                           value="color_8">
                                    <label class="form-check-label" for="header_bg_8"></label>
                                </div>
                            </li>
                            <li class="lyear-skin-title"><p>侧边栏</p></li>
                            <li class="lyear-skin-li clearfix">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="sidebar_bg" id="sidebar_bg_1"
                                           value="default" checked="checked">
                                    <label class="form-check-label" for="sidebar_bg_1"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="sidebar_bg" id="sidebar_bg_2"
                                           value="color_2">
                                    <label class="form-check-label" for="sidebar_bg_2"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="sidebar_bg" id="sidebar_bg_3"
                                           value="color_3">
                                    <label class="form-check-label" for="sidebar_bg_3"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="sidebar_bg" id="sidebar_bg_4"
                                           value="color_4">
                                    <label class="form-check-label" for="sidebar_bg_4"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="sidebar_bg" id="sidebar_bg_5"
                                           value="color_5">
                                    <label class="form-check-label" for="sidebar_bg_5"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="sidebar_bg" id="sidebar_bg_6"
                                           value="color_6">
                                    <label class="form-check-label" for="sidebar_bg_6"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="sidebar_bg" id="sidebar_bg_7"
                                           value="color_7">
                                    <label class="form-check-label" for="sidebar_bg_7"></label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="sidebar_bg" id="sidebar_bg_8"
                                           value="color_8">
                                    <label class="form-check-label" for="sidebar_bg_8"></label>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!--End 切换主题配色-->
                    <!--个人头像内容-->
                    <li class="dropdown">
                        <#if userInfo??>
                            <a href="javascript:void(0)" data-bs-toggle="dropdown" class="dropdown-toggle">
                                <img class="avatar-md rounded-circle" src="${userInfo.avatar}" alt="ming"/>
                                <span style="margin-left: 10px;">${userInfo.username}</span>
                            </a>
                        <#else>
                            <a href="javascript:void(0)" data-bs-toggle="dropdown" class="dropdown-toggle">
                                <img class="avatar-md rounded-circle" src="" alt="ming"/>
                                <span style="margin-left: 10px;">昵称异常</span>
                            </a>
                        </#if>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <li>
                                <a class="multitabs dropdown-item" data-url="lyear_pages_profile.html"
                                   href="javascript:void(0)">
                                    <i class="mdi mdi-account"></i>
                                    <span>个人信息</span>
                                </a>
                            </li>
                            <li>
                                <a class="multitabs dropdown-item" data-url="lyear_pages_edit_pwd.html"
                                   href="javascript:void(0)">
                                    <i class="mdi mdi-lock-outline"></i>
                                    <span>修改密码</span>
                                </a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="javascript:void(0)">
                                    <i class="mdi mdi-delete"></i>
                                    <span>清空缓存</span>
                                </a>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <a class="dropdown-item" href="lyear_pages_login_1.html">
                                    <i class="mdi mdi-logout-variant"></i>
                                    <span>退出登录</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <!--End 个人头像内容-->
                </ul>

            </nav>

        </header>
        <!--End 头部信息-->

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div id="iframe-content"></div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<#include "./jsInclude.ftlh" />
<script type="text/javascript">
    $(document).ready(function (e) {
    });
</script>
</body>
</html>
