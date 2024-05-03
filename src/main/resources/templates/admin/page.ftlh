<#macro pagination totalPages currentPage requestUrl  defaultPageSize=10>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="${requestUrl}?page=${currentPage-1}&pageSize=${defaultPageSize}"
                   aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                </a>
            </li>

            <#-- 显示首页 -->
            <li class="page-item<#if (currentPage == 0)> disabled</#if>">
                <a class="page-link" href="${requestUrl}?page=0&pageSize=${defaultPageSize}">1</a>
            </li>

            <#-- 省略号逻辑 -->
            <#list 1..totalPages as page>
                <#if ((page - 1) == currentPage)>
                    <li class="page-item active"><span class="page-link">${page}</span></li>
                <#elseif ((page - 1) > currentPage - 2 && (page - 1) < currentPage + 2)>
                    <li class="page-item"><a class="page-link"
                                             href="${requestUrl}?page=${page-1}&pageSize=${defaultPageSize}">${page}</a>
                    </li>
                <#elseif ( page == 2 || page == totalPages - 1)>
                    <#if (currentPage > 2)>
                        <li class="page-item disabled"><span class="page-link">...</span></li>
                    </#if>
                </#if>
            </#list>

            <#-- 显示最后一页 -->
            <li class="page-item<#if (currentPage == totalPages - 1)> disabled</#if>">
                <a class="page-link"
                   href="${requestUrl}?page=${totalPages-1}&pageSize=${defaultPageSize}">${totalPages}</a>
            </li>

            <li class="page-item">
                <a class="page-link" href="${requestUrl}?page=${currentPage+1}&pageSize=${defaultPageSize}"
                   aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                </a>
            </li>
        </ul>

    </nav>
</#macro>
