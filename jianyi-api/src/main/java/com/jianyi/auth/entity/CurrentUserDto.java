package com.jianyi.auth.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class CurrentUserDto extends SysUserEntity implements Serializable {

    @ApiModelProperty("角色集合")
    private List<SysRole> roles;

    @ApiModelProperty("权限集合")
    private List<String> permissions;

    //被点赞次数
    private  Long forStartNum;
    //关注数
    private long followNum;
    //收藏数
    private long collectionNum;
    @ApiModelProperty
    private List<String> UserMenus;
}
