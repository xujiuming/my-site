package com.ming.service.impl;

import com.ming.repository.ArticleEntityRepository;
import com.ming.service.ArticleEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleEntityServiceImpl implements ArticleEntityService {

    private final ArticleEntityRepository articleEntityRepository;


}
