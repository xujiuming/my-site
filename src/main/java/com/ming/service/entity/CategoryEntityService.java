package com.ming.service.entity;

import com.ming.Entity.CategoryEntity;
import com.ming.core.orm.BaseRepository;
import com.ming.core.orm.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CategoryEntityService extends BaseService<CategoryEntity,Long> {
    public CategoryEntityService(BaseRepository<CategoryEntity, Long> repository) {
        super(repository);
    }
}
