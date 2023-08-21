package com.jianyi.auth.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class SysUser  implements Serializable{
    @ApiModelProperty("ID")
    private Long userId;

    private Long deptId;
    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("姓名")
    private String nickName;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty(hidden = true)
    private String password;

    @ApiModelProperty("是否管理员")
    private Boolean isAdmin;

    @ApiModelProperty("状态")
    private Long enabled;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("修改人")
    private String updateBy;

    @ApiModelProperty("密码重置时间")
    private Long pwdResetTime;

    @ApiModelProperty("创建时间")
    private Long createTime;

    @ApiModelProperty("修改时间")
    private Long updateTime;
    @ApiModelProperty("头像地址")
     private String avatar;


    @ApiModelProperty("从事岗位")
    private  String occupation;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long blogNum;


    private static final long serialVersionUID = 1L;

    public SysUser() {
    }

    public SysUser(String username, String email, String password, Boolean isAdmin) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}