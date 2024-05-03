package com.ming.base;


import org.springframework.data.domain.Pageable;

public interface BaseController {

    default Pageable pageable(Integer page, Integer size) {
        return Pageable.ofSize(size).withPage(page);
    }
}
