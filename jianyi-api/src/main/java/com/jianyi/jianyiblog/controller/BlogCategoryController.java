package com.jianyi.jianyiblog.controller;

import com.jianyi.jianyiblog.common.AjaxResult;
import com.jianyi.jianyiblog.entity.BlogCategory;
import com.jianyi.jianyiblog.service.BlogCategoryService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/blog/category")
public class BlogCategoryController {

    @Resource
    private BlogCategoryService blogCategoryService;
    /**
     * 新增与修改
     * @return
     */
    @PostMapping("/save")
    public AjaxResult save(@RequestBody BlogCategory blogCategory) throws Exception {
        return  blogCategoryService.save(blogCategory);
    }
    /**
     * 获取第一分类
     * @return
     */
    @GetMapping("/firstCate")
    public AjaxResult firstCate() throws Exception {
        return  blogCategoryService.firstCate();
    }
    /**
     * 获取第子集分类
     * @return
     */
    @PostMapping("/childCate")
    public AjaxResult childCate(@RequestBody BlogCategory blogCategory) throws Exception {
        if (ObjectUtils.isEmpty(blogCategory.getCategoryId())){
            return AjaxResult.error("未选择一级分类");
        }
        return  blogCategoryService.childtCate(blogCategory.getCategoryId());
    }
}
