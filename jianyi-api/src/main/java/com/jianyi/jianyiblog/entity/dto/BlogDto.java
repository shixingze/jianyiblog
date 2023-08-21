package com.jianyi.jianyiblog.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jianyi.jianyiblog.entity.Blog;

import java.util.List;

public class BlogDto extends Blog {

  private   List<CategoryDto> categoryList;


  private String checkStart;
  private String checkComment;
  private String checkShouCang;

    public String getCheckStart() {
        return checkStart;
    }

    public void setCheckStart(String checkStart) {
        this.checkStart = checkStart;
    }

    public String getCheckComment() {
        return checkComment;
    }

    public void setCheckComment(String checkComment) {
        this.checkComment = checkComment;
    }

    public String getCheckShouCang() {
        return checkShouCang;
    }

    public void setCheckShouCang(String checkShouCang) {
        this.checkShouCang = checkShouCang;
    }

    public List<CategoryDto> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryDto> categoryList) {
        this.categoryList = categoryList;
    }
}
