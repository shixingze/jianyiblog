package com.jianyi.jianyiblog.entity.dto;

import com.jianyi.jianyiblog.entity.BlogComment;

import java.util.ArrayList;
import java.util.List;

public class CommentTree {

    /**
     * 子集
     */
    private  List<BlogComment> childs =new ArrayList<>();

    /**
     * 是否作者本人
     * @return
     */
    private int isMy;

    public int getIsMy() {
        return isMy;
    }

    public void setIsMy(int isMy) {
        this.isMy = isMy;
    }

    public List<BlogComment> getChilds() {
        return childs;
    }

    public void setChilds(List<BlogComment> childs) {
        this.childs = childs;
    }
}
