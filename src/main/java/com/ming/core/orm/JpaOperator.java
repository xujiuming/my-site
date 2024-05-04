package com.ming.core.orm;


/**
 * 查询过滤器-操作类型
 *
 * @author ming
 * @date 2024-05-04 19:20:11
 */
public enum JpaOperator {
    /**
     * 精确比较
     */
    EQ,
    /**
     * 模糊查询
     */
    LIKE,
    /**
     * 模糊查询取反
     */
    NOT_LIKE,
    /**
     * 大于
     */
    GT,
    /**
     * 小于
     */
    LT,
    /**
     * 大于等于
     */
    GTE,
    /**
     * 小于等于
     */
    LTE,
    /**
     * 在这部分参数中
     */
    IN,
    /**
     * 不等于
     */
    NEQ,
    /**
     * 或
     */
    OR;
}