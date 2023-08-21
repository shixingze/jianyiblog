package com.jianyi.auth.controller;

import com.jianyi.auth.entity.SysUser;
import com.jianyi.auth.service.SysUserService;
import com.jianyi.utils.AjaxResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class SysUserController {

    @Resource
    private SysUserService userService;

    @PostMapping("/getUser")
    public AjaxResult getUser(@RequestBody SysUser user){
       return AjaxResult.success(userService.selectBasicUser(user));
    }

    /**
     * 获取贡献文章作者榜单
     * @param
     * @return
     */
    @GetMapping("/gethotusers")
    public AjaxResult gethotusers(){
        return AjaxResult.success(userService.selectUsersByHot());
    }


}
