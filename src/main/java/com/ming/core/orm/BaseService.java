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

    public Page<T> page(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<T> page(Specification<T> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }

    public List<T> findAll(Specification<T> specification) {
        return repository.findAll(specification);
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public T saveAndFlush(T entity) {
        return repository.saveAndFlush(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteById(ID id) {
        repository.deleteById(id);
        return true;
    }
}
