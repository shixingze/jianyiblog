package com.jianyi.auth.entity;

import lombok.Data;

import java.util.Date;
@Data
public class SysRole {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色状态
     */
    private String status;
    /**
     * 逻辑删除
     */
    private String delFlag;

    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateBy;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 备注
     */
    private String remark;


}