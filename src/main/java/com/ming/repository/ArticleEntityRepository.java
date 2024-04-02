package com.ming.repository;

import com.ming.Entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleEntityRepository extends JpaRepository<ArticleEntity, Long> {
}
