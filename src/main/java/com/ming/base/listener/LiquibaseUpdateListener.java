package com.ming.base.listener;


import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.StringWriter;
import java.sql.SQLException;

@Component
@Slf4j
public class LiquibaseUpdateListener {

    @Autowired
    private DataSource dataSource;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady(ApplicationReadyEvent event) throws SQLException, LiquibaseException {
        long now = System.currentTimeMillis();
        log.info("执行数据库变更-----开始");
        // 假设你的变更日志文件在classpath的db/changelog目录下
        ClassLoaderResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor();
        // 假设你的changelog文件名为changelog-master.xml
        String changeLogFile = "/db/changelog/db.changelog-master.xml";
        Liquibase liquibase = new Liquibase(changeLogFile, resourceAccessor, new JdbcConnection(dataSource.getConnection()));

        // 执行Liquibase更新
        liquibase.update("", new StringWriter());

        // 可以在这里添加额外的逻辑，比如打印日志或执行其他初始化操作
        log.info("执行数据库变更-----结束,耗时:{}ms", System.currentTimeMillis() - now);

    }
}
