package com.jianyi.auth.service;

import com.jianyi.auth.entity.SysUser;
import com.jianyi.auth.entity.SysUserResponse;

import java.util.List;

public interface SysUserService {
    /**
     * 博客详情页用户基本信息
     * @return
     */
    public SysUserResponse selectBasicUser(SysUser user);


    /**
     *
     * 获取贡献热度的用户榜单
     */
    public List<SysUser> selectUsersByHot();
}
