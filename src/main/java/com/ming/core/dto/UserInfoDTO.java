package com.ming.core.dto;

import lombok.Data;

@Data
public class UserInfoDTO {
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String avatar;
    private String quote;
}
