package com.ming.service;

import com.ming.core.dto.JsonResult;
import com.ming.core.dto.UserInfoDTO;
import com.ming.core.dto.request.LoginAuthRequest;
import jakarta.servlet.http.HttpServletRequest;

public interface LoginService {

    JsonResult<UserInfoDTO> login(HttpServletRequest httpServletRequest, LoginAuthRequest request);
}
