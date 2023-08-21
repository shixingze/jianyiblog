package com.jianyi.utils;

import com.jianyi.auth.entity.CurrentUserDto;
import com.jianyi.auth.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Set;

@Component
public class AuthUtils {


    public static SysUserEntity getUser() {
        SysUserEntity userDto = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        return userDto;
    }




}
