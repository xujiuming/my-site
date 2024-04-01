package com.ming.repository;

import com.ming.Entity.TestEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntityRepository extends ReactiveCrudRepository<TestEntity, Long> {
}
