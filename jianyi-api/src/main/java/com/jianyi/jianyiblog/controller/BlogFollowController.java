package com.jianyi.jianyiblog.controller;

import com.jianyi.jianyiblog.entity.BlogFollow;
import com.jianyi.utils.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关注控制器
 */
@RestController
@RequestMapping("/follow")
public class BlogFollowController {

    @PostMapping("/save")
    public AjaxResult save(@RequestBody BlogFollow blogFollow){
        //判断是否存在条件
        return  AjaxResult.success("12");
    }
}
