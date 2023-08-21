package com.jianyi.jianyiblog.service;

import com.jianyi.jianyiblog.common.AjaxResult;
import com.jianyi.jianyiblog.entity.BlogComment;

import java.util.List;

public interface BlogCommentService {

    /**
     * 查询指定id文章的所有评论
     */
    public List<BlogComment> selectListByBlogId(Long blogId);


    public AjaxResult addComment(BlogComment comment);
}
