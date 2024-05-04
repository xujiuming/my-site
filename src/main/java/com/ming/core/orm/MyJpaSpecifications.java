
package com.ming.core.orm;


import java.lang.annotation.*;

/**
 * 标注为 jpa查询的条件字段
 *
 * @author ming
 * @date 2020-04-21 13:18:14
 */
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface MyJpaSpecifications {

    /**
     * 操作
     * {@linkplain JpaOperator}
     *
     * @author ming
     * @date 2020-04-21 13:36:32
     */
    JpaOperator operator() default JpaOperator.EQ;

    /**
     * 实体字段
     */
    String entityField() default "";
}
