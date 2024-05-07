package com.ming;

import com.ming.Entity.ArticleEntity;
import com.ming.Entity.CategoryEntity;
import com.ming.Entity.TagEntity;
import com.ming.core.utils.SignatureUtils;
import com.ming.service.MarkdownParseService;
import com.ming.service.entity.ArticleEntityService;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class ReadHexoBlogTest {
    @Autowired
    private MarkdownParseService markdownParseService;

    @Autowired
    private ArticleEntityService articleEntityService;

    @Test
    public void read() throws IOException {
        //String rootPath = "/home/ming/IdeaProjects/blog/source/_posts";
        String filePath = "/home/ming/IdeaProjects/blog/source/_posts/java/disruptor使用笔记.md";


        writeToDb(filePath);

    }

    private void writeToDb(String filePath) throws IOException {
        //读取文件
        String allContentString = Files.readString(Path.of(filePath));
        String[] splitStringArr = allContentString.split("---");
        //0 是空数据
        String headtString = splitStringArr[1];
        String bodyString = splitStringArr[2];
        String bodyHtmlString = markdownParseService.parseHtml(bodyString);
        System.out.println(headtString);
        System.out.println("-------------");
        System.out.println(bodyString);
        System.out.println("-------------");
        System.out.println(bodyHtmlString);


        Yaml yaml = new Yaml();
        Head head = yaml.loadAs(headtString, Head.class);

        ArticleEntity entity = new ArticleEntity();
        entity.setTitle(head.getTitle());
        entity.setLink(head.getAbbrlink());
        entity.setContent(bodyString);
        entity.setHtmlContent(bodyHtmlString);
        entity.setHtmlCheckCode(SignatureUtils.md5ToHex(bodyHtmlString));
        entity.setTagEntitySet(head.getTags().stream()
                .map(m -> {
                    TagEntity tag = new TagEntity();
                    tag.setName(m);
                    return tag;
                }).collect(Collectors.toSet()));

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(head.getCategories());
        entity.setCategoryEntity(categoryEntity);
        articleEntityService.saveAndFlush(entity);
    }

    @Data
    public static class Head {
        private String title;
        private Boolean comments;
        private String categories;
        private List<String> tags;
        private String abbrlink;
        private String date;
    }

}
