<!DOCTYPE HTML>
<html>
<#include "head.ftlh"/>
<body>

<#include "header.ftlh"/>

<div class="lyear-wrapper">
    <section class="mt-5 pb-5">
        <div class="container ">
            <div class="row">
                <!-- 文章列表 -->
                <!-- 文章阅读 -->
                <div class="col-xl-8">
                    <article class="lyear-arc">
                        <div class="arc-header">
                            <h2 class="arc-title"><a href="#">平头哥发布含光 800：高性能 AI 推理芯片</a></h2>
                            <ul class="arc-meta">
                                <li><i class="mdi mdi-calendar"></i> 2019-09-25 09:21</li>
                                <li><i class="mdi mdi-tag-text-outline"></i> <a href="#">AI</a>, <a href="#">芯片</a></li>
                                <li><i class="mdi mdi-comment-multiple-outline"></i> <a href="#">3 评论</a></li>
                            </ul>
                        </div>

                        <div class="arc-preview">
                            <img src="images/blog/post-1.png" alt="" class="img-fluid rounded" />
                        </div>

                        <div class="lyear-arc-detail">
<#--                            ${content}-->


                            <div class="mt-5">
                                <h6>Tags:</h6>
                                <div class="tag-cloud">
                                    <a href="#" class="badge badge-light">logo</a>
                                    <a href="#" class="badge badge-light">AI</a>
                                    <a href="#" class="badge badge-light">芯片</a>
                                </div>
                            </div>

                        </div>

                    </article>
                </div>
                <!-- 内容 end -->

                <!-- 侧边栏 -->
                <div class="col-xl-4">
                    <div class="lyear-sidebar">
                        <!-- 热门文章 -->
                        <aside class="widget widget-hot-posts">
                            <div class="widget-title">热门文章</div>
                            <ul>
                                <li>
                                    <a href="#">三星将为 Galaxy Fold 用户提供 149 美元更换屏幕服务</a> <span>2019-09-25 10:05</span>
                                </li>
                                <li>
                                    <a href="#">专家：10年后6G将问世 数据传输速率有望比5G快100倍</a>
                                    <span>2019-09-25 08:06</span>
                                </li>
                                <li>
                                    <a href="#">苹果正式发布 iPadOS 13.1 系统，加入多项强大新功能</a>
                                    <span>2019-09-25 09:35</span>
                                </li>
                            </ul>
                        </aside>

                        <!-- 归档 -->
                        <aside class="widget">
                            <div class="widget-title">分类</div>
                            <ul>
                                <#list categoryList as item>
                                    <li><a href="#">${item.name}</a>${item.articleEntitySet?size}</li>
                                </#list>
                            </ul>
                        </aside>

                        <!-- 标签 -->
                        <aside class="widget widget-tag-cloud">
                            <div class="widget-title">标签</div>
                            <div class="tag-cloud">
                                <#list tagList as item>
                                    <a href="#" class="badge badge-light">${item.name}</a>
                                </#list>
                            </div>
                        </aside>
                    </div>
                </div>
                <!-- 侧边栏 end -->
            </div>
        </div>
        <!-- end container -->
    </section>
</div>
<#include "footer.ftlh" />
</body>
</html>