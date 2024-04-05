package com.ming.core.orm;


import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * 自己的entity 表名映射策略
 *
 * @author ming
 * @date 2024-04-03 09:00:59
 */
public class MyNamingStrategy extends CamelCaseToUnderscoresNamingStrategy {

    @Override
    public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        //统一加上t_ 和去除entity后缀
        String tableName = "t_" + logicalName.getText().replace("Entity", "");
        return super.toPhysicalTableName(Identifier.toIdentifier(tableName, logicalName.isQuoted()), jdbcEnvironment);
    }
}
