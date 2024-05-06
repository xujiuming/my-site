package com.ming.repository;

import com.ming.Entity.CategoryEntity;
import com.ming.core.orm.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryEntityRepository extends BaseRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findOneByName(String name);
}