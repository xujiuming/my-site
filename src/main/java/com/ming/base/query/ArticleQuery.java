package com.ming.base.query;

import com.ming.core.orm.JpaOperator;
import com.ming.core.orm.MyJpaSpecifications;
import lombok.Data;

@Data
public class ArticleQuery {


    @MyJpaSpecifications(operator = JpaOperator.EQ)
    private String title;
}
