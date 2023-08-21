package com.jianyi.auth.controller;

import com.jianyi.entity.dto.LoginDto;
import com.jianyi.utils.AjaxResult;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/auth")
public interface AuthApi {
    /**
     * 登录接口
     * @param user 参数
     * @return
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody  LoginDto user) throws Exception;


    /**
     * 注册
     * @param user 参数
     * @return
     */
    @PostMapping("/register")
    public AjaxResult register(@RequestBody  LoginDto user) throws Exception;

    @PostMapping("/getCode")
    public AjaxResult getCode(@RequestBody  LoginDto user) throws Exception;

    @GetMapping("/userInfo")
    public AjaxResult getUserInfo();
}
