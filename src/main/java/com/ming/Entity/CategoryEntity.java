package com.ming.Entity;

import com.ming.core.orm.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * 分类
 *
 * @author ming
 * @date 2024-05-05 16:36:56
 */
@Entity
@Setter
@Getter
public class CategoryEntity extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ArticleEntity> articleEntitySet;


}
