package com.ming;

import com.ming.Entity.ArticleEntity;
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

            articleEntityRepository.saveAndFlush(entity);
        }

        for (ArticleEntity entity : articleEntityRepository.findAll()) {
            System.out.println(entity);
        }
    }
}
