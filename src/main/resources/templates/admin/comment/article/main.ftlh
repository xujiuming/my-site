<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <title>文章列表 - ming后台管理系统</title>
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="default">
    <#include "../../cssInclude.ftlh"/>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
            <div class="card">
                <header class="card-header">
                    <div class="card-title">文章列表</div>
                </header>
                <div class="card-body">
                    <div class="card-search mb-2-5">
                        <form class="search-form" method="get" action="#!" role="form">

                            <div class="row">
                                <div class="col-md-4">
                                    <div class="row">
                                        <label class="col-sm-4 col-form-label"><span class="text-danger">*</span> 任务名称</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control pull-left" name="name" value=""
                                                   placeholder="请输入任务名称"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <button type="submit" class="btn btn-primary me-1">搜索</button>
                                    <button type="reset" class="btn btn-default">重置</button>
                                </div>
                            </div>

                        </form>
                    </div>
                    <div class="card-btns mb-2-5">
                        <a class="btn btn-primary me-1" href="#!"><i class="mdi mdi-plus"></i> 新增</a>
                        <a class="btn btn-success me-1" href="#!"><i class="mdi mdi-check"></i> 启用</a>
                        <a class="btn btn-warning me-1" href="#!"><i class="mdi mdi-block-helper"></i> 禁用</a>
                        <a class="btn btn-danger" href="#!"><i class="mdi mdi-window-close"></i> 删除</a>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="check-all">
                                        <label class="form-check-label" for="check-all"></label>
                                    </div>
                                </th>
                                <th>ID</th>
                                <th>标题</th>
                                <th>类别</th>
                                <th>标签</th>
                                <th>状态</th>
                                <th>发布时间</th>
                                <th>修改时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input ids" name="ids[]" value="1"
                                               id="ids-1">
                                        <label class="form-check-label" for="ids-1"></label>
                                    </div>
                                </td>
                                <td>1</td>
                                <td>第01章 天涯思君不可忘</td>
                                <td>《倚天屠龙记》</td>
                                <td>金庸</td>
                                <td>36</td>
                                <td><font class="text-success">正常</font></td>
                                <td>
                                    <div class="btn-group btn-group-sm">
                                        <a class="btn btn-default" href="#!" data-bs-toggle="tooltip" title="编辑"><i
                                                    class="mdi mdi-pencil"></i></a>
                                        <a class="btn btn-default" href="#!" data-bs-toggle="tooltip" title="删除"><i
                                                    class="mdi mdi-window-close"></i></a>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <ul class="pagination">
                        <li class="page-item disabled"><span class="page-link">上一页</span></li>
                        <li class="page-item active"><span class="page-link">1</span></li>
                        <li class="page-item"><a class="page-link" href="#1">2</a></li>
                        <li class="page-item"><a class="page-link" href="#1">3</a></li>
                        <li class="page-item"><a class="page-link" href="#1">4</a></li>
                        <li class="page-item"><a class="page-link" href="#1">5</a></li>
                        <li class="page-item disabled"><span class="page-link">...</span></li>
                        <li class="page-item"><a class="page-link" href="#!">14452</a></li>
                        <li class="page-item"><a class="page-link" href="#!">14453</a></li>
                        <li class="page-item"><a class="page-link" href="#!">下一页</a></li>
                    </ul>
                </div>
            </div>
        </div>

    </div>

</div>


<#include "../../jsInclude.ftlh"/>
</body>
</html>