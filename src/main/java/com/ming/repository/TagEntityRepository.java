package com.ming.repository;

import com.ming.Entity.TagEntity;
import com.ming.core.orm.BaseRepository;

import java.util.Optional;

public interface TagEntityRepository extends BaseRepository<TagEntity, Long> {
    Optional<TagEntity> findOneByName(String name);
}
