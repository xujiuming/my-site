package com.ming.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("t_test")
@Setter
@Getter
public class TestEntity {
    @Id
    private Long id;
    private String name;
}
