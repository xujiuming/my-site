package com.ming.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_article")
@Setter
@Getter
public class ArticleEntity {
    @Id
    private Long id;
    private String name;
}
