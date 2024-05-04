package com.ming.Entity;

import com.ming.core.orm.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
public class ArticleEntity extends BaseEntity {
    private String title;
    private String link;
    @Column(length = Integer.MAX_VALUE)
    private String content;
    @Column(length = Integer.MAX_VALUE)
    private String htmlContent;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "article_tag",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<TagEntity> tagEntitySet;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "article_category",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<CategoryEntity> categoryEntitySet;

}
