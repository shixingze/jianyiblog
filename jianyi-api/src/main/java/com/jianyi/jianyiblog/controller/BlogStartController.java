package com.jianyi.jianyiblog.controller;

import com.jianyi.jianyiblog.entity.BlogStart;
import com.jianyi.jianyiblog.service.BlogStartService;
import com.jianyi.utils.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/start")
public class BlogStartController {

@Resource
private BlogStartService blogStartService;
    @PostMapping("/blog")
    public AjaxResult StartBlog(@RequestBody BlogStart blogStart){
        return  blogStartService.BlogStartCheck(blogStart);
    }
}
