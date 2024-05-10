package com.ming.base;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

/**
 * p6spy log 格式
 *
 * @author ming
 * @date 2024-05-10 11:42:51
 */
public class P6spyMessageFormattingStrategy implements MessageFormattingStrategy {
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return "p6:connectionId-%s,time:%sms,%s".formatted(connectionId, elapsed, sql);
    }
}
