package com.jianyi.jianyiblog.service.Impl;

import com.jianyi.auth.entity.SysUser;
import com.jianyi.auth.entity.SysUserEntity;
import com.jianyi.jianyiblog.common.AjaxResult;
import com.jianyi.jianyiblog.entity.BlogComment;
import com.jianyi.jianyiblog.entity.BlogCommentExample;
import com.jianyi.jianyiblog.entity.dto.BlogDto;
import com.jianyi.jianyiblog.mapper.BlogCommentMapper;
import com.jianyi.jianyiblog.mapper.BlogMapper;
import com.jianyi.jianyiblog.service.BlogCommentService;
import com.jianyi.utils.AuthUtils;
import com.jianyi.utils.TreeUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogCommentServiceImpl implements BlogCommentService {

    @Resource
    private BlogCommentMapper blogCommentMapper;

    @Resource
    private BlogMapper blogMapper;
    /**
     * 查询指定id博客以下的所有评论
     * @return
     */
    @Override
    public List<BlogComment> selectListByBlogId(Long blogId) {
       BlogDto blogDto = blogMapper.selectByPrimaryKey(blogId);
        List<BlogComment> list = blogCommentMapper.selectByBlogId(blogDto);
        List<BlogComment> first = new ArrayList<>();
        if (ObjectUtils.isNotEmpty(list)){
            for (BlogComment c : list){
                if (c.getCommentPid() == 0){
                    c.setChilds(new ArrayList<>());
                    first.add(c);
                }
            }
        }
        // 遍历所有一级评论
        for (BlogComment parentComment : first) {
            // 返回时间

                String []  datas = parentComment.getCreatedTime().split(" ");
                if (ObjectUtils.isNotEmpty(datas)){
                    parentComment.setCreatedTime(datas[0]);
                }
            List<BlogComment> twoChids = list.stream().filter(o ->o.getCommentPid().equals(parentComment.getCommentId())).collect(Collectors.toList());
            if (twoChids.size() > 0 ){
               List<Integer> ids = twoChids.stream().map(BlogComment::getCommentId).collect(Collectors.toList());
               List<BlogComment> two = new ArrayList<>();
               getChilds(ids,list,two);
               two.addAll(twoChids);
               for (BlogComment child: two){
                   String []  cd = child.getCreatedTime().split(" ");
                   if (ObjectUtils.isNotEmpty(datas)){
                       child.setCreatedTime(cd[0]);
                   }
               }
               parentComment.setChilds(two);
            }
        }
        return first;


        //return  TreeUtils.commentTree(list,0);
    }

    /**
     * 新增评论
     * @param comment
     * @return
     */
    @Override
    public AjaxResult addComment(BlogComment comment) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
        if (StringUtils.isEmpty(comment.getCommentText())){
            return AjaxResult.error("新增失败，内容不可以为空");
        }
        if (ObjectUtils.isEmpty( ObjectUtils.isEmpty(comment.getCommentPid()))){
            return AjaxResult.error("新增失败");
        }
        SysUserEntity user = AuthUtils.getUser();
        //评论人id
        comment.setCommentUid(user.getUserId().intValue());
        comment.setAdminComment(0);
        comment.setStartNum(0);
        comment.setCreatedBy(user.getUsername());
        comment.setUpdatedBy(user.getUsername());
        String date =  format.format(new Date());
        comment.setCreatedTime(date);
        comment.setUpdatedTime(date);
       int num =  blogCommentMapper.insert(comment);
       if (num > 0){
           blogMapper.updateAddLinkNum(1,comment.getBlogId());
           return AjaxResult.success("创建成功");

       }
        return AjaxResult.error("创建失败");
    }


    public List<BlogComment> getChilds(List<Integer> pIds ,List<BlogComment> list,List<BlogComment> allList){
        List<BlogComment> chids = new ArrayList<>();
        list.forEach(comment -> {
            if (pIds.contains(comment.getCommentPid())){
                chids.add(comment);
            }
        });
        if (chids.size() > 0){
            List<Integer> ids = chids.stream().map(BlogComment::getCommentId).collect(Collectors.toList());
            allList.addAll(chids);
            getChilds(ids,list,allList);
        }
        return chids;
    }

    private BlogComment builderChildComment(BlogComment parentComment, List<BlogComment> commentList) {
        // 初始化子级评论
        parentComment.setChilds(new ArrayList<BlogComment>());
        // 遍历所有评论找出一级评论下的子级评论
        for (BlogComment comment : commentList) {
            if (parentComment.getCommentId().equals(comment.getCommentPid())) {
                // 初始化属性
                comment.setReplyName(parentComment.getCreatedBy());
                if (parentComment.getChilds() == null) {
                    parentComment.setChilds(new ArrayList<BlogComment>());
                }
                // 递归调用该方法
                parentComment.getChilds().add(builderChildComment(comment,commentList));
            }
        }
        return parentComment;
    }
}
