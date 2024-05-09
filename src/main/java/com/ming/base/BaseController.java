package com.ming.base;


import com.ming.core.utils.ServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;

public abstract class BaseController {
    public static Pageable pageable() {
        int pageNumber = 0;
        int pageSize = 15;
        String pageNumberStr = ServletUtils.getRequest().getParameter("page");
        if (StringUtils.isNumeric(pageNumberStr)) {
            pageNumber = Integer.parseInt(pageNumberStr);
        }
        String pageSizeStr = ServletUtils.getRequest().getParameter("pageSize");
        if (StringUtils.isNumeric(pageSizeStr)) {
            pageSize = Integer.parseInt(pageSizeStr);
        }
        return Pageable.ofSize(pageSize).withPage(pageNumber);
    }

}
