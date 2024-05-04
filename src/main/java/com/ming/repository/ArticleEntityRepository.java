package com.ming.repository;

import com.ming.Entity.ArticleEntity;
import com.ming.core.orm.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleEntityRepository extends BaseRepository<ArticleEntity, Long> {
}
