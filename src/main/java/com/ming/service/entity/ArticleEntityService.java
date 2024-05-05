package com.ming.service.entity;

import com.google.common.collect.Sets;
import com.ming.Entity.ArticleEntity;
import com.ming.Entity.TagEntity;
import com.ming.core.orm.BaseRepository;
import com.ming.core.orm.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ArticleEntityService extends BaseService<ArticleEntity, Long> {
    public ArticleEntityService(BaseRepository<ArticleEntity, Long> repository) {
        super(repository);
    }

    @Autowired
    private TagEntityService tagEntityService;
    @Autowired
    private CategoryEntityService categoryEntityService;

    @Override
    public ArticleEntity saveAndFlush(ArticleEntity entity) {
        handlerTag(entity);
        HandlerCategory(entity);
        return super.saveAndFlush(entity);
    }

    private void HandlerCategory(ArticleEntity entity) {
        if (entity.getCategoryEntity().getId() == null) {
            entity.setCategoryEntity(categoryEntityService.saveAndFlush(entity.getCategoryEntity()));
        }
    }

    private void handlerTag(ArticleEntity entity) {
        Set<TagEntity> tagEntitySet = Sets.newHashSet();
        for (TagEntity tag : entity.getTagEntitySet()) {
            if (tag.getId() != null) {
                tagEntitySet.add(tag);
            } else {
                tagEntitySet.add(tagEntityService.saveAndFlush(tag));
            }
        }
        entity.setTagEntitySet(tagEntitySet);
    }
}
