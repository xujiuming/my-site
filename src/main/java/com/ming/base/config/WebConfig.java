package com.ming.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

/**
 * web相关配置 配置
 *
 * @author ming
 * @date 2024-05-06 10:09:45
 */
@Configuration
public class WebConfig {

    /***
     * 配置ETag 缓存
     * */
    @Bean
    public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
        ShallowEtagHeaderFilter filter = new ShallowEtagHeaderFilter();
        //使用强 ETga  强ETag 就是微弱变化也会导致ETag失效   弱ETag 如果出现一些非关键部分(时间戳、版本号)发生变化 ETag不变化
        filter.setWriteWeakETag(false);
        return filter;
    }


}
