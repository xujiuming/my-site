package com.ming.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "t_tag")
@Setter
@Getter
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "tagEntitySet")
    private Set<ArticleEntity> articleEntitySet;


}
