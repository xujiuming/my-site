package com.ming.core.orm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
public abstract class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name = "create_time", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected LocalDateTime createTime;

    @Column(name = "last_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    protected LocalDateTime lastUpdateTime;

    @PrePersist
    protected void onCreate() {
        if (createTime == null) {
            createTime = LocalDateTime.now();
        }
        lastUpdateTime = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdateTime = LocalDateTime.now();
    }

}

