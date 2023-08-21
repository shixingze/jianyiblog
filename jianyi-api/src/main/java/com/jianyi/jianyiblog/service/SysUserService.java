package com.jianyi.jianyiblog.service;


import com.jianyi.auth.entity.SysUser;
import com.jianyi.auth.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    private SysUserMapper userInfoMapper;

    public SysUser getUserInfo(String username){
        return userInfoMapper.getUserInfoByUsername(username);
    }

}
