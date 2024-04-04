package com.ming.service;

import com.ming.core.dto.JsonResult;
import com.ming.core.dto.UserInfoDTO;
import com.ming.core.dto.request.LoginAuthRequest;

public interface LoginService {
    JsonResult<UserInfoDTO> login(LoginAuthRequest request);
}
