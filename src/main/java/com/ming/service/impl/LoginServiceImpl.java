package com.ming.service.impl;

import com.ming.Entity.UserEntity;
import com.ming.core.dto.JsonResult;
import com.ming.core.dto.UserInfoDTO;
import com.ming.core.dto.request.LoginAuthRequest;
import com.ming.core.utils.BeanUtils;
import com.ming.repository.UserEntityRepository;
import com.ming.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserEntityRepository userEntityRepository;

    @Override
    public JsonResult<UserInfoDTO> login(LoginAuthRequest request) {
        UserEntity userEntity = userEntityRepository.findOneByUsername(request.getUsername());
        if (userEntity == null) {
            return JsonResult.error(400, "用户不存在");
        }
        // 简单的md5方式  可以替换更加麻烦的方式
        if (!userEntity.getPassword().equals(DigestUtils.md5Hex(request.getPassword()))) {
            return JsonResult.error(400, "密码错误");
        }
        return JsonResult.ok(BeanUtils.copy(userEntity, UserInfoDTO.class));
    }
}
