package com.jianyi.jianyiblog.controller;

import com.jianyi.auth.entity.SysUser;
import com.jianyi.jianyiblog.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private SysUserService userService;

    @GetMapping("/get-user")
    public SysUser getUser(@RequestParam String username){
        return userService.getUserInfo(username);
    }
    @GetMapping("/user")
    public String user(){
        return "user角色访问";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin角色访问";
    }

}
