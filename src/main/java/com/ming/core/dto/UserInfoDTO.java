package com.ming.core.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserInfoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String avatar;
    private String quote;
}
