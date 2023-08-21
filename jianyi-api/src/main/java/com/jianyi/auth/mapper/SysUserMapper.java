package com.jianyi.auth.mapper;

import com.jianyi.auth.entity.SysUser;
import com.jianyi.auth.entity.SysUserExample;
import java.util.List;

import com.jianyi.entity.dto.LoginDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(SysUser record);

    SysUser selectUserLoginDto(LoginDto user);
    SysUser selectUserEmailOrName(LoginDto user);
    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 根据用户id查询用户信息
     */
    public SysUser selectUserByUserId(Long userId);

    List<SysUser> selectUserByDeptId(Long deptId);


    SysUser getUserInfoByUsername(String userName);

    List<SysUser> selectUsersByHot();
}