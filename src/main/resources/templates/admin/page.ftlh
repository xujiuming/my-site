<#macro pagination pageData requestUrl  defaultPageSize=25>
    <#assign currentPage=pageData.getNumber() />
    <#assign totalPages=pageData.getTotalPages() />
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <#-- 显示首页 -->
            <li class="page-item<#if (currentPage == 0)> disabled</#if>">
                <a class="page-link" href="${requestUrl}?page=0&pageSize=${defaultPageSize}" aria-label="First">首页</a>
            </li>


            <li class="page-item">
                <a class="page-link" href="${requestUrl}?page=${currentPage-1}&pageSize=${defaultPageSize}"
                   aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                </a>
            </li>
            <#-- 省略号逻辑 -->
            <#if ( totalPages <= 10)> <!-- 如果总页数小于等于10，不需要省略号 -->
                <#list 1..totalPages as page>
                    <li class="page-item<#if ((page - 1) == currentPage)> active</#if>">
                        <a class="page-link" href="${requestUrl}?page=${page-1}&pageSize=${defaultPageSize}">${page}</a>
                    </li>
                </#list>
            <#else>
                <#if (currentPage > 4)>
                    <li class="page-item disabled"><span class="page-link">...</span></li>
                </#if>

                <#assign startPage = [currentPage - 2, 1]?max />
                <#assign endPage = [currentPage + 2, totalPages]?min  />
                <#list startPage..endPage as page>
                    <li class="page-item<#if (page - 1) == currentPage> active</#if>">
                        <a class="page-link" href="${requestUrl}?page=${page-1}&pageSize=${defaultPageSize}">${page}</a>
                    </li>
                </#list>

                <#if (currentPage < totalPages - 3)>
                    <li class="page-item disabled"><span class="page-link">...</span></li>
                </#if>
            </#if>

            <li class="page-item">
                <a class="page-link" href="${requestUrl}?page=${currentPage+1}&pageSize=${defaultPageSize}"
                   aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                </a>
            </li>

            <#-- 显示最后一页 -->
            <li class="page-item<#if (currentPage == totalPages - 1)> disabled</#if>">
                <a class="page-link" href="${requestUrl}?page=${totalPages-1}&pageSize=${defaultPageSize}" aria-label="Last">尾页</a>
            </li>
        </ul>

    </nav>
</#macro>
