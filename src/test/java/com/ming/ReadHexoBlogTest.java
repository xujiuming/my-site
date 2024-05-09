package com.ming;

import com.ming.Entity.ArticleEntity;
import com.ming.Entity.CategoryEntity;
import com.ming.Entity.TagEntity;
import com.ming.core.utils.SignatureUtils;
import com.ming.service.MarkdownParseService;
import com.ming.service.entity.ArticleEntityService;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class ReadHexoBlogTest {
    @Autowired
    private MarkdownParseService markdownParseService;

    @Autowired
    private ArticleEntityService articleEntityService;

    /**
     * 递归列出目录下所有文件（包括子目录）
     *
     * @param dir 当前处理的目录
     * @return 所有文件的列表
     */
    public static List<File> listFilesRecursively(File dir) {
        List<File> files = new ArrayList<>();

        // 获取当前目录下的所有文件和子目录
        File[] entries = dir.listFiles();
        if (entries != null) {
            for (File entry : entries) {
                // 如果是文件，直接添加到列表
                if (entry.isFile()) {
                    files.add(entry);
                } else if (entry.isDirectory()) {
                    // 如果是目录，递归处理
                    files.addAll(listFilesRecursively(entry));
                }
            }
        }
        return files;
    }

    @Test
    public void read() throws IOException {
        String rootPath = "/home/ming/IdeaProjects/blog/source/_posts";

        // 获取目录对象
        File directory = new File(rootPath);

        // 递归列出所有文件
        List<File> allFiles = listFilesRecursively(directory);

        allFiles.stream()
                .filter(f -> f.getName().endsWith(".md"))
                .forEach(this::writeToDb);

    }

    @SneakyThrows
    private void writeToDb(File file) {
        //读取文件
        String allContentString = Files.readString(file.toPath());
        String[] splitStringArr = allContentString.split("---");
        //0 是空数据
        String headtString = splitStringArr[1];
        String bodyString = splitStringArr[2];
        String bodyHtmlString = markdownParseService.parseHtml(bodyString);
//        System.out.println(headtString);
//        System.out.println("-------------");
//        System.out.println(bodyString);
//        System.out.println("-------------");
//        System.out.println(bodyHtmlString);

        log.info("解析:{}",headtString);
        Yaml yaml = new Yaml();
        Head head = yaml.loadAs(headtString, Head.class);
        //根据htmlMd5判断是否解析过
        if (articleEntityService.findOneByHtmlCheckCode(SignatureUtils.md5ToHex(bodyHtmlString)).isPresent()) {
            log.info("{}已经解析过", head.getTitle());
            return;
        }


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
        LocalDateTime now = LocalDateTime.parse(head.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        entity.setCreateTime(now);
        entity.setLastUpdateTime(now);
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
