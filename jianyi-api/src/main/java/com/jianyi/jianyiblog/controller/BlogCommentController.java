package com.jianyi.jianyiblog.controller;

import com.jianyi.jianyiblog.common.AjaxResult;
import com.jianyi.jianyiblog.entity.BlogComment;
import com.jianyi.jianyiblog.service.BlogCommentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/blog/comment")
public class BlogCommentController {

    @Resource
    private BlogCommentService commentService;

    /**
     * 获取评论树
     * @param blogId
     * @return
     */
    @GetMapping("/tree")
    public AjaxResult tree(Long blogId){
       return AjaxResult.success(commentService.selectListByBlogId(blogId));
    }
    /**
     * 新增评论
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody BlogComment comment){
    return  commentService.addComment(comment);
    }
}
