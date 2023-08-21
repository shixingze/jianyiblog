package com.jianyi.auth.realm;

import com.jianyi.auth.JWTToken;
import com.jianyi.auth.TokenInfo;
import com.jianyi.auth.entity.CurrentUserDto;
import com.jianyi.auth.entity.SysRole;
import com.jianyi.auth.entity.SysUserEntity;
import com.jianyi.auth.service.AuthUserService;
import com.jianyi.jianyiblog.entity.BlogCollectionExample;
import com.jianyi.jianyiblog.entity.BlogFollowExample;
import com.jianyi.jianyiblog.mapper.BlogCollectionMapper;
import com.jianyi.jianyiblog.mapper.BlogFollowMapper;
import com.jianyi.jianyiblog.mapper.BlogStartMapper;
import com.jianyi.utils.BeanUtils;
import com.jianyi.utils.JWTUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    @Lazy //shiro组件加载过早 让authUserService等一等再注入 否则 注入的可能不是代理对象
    private AuthUserService authUserService;
    @Resource
    private BlogStartMapper blogStartMapper;
    @Resource
    private BlogFollowMapper blogFollowMapper;
    @Resource
    private BlogCollectionMapper blogCollectionMapper;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    //验证资源权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("验证资源权限");
//        Long userId = JWTUtils.tokenInfoByToken(principals.toString()).getUserId();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> role = new HashSet<>();
       // role.addAll(authUserService.roles(userId));
        simpleAuthorizationInfo.addRoles(role);
        Set<String> permission = new HashSet<>();
        permission.add("comment:list");
//        permission.addAll(authUserService.permissions(userId));
        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    //验证登录权限

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        System.out.println("验证登录");
        TokenInfo tokenInfo;
        String token;
        try {
            token = (String) auth.getCredentials();
            // 解密获得username，用于和数据库进行对比
            tokenInfo = JWTUtils.tokenInfoByToken(token);
        }catch (Exception e) {
            throw new AuthenticationException(e);
        }

        Long userId = tokenInfo.getUserId();
        String username = tokenInfo.getUsername();
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

        SysUserEntity user = userWithId(userId);
        String pass = null;
        try {
            pass = user.getPassword();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (! JWTUtils.verify(token, tokenInfo, pass)) {
            throw new AuthenticationException("Username or password error");
        }
        CurrentUserDto userDto  = queryCacheUserDto(user);
        return new SimpleAuthenticationInfo(userDto, token, "MyRealm");
    }

    public SysUserEntity userWithId(Long userId) {
        SysUserEntity user = authUserService.getUserById(userId);
        if (user == null) {
            throw new AuthenticationException("User didn't existed!");
        }
        if (user.getEnabled()==0) {
            throw new AuthenticationException("User is valid!");
        }
        return user;
    }


    public CurrentUserDto queryCacheUserDto(SysUserEntity user) {
        Long forStartNum = 0L;
        long followNum = 0L;
        long collectionNum = 0L;
        // 使用缓存
        List<SysRole> currentRoleDtos = authUserService.roleInfos(user.getUserId());
        // 使用缓存
//        List<String> permissions = authUserService.permissions(user.getUserId());
        CurrentUserDto currentUserDto = BeanUtils.copyBean(new CurrentUserDto(), user);
        currentUserDto.setRoles(currentRoleDtos);
        //获取被点赞数
        forStartNum =  blogStartMapper.selectCountStartNumByUserName(user.getUsername());
        currentUserDto.setForStartNum(forStartNum);
        //获取关注次数
        BlogFollowExample followExample = new BlogFollowExample();
        followExample.createCriteria().andSourceUidEqualTo(user.getUserId());
        followNum = blogFollowMapper.countByExample(followExample);
        currentUserDto.setFollowNum(followNum);
        //获取收藏数
        BlogCollectionExample collectionExample = new BlogCollectionExample();
        collectionExample.createCriteria().andUserIdEqualTo(user.getUserId().intValue());
        collectionNum =  blogCollectionMapper.countByExample(collectionExample);
        currentUserDto.setCollectionNum(collectionNum);
//        currentUserDto.setPermissions(permissions);
        return currentUserDto;
    }

}
