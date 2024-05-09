package com.ming.service.entity;

import com.google.common.collect.Sets;
import com.ming.Entity.ArticleEntity;
import com.ming.Entity.CategoryEntity;
import com.ming.Entity.TagEntity;
import com.ming.core.orm.BaseRepository;
import com.ming.core.orm.BaseService;
import com.ming.repository.ArticleEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ArticleEntityService extends BaseService<ArticleEntity, Long> {
    @Autowired
    private ArticleEntityRepository articleEntityRepository;

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
        CategoryEntity categoryEntity = entity.getCategoryEntity();
        Optional<CategoryEntity> nameCategoryEntityOptional = categoryEntityService.findOneByName(categoryEntity.getName());
        if (nameCategoryEntityOptional.isPresent()) {
            entity.setCategoryEntity(nameCategoryEntityOptional.get());
        } else {
            categoryEntityService.saveAndFlush(categoryEntity);
            entity.setCategoryEntity(categoryEntity);
        }
    }

    private void handlerTag(ArticleEntity entity) {
        Set<TagEntity> tagEntitySet = Sets.newHashSet();
        for (TagEntity tag : entity.getTagEntitySet()) {
            Optional<TagEntity> tagEntityOptional = tagEntityService.findOneByName(tag.getName());
            if (tagEntityOptional.isPresent()) {
                tagEntitySet.add(tagEntityOptional.get());
            } else {
                tagEntitySet.add(tagEntityService.saveAndFlush(tag));
            }
        }
        entity.setTagEntitySet(tagEntitySet);
    }

    public Optional<ArticleEntity> findOneByHtmlCheckCode(String htmlCheckCode) {
        return articleEntityRepository.findOneByHtmlCheckCode(htmlCheckCode);
    }
}
