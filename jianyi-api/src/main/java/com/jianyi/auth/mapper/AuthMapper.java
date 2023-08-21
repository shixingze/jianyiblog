package com.jianyi.auth.mapper;

import com.jianyi.auth.entity.SysRole;
import com.jianyi.auth.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AuthMapper {

    List<String> roleCodes(@Param("userId") Long userId);


    List<String> permissions(@Param("userId") Long userId);

    List<String> permissionsAll();

    List<Long> userMenuIds(@Param("userId") Long userId);


    SysUserEntity findUser(@Param("userId") Long userId);

    SysUserEntity findUserByName(@Param("username") String username);

    SysUserEntity findLdapUserByName(@Param("username") String username);

    SysUserEntity findUserBySub(@Param("sub") String sub);


    List<SysRole> roles(@Param("userId") Long userId);

}
