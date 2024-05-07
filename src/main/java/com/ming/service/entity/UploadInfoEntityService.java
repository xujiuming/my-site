package com.ming.service.entity;

import com.ming.Entity.UploadInfoEntity;
import com.ming.core.orm.BaseRepository;
import com.ming.core.orm.BaseService;
import org.springframework.stereotype.Service;

@Service
public class UploadInfoEntityService extends BaseService<UploadInfoEntity, Long> {

    public UploadInfoEntityService(BaseRepository<UploadInfoEntity, Long> repository) {
        super(repository);
    }


}
