package com.ming.service.entity;

import com.ming.Entity.TagEntity;
import com.ming.core.orm.BaseRepository;
import com.ming.core.orm.BaseService;
import org.springframework.stereotype.Service;

@Service
public class TagEntityService extends BaseService<TagEntity,Long> {
    public TagEntityService(BaseRepository<TagEntity, Long> repository) {
        super(repository);
    }
}
