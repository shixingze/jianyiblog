package com.jianyi.jianyiblog.mapper;

import com.jianyi.jianyiblog.entity.Blog;
import com.jianyi.jianyiblog.entity.BlogExample;
import java.util.List;

import com.jianyi.jianyiblog.entity.dto.BlogDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    long countByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    int deleteByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer blogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    int insert(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    int insertSelective(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    List<Blog> selectByExample(BlogExample example);


    List<Blog> selectByBlog(Blog blog);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    BlogDto selectByPrimaryKey(Long blogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    BlogDto selectblogNumByPrimaryKey(Long blogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Blog record);

    List<Blog> selectHotSix();

    /**
     * 获取本月热门文章
     * @return
     */
    List<Blog> selectMouthBlogHot();

    @Update("UPDATE  blog  SET blog_like = blog_like + #{param1} WHERE blog_id = #{param2}")
    int updateAddLinkNum(@Param("num") int num,@Param("blogId") Long blogId);


    @Update("UPDATE  blog  SET blog_browsing = blog_browsing + #{param1} WHERE blog_id = #{param2}")
    int updateAddblogBrowsingNum(@Param("num") int num,@Param("blogId") Long blogId);


    /**
     * 点赞＋1
     */
    @Update("UPDATE  blog  SET blog_like = blog_like + 1 WHERE blog_id = #{blogId}")
   int updateStartAdd(Long blogId);

    /**
     * 点赞-1
     */
    @Update("UPDATE  blog  SET blog_like = blog_like -1 WHERE blog_id = #{blogId}")
    int updateStartRemove(Long blogId);
}