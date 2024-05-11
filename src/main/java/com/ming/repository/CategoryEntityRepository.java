package com.ming.repository;

import com.ming.Entity.CategoryEntity;
import com.ming.core.dto.CategoryIndexDTO;
import com.ming.core.orm.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryEntityRepository extends BaseRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findOneByName(String name);

    @Query("""
            select new com.ming.core.dto.CategoryIndexDTO(tc.name, count(*)) as count
            from CategoryEntity tc
                     left join ArticleEntity ta on tc.id = ta.categoryEntity.id
            group by tc.name
            """)
    List<CategoryIndexDTO> findCategoryIndexDTO();
}
