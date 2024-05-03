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
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * liquibase 更新监听器
 * 在spring 完全启动后 执行
 *
 * @author ming
 * @date 2024-05-03 18:38:37
 */
@Component
@Slf4j
public class LiquibaseUpdateListener {

    @Autowired
    private DataSource dataSource;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional(rollbackFor = Exception.class)
    @SuppressWarnings("deprecation")
    public synchronized void onApplicationReady(ApplicationReadyEvent event) throws SQLException, LiquibaseException, IOException {
        long now = System.currentTimeMillis();
        log.info("执行数据库变更-----开始");
        // 假设你的变更日志文件在classpath的db/changelog目录下
        ClassLoaderResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor();
        // 假设你的changelog文件名为changelog-master.xml
        String changeLogFile = "/db/changelog/db.changelog-master.xml";
        Liquibase liquibase = new Liquibase(changeLogFile, resourceAccessor, new JdbcConnection(dataSource.getConnection()));
        liquibase.update();
        // 执行Liquibase更新
//        StringWriter stringWriter = new StringWriter();
//        liquibase.update(new Contexts(), new LabelExpression(), stringWriter, false);
        // 可以在这里添加额外的逻辑，比如打印日志或执行其他初始化操作
        log.info("执行数据库变更-----结束,耗时:{}ms", System.currentTimeMillis() - now);
//        stringWriter.close();
//        liquibase.close();

    }
}
