package com.jianyi.auth.service;

import com.jianyi.auth.entity.SysRole;
import com.jianyi.auth.entity.SysUserEntity;
import com.jianyi.entity.dto.LoginDto;

import java.util.List;


public interface AuthUserService {


    public SysUserEntity getUserByName(String username);


    public SysUserEntity getUserById(Long userId);

    public List<SysRole> roleInfos(Long userId);

}
