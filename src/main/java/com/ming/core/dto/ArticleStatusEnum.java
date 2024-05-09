package com.ming.core.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ArticleStatusEnum {
    /**
     * 文章状态
     */
    NO_RELEASE("未发布"), RELEASE("已发布");
    private String remark;
}
