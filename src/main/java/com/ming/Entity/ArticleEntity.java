package com.ming.Entity;

import com.ming.core.orm.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Set;

/**
 *
 *
 * @author ming
 * @date 2024-05-05 16:36:20
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

}
