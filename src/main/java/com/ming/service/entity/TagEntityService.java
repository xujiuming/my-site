package com.ming.service.entity;

import com.ming.Entity.TagEntity;
import com.ming.core.orm.BaseRepository;
import com.ming.core.orm.BaseService;
import com.ming.repository.TagEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagEntityService extends BaseService<TagEntity, Long> {
    public TagEntityService(BaseRepository<TagEntity, Long> repository) {
        super(repository);
    }

    @Autowired
    private TagEntityRepository tagEntityRepository;

    public Optional<TagEntity> findOneByName(String name) {
        return tagEntityRepository.findOneByName(name);
    }
}
