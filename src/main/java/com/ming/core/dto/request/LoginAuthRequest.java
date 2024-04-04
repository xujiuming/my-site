package com.ming.core.dto.request;

import lombok.Data;

@Data
public class LoginAuthRequest {
    private String username;
    private String password;

}
