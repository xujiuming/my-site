package com.ming.core.orm;


import com.ming.core.utils.CollectionUtils;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 构建查询对Specification进行封装 用searchfilter enum进行封装
 *
 * @author ming
 * @date 2020-04-21 09:25:33
 */
@Slf4j
public class SpecificationUtils {

    /**
     * 根据class 获取字段 和字段的注解 和值  构建 条件
     *
     * @author ming
     * @date 2020-04-21 13:26:13
     */
    @SuppressWarnings("unchecked")
    public static <T, Q> Specification<T> build(Q val) {
        if (Objects.isNull(val)) {
            throw new RuntimeException("构建查询条件对象不能为null");
        }
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            Class<?> clazz = val.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(Boolean.TRUE);
                //获取注解
                MyJpaSpecifications myJpaSpecifications = field.getAnnotation(MyJpaSpecifications.class);
                if (Objects.isNull(myJpaSpecifications)) {
                    //如果没有注解 忽略此字段 不进行构建处理
                    continue;
                }
                //如果没有输入实体字段 默认为当前属性字段的名称
                String nameStr = myJpaSpecifications.entityField();
                if (StringUtils.isEmpty(nameStr)) {
                    nameStr = field.getName();
                }
                String[] names = StringUtils.split(nameStr, ".");
                Path expression = root.get(names[0]);
                for (int i = 1; i < names.length; i++) {
                    expression = expression.get(names[i]);
                }
                //in 和or 中需要的一个中间变量 用来将filter.value放入数组
                Object[] objects = new Object[1];
                switch (myJpaSpecifications.operator()) {
                    case EQ:
                        predicates.add(builder.equal(expression, ReflectionUtils.getField(field, val)));
                        break;
                    case LIKE:
                        predicates.add(builder.like(expression, "%" + ReflectionUtils.getField(field, val) + "%"));
                        break;
                    case NOT_LIKE:
                        predicates.add(builder.notLike(expression, "%" + ReflectionUtils.getField(field, val) + "%"));
                        break;
                    case GT:
                        predicates.add(builder.greaterThan(expression, (Comparable) ReflectionUtils.getField(field, val)));
                        break;
                    case LT:
                        predicates.add(builder.lessThan(expression, (Comparable) ReflectionUtils.getField(field, val)));
                        break;
                    case GTE:
                        predicates.add(builder.greaterThanOrEqualTo(expression, (Comparable) ReflectionUtils.getField(field, val)));
                        break;
                    case LTE:
                        predicates.add(builder.lessThanOrEqualTo(expression, (Comparable) ReflectionUtils.getField(field, val)));
                        break;
                    case IN:
                        //因为spring data jpa 本身没有对数组进行判断 传入数组的话会失败 所以在此进行是否是数组的判断
                        //因为expression。in参数是不定参数  理论上是可以传入数组 但是直接传入object不能判断是否为数组
                        //把他当成一个参数 而不是需要的数组参数
                        Object filterValue = ReflectionUtils.getField(field, val);
                        if (filterValue.getClass().isArray()) {
                            objects = (Object[]) filterValue;
                        } else {
                            objects[0] = filterValue;
                        }
                        predicates.add(expression.in(objects));
                        break;
                    case NEQ:
                        predicates.add(builder.notEqual(expression, ReflectionUtils.getField(field, val)));
                        break;
                    case OR:
                        List<Predicate> preList = new ArrayList<>();
                        Object obj = ReflectionUtils.getField(field, val);
                        if (obj.getClass().isArray()) {
                            objects = (Object[]) obj;
                            for (Object object : objects) {
                                Predicate pp = builder.like(expression, "%" + object + "%");
                                preList.add(pp);
                            }
                        } else {
                            preList.add(builder.like(expression, "%" + obj + "%"));
                        }
                        Predicate[] pres = preList.toArray(new Predicate[0]);
                        predicates.add(builder.or(pres));
                        break;
                    default:
                        throw new RuntimeException("没有" + myJpaSpecifications.operator().name() + "操作");
                }
            }

            if (CollectionUtils.notEmpty(predicates)) {
                return builder.and(predicates.toArray(new Predicate[0]));
            }
            return builder.conjunction();
        };
    }
}
