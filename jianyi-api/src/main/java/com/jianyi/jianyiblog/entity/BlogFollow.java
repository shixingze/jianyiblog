package com.jianyi.jianyiblog.entity;

public class BlogFollow {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_follow.follow_id
     *
     * @mbg.generated
     */
    private Long followId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_follow.source_uid
     *
     * @mbg.generated
     */
    private Long sourceUid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_follow.foris_uid
     *
     * @mbg.generated
     */
    private Long forisUid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_follow.create_time
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_follow.follow_id
     *
     * @return the value of blog_follow.follow_id
     *
     * @mbg.generated
     */
    public Long getFollowId() {
        return followId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_follow.follow_id
     *
     * @param followId the value for blog_follow.follow_id
     *
     * @mbg.generated
     */
    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_follow.source_uid
     *
     * @return the value of blog_follow.source_uid
     *
     * @mbg.generated
     */
    public Long getSourceUid() {
        return sourceUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_follow.source_uid
     *
     * @param sourceUid the value for blog_follow.source_uid
     *
     * @mbg.generated
     */
    public void setSourceUid(Long sourceUid) {
        this.sourceUid = sourceUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_follow.foris_uid
     *
     * @return the value of blog_follow.foris_uid
     *
     * @mbg.generated
     */
    public Long getForisUid() {
        return forisUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_follow.foris_uid
     *
     * @param forisUid the value for blog_follow.foris_uid
     *
     * @mbg.generated
     */
    public void setForisUid(Long forisUid) {
        this.forisUid = forisUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_follow.create_time
     *
     * @return the value of blog_follow.create_time
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_follow.create_time
     *
     * @param createTime the value for blog_follow.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_follow
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", followId=").append(followId);
        sb.append(", sourceUid=").append(sourceUid);
        sb.append(", forisUid=").append(forisUid);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}