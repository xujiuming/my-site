package com.ming.service.entity.impl;

import com.ming.Entity.ArticleEntity;
import com.ming.repository.ArticleEntityRepository;
import com.ming.service.entity.ArticleEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleEntityServiceImpl implements ArticleEntityService {

    private final ArticleEntityRepository articleEntityRepository;

    @Override
    public Page<ArticleEntity> page(Pageable pageable) {
        return articleEntityRepository.findAll(pageable);
    }

}
