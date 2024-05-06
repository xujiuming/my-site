package com.ming.core.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JsonResult<T> {
    private int code;
    private T data;
    private String msg;

    public static <T> JsonResult<T> ok(T data) {
        return JsonResult.<T>builder().code(0).data(data).build();
    }

    public static JsonResult<Void> ok() {
        return JsonResult.<Void>builder()
                .code(0)
                .build();
    }

    public static <T> JsonResult<T> error(int code, String msg) {
        return JsonResult.<T>builder().code(code).msg(msg).build();
    }

}
