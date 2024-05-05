package com.ming.service.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ming.Entity.ArticleEntity;
import com.ming.core.orm.BaseRepository;
import com.ming.core.orm.BaseService;
import com.ming.core.utils.JsonUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleEntityService extends BaseService<ArticleEntity, Long> {
    public ArticleEntityService(BaseRepository<ArticleEntity, Long> repository) {
        super(repository);
    }

    @Override
    public ArticleEntity saveAndFlush(ArticleEntity entity) {
        //处理tag  和 category
        List<String> tags = JsonUtil.readValue(entity.getTags(), new TypeReference<List<String>>() {
        });
        List<String> categoryList = JsonUtil.readValue(entity.getCategoryList(), new TypeReference<List<String>>() {
        });

        return super.saveAndFlush(entity);
    }
}
