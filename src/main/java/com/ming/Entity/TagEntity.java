package com.ming.Entity;

import com.ming.core.orm.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * 标签
 *
 * @author ming
 * @date 2024-05-05 16:36:48
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class TagEntity extends BaseEntity {
    private String name;

    @ManyToMany(mappedBy = "tagEntitySet")
    private Set<ArticleEntity> articleEntitySet;


}
