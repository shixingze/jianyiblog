package com.jianyi.utils;

import com.jianyi.jianyiblog.entity.BlogComment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TreeUtils {


    public static List<BlogComment> commentTree(List<BlogComment> data, int rootId){
        List<BlogComment> list = new ArrayList<>();
        Map<Integer, Object> treePidMap = data.stream().collect(Collectors.toMap(BlogComment::getCommentId, t -> t));
        data.forEach( comment->{
            //这里获取作者id
            if (comment.getCommentUid() == 1){
                comment.setIsMy(1);
            }
            if (comment.getCommentPid().equals(rootId)){
             list.add(comment);
            }else {
                //找到父元素
                BlogComment parentNode = (BlogComment) treePidMap.get(comment.getCommentPid());
                if(parentNode==null){
                    // 可能出现 rootPid 更高的节点 这个操作相当于截断
                    return;
                }
                if (parentNode.getChilds() == null) {
                    parentNode.setChilds(new ArrayList());
                }
                parentNode.getChilds().add(comment);
            }
        });
        return list;
     }
}
