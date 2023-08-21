package com.jianyi.jianyiblog.mapper;

import com.jianyi.jianyiblog.entity.BlogFollow;
import com.jianyi.jianyiblog.entity.BlogFollowExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BlogFollowMapper {

    long countByExample(BlogFollowExample example);


    int deleteByExample(BlogFollowExample example);


    int deleteByPrimaryKey(Long followId);


    int insert(BlogFollow record);


    int insertSelective(BlogFollow record);


    List<BlogFollow> selectByExample(BlogFollowExample example);


    BlogFollow selectByPrimaryKey(Long followId);


    int updateByExampleSelective(@Param("record") BlogFollow record, @Param("example") BlogFollowExample example);


    int updateByExample(@Param("record") BlogFollow record, @Param("example") BlogFollowExample example);


    int updateByPrimaryKeySelective(BlogFollow record);


    int updateByPrimaryKey(BlogFollow record);
}