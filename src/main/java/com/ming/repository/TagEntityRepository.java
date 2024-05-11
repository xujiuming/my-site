package com.ming.repository;

import com.ming.Entity.TagEntity;
import com.ming.core.dto.TagIndexDTO;
import com.ming.core.orm.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface TagEntityRepository extends BaseRepository<TagEntity, Long> {
    Optional<TagEntity> findOneByName(String name);

    @Query("select new com.ming.core.dto.TagIndexDTO(e.name) from TagEntity e ")
    Set<TagIndexDTO> findTagIndexDTO();
}
