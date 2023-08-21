package com.jianyi.auth.entity;

import lombok.Data;

@Data
public class SysUserResponse extends SysUser {

    private Long blogAllnum;
    private Long lookAllnum;
    private Long startAllnum;

    public SysUserResponse() {
    }
}
