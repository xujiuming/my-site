package com.ming.service.impl;

import com.ming.repository.TestEntityRepository;
import com.ming.service.TestEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestEntityServiceImpl implements TestEntityService {

    private final TestEntityRepository testEntityRepository;


}
