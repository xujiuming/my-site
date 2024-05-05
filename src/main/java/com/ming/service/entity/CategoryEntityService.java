package com.ming.service.entity;

import com.ming.Entity.CategoryEntity;
import com.ming.core.orm.BaseRepository;
import com.ming.core.orm.BaseService;
import com.ming.repository.CategoryEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryEntityService extends BaseService<CategoryEntity, Long> {
    public CategoryEntityService(BaseRepository<CategoryEntity, Long> repository) {
        super(repository);
    }

    @Autowired
    private CategoryEntityRepository categoryEntityRepository;

    public Optional<CategoryEntity> findOneByName(String name) {
        return categoryEntityRepository.findOneByName(name);
    }
}
