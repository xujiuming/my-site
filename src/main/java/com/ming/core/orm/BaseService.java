package com.ming.core.orm;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<T extends BaseEntity, ID> {
    protected final BaseRepository<T, ID> repository;

    public BaseService(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }


    public Page<T> page(Specification<T> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(rollbackFor = Exception.class)
    public T save(T entity) {
        return repository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
