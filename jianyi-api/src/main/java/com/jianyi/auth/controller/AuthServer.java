package com.jianyi.auth.controller;

import com.jianyi.auth.TokenInfo;
import com.jianyi.auth.entity.*;
import com.jianyi.auth.mapper.SysUserMapper;
import com.jianyi.auth.service.AuthUserService;
import com.jianyi.entity.dto.LoginDto;
import com.jianyi.exection.JianYiExcetion;
import com.jianyi.jianyiblog.entity.BlogCollectionExample;
import com.jianyi.jianyiblog.entity.BlogFollowExample;
import com.jianyi.jianyiblog.mapper.BlogCollectionMapper;
import com.jianyi.jianyiblog.mapper.BlogFollowMapper;
import com.jianyi.jianyiblog.mapper.BlogStartMapper;
import com.jianyi.utils.AjaxResult;
import com.jianyi.utils.BeanUtils;
import com.jianyi.utils.JWTUtils;
import com.jianyi.utils.ServletUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
public class AuthServer implements AuthApi {

    @Resource
    private SysUserMapper userMapper;
    @Resource
    private AuthUserService authUserService;

    @Resource
    private BlogStartMapper blogStartMapper;

    @Resource
    private BlogFollowMapper blogFollowMapper;

    @Resource
    private BlogCollectionMapper blogCollectionMapper;

    @Autowired
    private  RestTemplate restTemplate;
    public static final String RABBITMQ = "http://JIANYI-RABBITMQ";


    @Override
    public AjaxResult login(LoginDto userDto) throws Exception {
        String username = userDto.getUsername();
        String password = userDto.getPassword();
        SysUserEntity user = authUserService.getUserByName(username);
        if (ObjectUtils.isEmpty(user)) {
            JianYiExcetion.throwException("用户不存在");
        }

        String realPwd = user.getPassword();

            if (!StringUtils.equals(password, realPwd)) {
             return    AjaxResult.erro("密码错误请重新输入");
            }


        Map<String, Object> result = new HashMap<>();
        TokenInfo tokenInfo = TokenInfo.builder().userId(user.getUserId()).username(username).build();
        String token = JWTUtils.sign(tokenInfo, realPwd);
        // 记录token操作时间
        result.put("token", token);
        ServletUtils.setToken(token);
        return AjaxResult.success(result);
    }

    /**
     * 注册
     * @param user 参数
     * @return
     * @throws Exception
     */
    @Override
    public AjaxResult register(LoginDto user) throws Exception {
        HttpSession session = ServletUtils.getSession();
        Object code =   session.getAttribute(user.getEmail());
        if (ObjectUtils.isEmpty(code)){
            return AjaxResult.erro("请获取验证码");
        }
        SysUser u =  userMapper.selectUserLoginDto(user);
        if (ObjectUtils.isNotEmpty(u)){
            return AjaxResult.erro("该用户名或邮箱已被使用");
        }
        if (user.getAuthCode().equals(code)){
            SysUser userDto = new SysUser(user.getUsername(), user.getEmail(), user.getPassword(),false);
            userDto.setDeptId(1L);
            userMapper.insertSelective(userDto);
            return AjaxResult.success("注册成功");
        }
        return AjaxResult.erro("验证码错误或失效");
    }

    /**
     * 获取验证码
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public AjaxResult getCode(LoginDto user) throws Exception {
       HttpSession session =  ServletUtils.getSession();
        String email =  user.getEmail();
        Random random = new Random();
        int num = random.nextInt(9000) + 1000;
        session.setAttribute(email,String.valueOf(num));
        //发送到队列中
        String url = "/send/email/register?email="+email+"&code="+num;
        String  json = "";
        try {
              json  = restTemplate.getForObject(RABBITMQ + url,String.class);
        }catch (Exception e){
            return AjaxResult.erro(json);
        }
        return AjaxResult.success("发送成功");
    }

    /**
     * 获取用户信息
     * @return
     */
    @Override
    public AjaxResult getUserInfo() {
        CurrentUserDto userDto = (CurrentUserDto) SecurityUtils.getSubject().getPrincipal();
        Long forStartNum = 0L;
        long followNum = 0L;
        long collectionNum = 0L;
        if (ObjectUtils.isEmpty(userDto)) {
            String token = ServletUtils.getToken();
            Long userId = JWTUtils.tokenInfoByToken(token).getUserId();
            SysUserEntity user = authUserService.getUserById(userId);
            CurrentUserDto currentUserDto  =BeanUtils.copyBean(new CurrentUserDto(), user);
            List<SysRole> currentRoleDtos = authUserService.roleInfos(user.getUserId());
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
           currentUserDto.setRoles(currentRoleDtos);
            return  AjaxResult.success(currentUserDto);
        }
        return  AjaxResult.success(userDto);
    }
}
