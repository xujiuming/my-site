package com.ming.service.entity;

import com.ming.Entity.ArticleEntity;
import com.ming.core.orm.BaseRepository;
import com.ming.core.orm.BaseService;
import com.ming.repository.ArticleEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ArticleEntityService extends BaseService<ArticleEntity, Long> {
    public ArticleEntityService(BaseRepository<ArticleEntity, Long> repository) {
        super(repository);
    }

}
