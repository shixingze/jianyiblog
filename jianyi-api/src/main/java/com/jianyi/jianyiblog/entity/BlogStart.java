package com.jianyi.jianyiblog.entity;

public class BlogStart {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_start.start_id
     *
     * @mbg.generated
     */
    private Long startId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_start.blog_id
     *
     * @mbg.generated
     */
    private Long blogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_start.user_id
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_start.create_time
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_start.de_flg
     *
     * @mbg.generated
     */
    private String deFlg;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_start.start_id
     *
     * @return the value of blog_start.start_id
     *
     * @mbg.generated
     */
    public Long getStartId() {
        return startId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_start.start_id
     *
     * @param startId the value for blog_start.start_id
     *
     * @mbg.generated
     */
    public void setStartId(Long startId) {
        this.startId = startId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_start.blog_id
     *
     * @return the value of blog_start.blog_id
     *
     * @mbg.generated
     */
    public Long getBlogId() {
        return blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_start.blog_id
     *
     * @param blogId the value for blog_start.blog_id
     *
     * @mbg.generated
     */
    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_start.user_id
     *
     * @return the value of blog_start.user_id
     *
     * @mbg.generated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_start.user_id
     *
     * @param userId the value for blog_start.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_start.create_time
     *
     * @return the value of blog_start.create_time
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_start.create_time
     *
     * @param createTime the value for blog_start.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_start.de_flg
     *
     * @return the value of blog_start.de_flg
     *
     * @mbg.generated
     */
    public String getDeFlg() {
        return deFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_start.de_flg
     *
     * @param deFlg the value for blog_start.de_flg
     *
     * @mbg.generated
     */
    public void setDeFlg(String deFlg) {
        this.deFlg = deFlg == null ? null : deFlg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_start
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", startId=").append(startId);
        sb.append(", blogId=").append(blogId);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", deFlg=").append(deFlg);
        sb.append("]");
        return sb.toString();
    }
}