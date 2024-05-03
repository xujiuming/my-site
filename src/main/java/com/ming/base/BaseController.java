package com.ming.base;


import com.ming.core.utils.ServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;

public interface BaseController {

    default Pageable pageable() {
        Integer pageNumber = 0;
        Integer pageSize = 25;
        String pageNumberStr = ServletUtils.getRequest().getParameter("page");
        if (StringUtils.isNumeric(pageNumberStr)) {
            pageNumber = Integer.valueOf(pageNumberStr);
        }
        String pageSizeStr = ServletUtils.getRequest().getParameter("pageSize");
        if (StringUtils.isNumeric(pageSizeStr)) {
            pageSize = Integer.valueOf(pageSizeStr);
        }
        return Pageable.ofSize(pageSize).withPage(pageNumber);
    }
}
