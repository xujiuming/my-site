package com.ming.Entity;

import com.ming.core.orm.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    @Column(length = Integer.MAX_VALUE)
    private String tags;
    @Column(length = Integer.MAX_VALUE)
    private String categoryList;

}
