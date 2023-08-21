package com.jianyi.entity.dto;

import lombok.Data;

@Data
public class LoginDto {
    /**
     * 用户名
     */
   private String username;
    /**
     * 密码
     */
   private String password;
    /**
     * 验证码
     */
   private String authCode;

   private String email;
}
