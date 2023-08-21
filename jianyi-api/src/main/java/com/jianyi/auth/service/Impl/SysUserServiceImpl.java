package com.jianyi.auth.service.Impl;

import com.jianyi.auth.entity.SysUser;
import com.jianyi.auth.entity.SysUserResponse;
import com.jianyi.auth.mapper.SysUserMapper;
import com.jianyi.auth.service.SysUserService;
import com.jianyi.jianyiblog.entity.Blog;
import com.jianyi.jianyiblog.entity.BlogExample;
import com.jianyi.jianyiblog.entity.BlogStartExample;
import com.jianyi.jianyiblog.mapper.BlogMapper;
import com.jianyi.jianyiblog.mapper.BlogStartMapper;
import com.jianyi.utils.BeanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private BlogMapper blogMapper;
    @Resource
    private BlogStartMapper blogStartMapper;
    //基本
    @Override
    public SysUserResponse selectBasicUser(SysUser user) {
        SysUser userDto = sysUserMapper.getUserInfoByUsername(user.getUsername());
        SysUserResponse userResponse = BeanUtils.copyBean(new SysUserResponse(),userDto);
        //博文数量
        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria blogC = blogExample.createCriteria();
        blogC.andCreatedByEqualTo(userDto.getUsername());
        List<Blog> blogList = blogMapper.selectByExample(blogExample);
        //被点赞数量
        if (ObjectUtils.isNotEmpty(blogList)){
            //设置博客数量
            userResponse.setBlogAllnum(Long.valueOf(blogList.size()));
            //获取id集合
            long startNum = blogStartMapper.selectAllByblogCreateName(userDto.getUsername()).size();
            userResponse.setStartAllnum(startNum);
            //总浏览量
            Long lookNum = 0L;
            for (Blog blog : blogList){
                lookNum += blog.getBlogBrowsing();
            }
            userResponse.setLookAllnum(lookNum);
        }
        //总浏览量
        return  userResponse;
    }

    @Override
    public List<SysUser> selectUsersByHot() {
        return sysUserMapper.selectUsersByHot();
    }
}
