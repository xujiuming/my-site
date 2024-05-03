package com.ming.service.entity;

import com.ming.Entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleEntityService {
    public Page<ArticleEntity> page(Pageable pageable);


}
