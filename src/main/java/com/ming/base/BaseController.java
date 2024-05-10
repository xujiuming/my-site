package com.ming.base;


import com.ming.core.utils.ServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public abstract class BaseController {
    public static final int DEFAULT_PAGE_NUMBER = 0;
    public static final int DEFAULT_PAGE_SIZE = 15;


    public static Pageable pageable(int pageNumber, int pageSize, Sort.Direction direction, String... properties) {
        return PageRequest.of(pageNumber, pageSize, direction, properties);
    }

    public static Pageable pageable(int pageNumber, int pageSize, Sort sort) {
        return PageRequest.of(pageNumber, pageSize, sort);
    }

    public static Pageable pageable(int pageNumber, int pageSize) {
        return pageable(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "id"));
    }

    public static Pageable pageable(int pageNumber) {
        return pageable(pageNumber, DEFAULT_PAGE_SIZE);
    }

    public static Pageable pageable() {
        return pageable(Sort.by(Sort.Direction.DESC, "id"));
    }

    public static Pageable pageable(Sort sort) {
        int pageNumber = DEFAULT_PAGE_NUMBER;
        int pageSize = DEFAULT_PAGE_SIZE;
        String pageNumberStr = ServletUtils.getRequest().getParameter("page");
        if (StringUtils.isNumeric(pageNumberStr)) {
            pageNumber = Integer.parseInt(pageNumberStr);
        }
        String pageSizeStr = ServletUtils.getRequest().getParameter("pageSize");
        if (StringUtils.isNumeric(pageSizeStr)) {
            pageSize = Integer.parseInt(pageSizeStr);
        }
        return pageable(pageNumber, pageSize, sort);

    }
}
