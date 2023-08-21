package com.jianyi.jianyiblog.service.Impl;

import com.jianyi.jianyiblog.entity.BlogLook;
import com.jianyi.jianyiblog.mapper.BlogLookMapper;
import com.jianyi.jianyiblog.service.BlogLookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BlogLookServiceImpl implements BlogLookService {

    @Resource
    private BlogLookMapper blogLookMapper;
    @Override
    public int insert(BlogLook blogLook) {
     return    blogLookMapper.insert(blogLook);
    }
}
