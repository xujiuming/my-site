package com.ming.Entity;

import com.ming.core.orm.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ming
 * @date 2024-05-05 16:36:20
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class UploadInfoEntity extends BaseEntity {
    private String name;
    private String originalName;
    private String url;
    private String checkCode;
    private Long size;
    private String fileType;
    private String uploadType;


}
