package com.jianyi.auth.service.Impl;

import com.jianyi.auth.entity.SysRole;
import com.jianyi.auth.entity.SysUserEntity;
import com.jianyi.auth.mapper.AuthMapper;
import com.jianyi.auth.service.AuthUserService;
import com.jianyi.entity.dto.LoginDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Resource
    private AuthMapper authMapper;

    @Override
    public SysUserEntity getUserByName(String username){
        return  authMapper.findUserByName(username);
    }


    @Override
    public SysUserEntity getUserById(Long userId){
        return  authMapper.findUser(userId);
    }

    @Override
    public List<SysRole> roleInfos(Long userId) {
      return authMapper.roles(userId);
    }


}
