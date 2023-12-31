package com.jianyi.jianyiblog.mapper;

import com.jianyi.jianyiblog.entity.BlogBlogCategory;
import com.jianyi.jianyiblog.entity.BlogBlogCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogBlogCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_blog_category
     *
     * @mbg.generated
     */
    long countByExample(BlogBlogCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_blog_category
     *
     * @mbg.generated
     */
    int deleteByExample(BlogBlogCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_blog_category
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_blog_category
     *
     * @mbg.generated
     */
    int insert(BlogBlogCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_blog_category
     *
     * @mbg.generated
     */
    int insertSelective(BlogBlogCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_blog_category
     *
     * @mbg.generated
     */
    List<BlogBlogCategory> selectByExample(BlogBlogCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_blog_category
     *
     * @mbg.generated
     */
    BlogBlogCategory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_blog_category
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") BlogBlogCategory record, @Param("example") BlogBlogCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_blog_category
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") BlogBlogCategory record, @Param("example") BlogBlogCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_blog_category
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(BlogBlogCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_blog_category
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(BlogBlogCategory record);
}