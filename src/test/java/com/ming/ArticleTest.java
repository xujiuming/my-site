package com.ming;

import com.google.common.collect.Sets;
import com.ming.Entity.ArticleEntity;
import com.ming.Entity.CategoryEntity;
import com.ming.Entity.TagEntity;
import com.ming.repository.ArticleEntityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class ArticleTest {
    @Autowired
    private ArticleEntityRepository articleEntityRepository;


    @Test
    public void insert() {
        for (int i = 0; i < 1000; i++) {
            ArticleEntity entity = new ArticleEntity();
            entity.setTitle("ming" + i);
            entity.setLink("link" + i);
            entity.setContent("ming content" + i);
            entity.setHtmlContent("<p>ming content</p>" + i);
            entity.setCreateTime(LocalDateTime.now());
            entity.setLastUpdateTime(LocalDateTime.now());

            TagEntity tagEntity = new TagEntity();
            tagEntity.setName("tag" + i);
            entity.setTagEntitySet(Sets.newHashSet(tagEntity));
            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setName("category" + i);
            entity.setCategoryEntitySet(Sets.newHashSet(categoryEntity));
            articleEntityRepository.saveAndFlush(entity);
        }

        for (ArticleEntity entity : articleEntityRepository.findAll()) {
            System.out.println(entity);
        }
    }
}
