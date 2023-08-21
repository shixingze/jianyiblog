package com.jianyi.jianyiblog.service.Impl;

import com.jianyi.jianyiblog.entity.BlogStart;
import com.jianyi.jianyiblog.entity.BlogStartExample;
import com.jianyi.jianyiblog.mapper.BlogMapper;
import com.jianyi.jianyiblog.mapper.BlogStartMapper;
import com.jianyi.jianyiblog.service.BlogStartService;
import com.jianyi.utils.AjaxResult;
import com.jianyi.utils.AuthUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class BlogStartServiceImpl implements BlogStartService {

    @Resource
    private BlogStartMapper blogStartMapper;
@Resource
private BlogMapper blogMapper;

    @Override
    public AjaxResult BlogStartCheck(BlogStart blogStart) {
        Long userId = AuthUtils.getUser().getUserId();
        String now  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        if (ObjectUtils.isNotEmpty(blogStart.getBlogId())) {
            BlogStartExample example = new BlogStartExample();
            BlogStartExample.Criteria criteria = example.createCriteria().andBlogIdEqualTo(blogStart.getBlogId()).andUserIdEqualTo(userId);
            Long num = blogStartMapper.countByExample(example);
            if (num > 0) {
            blogStartMapper.deleteByExample(example);
            blogMapper.updateStartRemove(blogStart.getBlogId());
            return  AjaxResult.success("取消","startNO");
            } else {
                blogStart.setUserId(userId);
                blogStart.setCreateTime(now);
                blogStart.setDeFlg("0");
                blogStartMapper.insert(blogStart);
                blogMapper.updateStartAdd(blogStart.getBlogId());
                return AjaxResult.success("点赞","startOK");
            }
        }else {
            return  AjaxResult.erro("未传入文章id");
        }
    }
}
