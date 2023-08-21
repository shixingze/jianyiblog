package com.jianyi.jianyiblog.service;

import com.jianyi.jianyiblog.common.AjaxResult;
import com.jianyi.jianyiblog.entity.BlogCategory;
import com.jianyi.jianyiblog.entity.BlogCategoryExample;
import com.jianyi.jianyiblog.mapper.BlogCategoryMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 类别业务层
 */
@Service
public class BlogCategoryService {

    @Resource
    private BlogCategoryMapper blogCategoryMapper;

    public AjaxResult save(BlogCategory blogCategory) throws Exception {
        String now  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        if (ObjectUtils.isEmpty(blogCategory.getCategoryPid())){
            blogCategory.setCategoryPid(0);
        }
        if (!checkName(blogCategory.getCategoryName())){
           return AjaxResult.error("名称已经存在");
        }
        if (ObjectUtils.isEmpty(blogCategory.getCategoryId())){
            blogCategory.setCreatedTime(now);
            blogCategory.setCreatedBy("admin");
            blogCategory.setUpdatedTime(now);
            blogCategory.setUpdatedBy("admin");
             int num =  blogCategoryMapper.insertSelective(blogCategory);
            if (num > 0){
                return  AjaxResult.success("新增成功");
            }
            return  AjaxResult.error("新增失败");
        }else {
            blogCategory.setUpdatedTime(now);
            blogCategory.setUpdatedBy("admin");
            int num =  blogCategoryMapper.updateByPrimaryKey(blogCategory);
            if (num >0){
                return  AjaxResult.success("修改成功");
            }
            return  AjaxResult.error("修改失败");
        }
    }
    public AjaxResult firstCate() throws Exception {
        BlogCategoryExample blogCategoryExample = new BlogCategoryExample();
        BlogCategoryExample.Criteria criteria = blogCategoryExample.createCriteria();
        criteria.andCategoryPidEqualTo(0);
        List<BlogCategory> categories=  blogCategoryMapper.selectByExample(blogCategoryExample);
        return  AjaxResult.success(categories);
    }

    public AjaxResult childtCate(Integer pid) throws Exception {
        BlogCategoryExample blogCategoryExample = new BlogCategoryExample();
        BlogCategoryExample.Criteria criteria = blogCategoryExample.createCriteria();
        criteria.andCategoryPidEqualTo(pid);
        List<BlogCategory> categories=  blogCategoryMapper.selectByExample(blogCategoryExample);
        return  AjaxResult.success(categories);
    }
    /**
     * 检查名称
     */
    public boolean  checkName(String  blogCategory){
        BlogCategory category = new BlogCategory();
        category.setCategoryName(blogCategory);
        BlogCategory blogCategory1=  blogCategoryMapper.selectByPrimaryKeyName(category);
        if (ObjectUtils.isNotEmpty(blogCategory1)){
             return false;
        }
        return true;
    }
}
