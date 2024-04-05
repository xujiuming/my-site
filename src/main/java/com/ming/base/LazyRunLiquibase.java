package com.ming.base;

import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LazyRunLiquibase implements ApplicationRunner {
    private final SpringLiquibase springLiquibase;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                springLiquibase.afterPropertiesSet();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
