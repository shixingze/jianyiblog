package com.jianyi.jianyiblog.mapper;

import com.jianyi.jianyiblog.entity.BlogStart;
import com.jianyi.jianyiblog.entity.BlogStartExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BlogStartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_start
     *
     * @mbg.generated
     */
    long countByExample(BlogStartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_start
     *
     * @mbg.generated
     */
    int deleteByExample(BlogStartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_start
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long startId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_start
     *
     * @mbg.generated
     */
    int insert(BlogStart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_start
     *
     * @mbg.generated
     */
    int insertSelective(BlogStart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_start
     *
     * @mbg.generated
     */
    List<BlogStart> selectByExample(BlogStartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_start
     *
     * @mbg.generated
     */
    BlogStart selectByPrimaryKey(Long startId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_start
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") BlogStart record, @Param("example") BlogStartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_start
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") BlogStart record, @Param("example") BlogStartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_start
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(BlogStart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_start
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(BlogStart record);

    List<BlogStart> selectAllByblogCreateName(String createName);


    //查询某用户下被点赞数量
    Long selectCountStartNumByUserName(String userName);
}