package com.jianyi.jianyiblog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 博客文章工具类
 */
public class BlogExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table blog
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table blog
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table blog
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    public BlogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table blog
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBlogIdIsNull() {
            addCriterion("blog_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("blog_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(Integer value) {
            addCriterion("blog_id =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(Integer value) {
            addCriterion("blog_id <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(Integer value) {
            addCriterion("blog_id >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_id >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(Integer value) {
            addCriterion("blog_id <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(Integer value) {
            addCriterion("blog_id <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<Integer> values) {
            addCriterion("blog_id in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<Integer> values) {
            addCriterion("blog_id not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(Integer value1, Integer value2) {
            addCriterion("blog_id between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_id not between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNull() {
            addCriterion("blog_title is null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNotNull() {
            addCriterion("blog_title is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleEqualTo(String value) {
            addCriterion("blog_title =", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotEqualTo(String value) {
            addCriterion("blog_title <>", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThan(String value) {
            addCriterion("blog_title >", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThanOrEqualTo(String value) {
            addCriterion("blog_title >=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThan(String value) {
            addCriterion("blog_title <", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThanOrEqualTo(String value) {
            addCriterion("blog_title <=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLike(String value) {
            addCriterion("blog_title like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotLike(String value) {
            addCriterion("blog_title not like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIn(List<String> values) {
            addCriterion("blog_title in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotIn(List<String> values) {
            addCriterion("blog_title not in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleBetween(String value1, String value2) {
            addCriterion("blog_title between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotBetween(String value1, String value2) {
            addCriterion("blog_title not between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogContentIsNull() {
            addCriterion("blog_content is null");
            return (Criteria) this;
        }

        public Criteria andBlogContentIsNotNull() {
            addCriterion("blog_content is not null");
            return (Criteria) this;
        }

        public Criteria andBlogContentEqualTo(String value) {
            addCriterion("blog_content =", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentNotEqualTo(String value) {
            addCriterion("blog_content <>", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentGreaterThan(String value) {
            addCriterion("blog_content >", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentGreaterThanOrEqualTo(String value) {
            addCriterion("blog_content >=", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentLessThan(String value) {
            addCriterion("blog_content <", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentLessThanOrEqualTo(String value) {
            addCriterion("blog_content <=", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentLike(String value) {
            addCriterion("blog_content like", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentNotLike(String value) {
            addCriterion("blog_content not like", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentIn(List<String> values) {
            addCriterion("blog_content in", values, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentNotIn(List<String> values) {
            addCriterion("blog_content not in", values, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentBetween(String value1, String value2) {
            addCriterion("blog_content between", value1, value2, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentNotBetween(String value1, String value2) {
            addCriterion("blog_content not between", value1, value2, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogLikeIsNull() {
            addCriterion("blog_like is null");
            return (Criteria) this;
        }

        public Criteria andBlogLikeIsNotNull() {
            addCriterion("blog_like is not null");
            return (Criteria) this;
        }

        public Criteria andBlogLikeEqualTo(Long value) {
            addCriterion("blog_like =", value, "blogLike");
            return (Criteria) this;
        }

        public Criteria andBlogLikeNotEqualTo(Long value) {
            addCriterion("blog_like <>", value, "blogLike");
            return (Criteria) this;
        }

        public Criteria andBlogLikeGreaterThan(Long value) {
            addCriterion("blog_like >", value, "blogLike");
            return (Criteria) this;
        }

        public Criteria andBlogLikeGreaterThanOrEqualTo(Long value) {
            addCriterion("blog_like >=", value, "blogLike");
            return (Criteria) this;
        }

        public Criteria andBlogLikeLessThan(Long value) {
            addCriterion("blog_like <", value, "blogLike");
            return (Criteria) this;
        }

        public Criteria andBlogLikeLessThanOrEqualTo(Long value) {
            addCriterion("blog_like <=", value, "blogLike");
            return (Criteria) this;
        }

        public Criteria andBlogLikeIn(List<Long> values) {
            addCriterion("blog_like in", values, "blogLike");
            return (Criteria) this;
        }

        public Criteria andBlogLikeNotIn(List<Long> values) {
            addCriterion("blog_like not in", values, "blogLike");
            return (Criteria) this;
        }

        public Criteria andBlogLikeBetween(Long value1, Long value2) {
            addCriterion("blog_like between", value1, value2, "blogLike");
            return (Criteria) this;
        }

        public Criteria andBlogLikeNotBetween(Long value1, Long value2) {
            addCriterion("blog_like not between", value1, value2, "blogLike");
            return (Criteria) this;
        }

        public Criteria andBlogCommentsIsNull() {
            addCriterion("blog_comments is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentsIsNotNull() {
            addCriterion("blog_comments is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentsEqualTo(Long value) {
            addCriterion("blog_comments =", value, "blogComments");
            return (Criteria) this;
        }

        public Criteria andBlogCommentsNotEqualTo(Long value) {
            addCriterion("blog_comments <>", value, "blogComments");
            return (Criteria) this;
        }

        public Criteria andBlogCommentsGreaterThan(Long value) {
            addCriterion("blog_comments >", value, "blogComments");
            return (Criteria) this;
        }

        public Criteria andBlogCommentsGreaterThanOrEqualTo(Long value) {
            addCriterion("blog_comments >=", value, "blogComments");
            return (Criteria) this;
        }

        public Criteria andBlogCommentsLessThan(Long value) {
            addCriterion("blog_comments <", value, "blogComments");
            return (Criteria) this;
        }

        public Criteria andBlogCommentsLessThanOrEqualTo(Long value) {
            addCriterion("blog_comments <=", value, "blogComments");
            return (Criteria) this;
        }

        public Criteria andBlogCommentsIn(List<Long> values) {
            addCriterion("blog_comments in", values, "blogComments");
            return (Criteria) this;
        }

        public Criteria andBlogCommentsNotIn(List<Long> values) {
            addCriterion("blog_comments not in", values, "blogComments");
            return (Criteria) this;
        }

        public Criteria andBlogCommentsBetween(Long value1, Long value2) {
            addCriterion("blog_comments between", value1, value2, "blogComments");
            return (Criteria) this;
        }

        public Criteria andBlogCommentsNotBetween(Long value1, Long value2) {
            addCriterion("blog_comments not between", value1, value2, "blogComments");
            return (Criteria) this;
        }

        public Criteria andBlogBrowsingIsNull() {
            addCriterion("blog_browsing is null");
            return (Criteria) this;
        }

        public Criteria andBlogBrowsingIsNotNull() {
            addCriterion("blog_browsing is not null");
            return (Criteria) this;
        }

        public Criteria andBlogBrowsingEqualTo(Long value) {
            addCriterion("blog_browsing =", value, "blogBrowsing");
            return (Criteria) this;
        }

        public Criteria andBlogBrowsingNotEqualTo(Long value) {
            addCriterion("blog_browsing <>", value, "blogBrowsing");
            return (Criteria) this;
        }

        public Criteria andBlogBrowsingGreaterThan(Long value) {
            addCriterion("blog_browsing >", value, "blogBrowsing");
            return (Criteria) this;
        }

        public Criteria andBlogBrowsingGreaterThanOrEqualTo(Long value) {
            addCriterion("blog_browsing >=", value, "blogBrowsing");
            return (Criteria) this;
        }

        public Criteria andBlogBrowsingLessThan(Long value) {
            addCriterion("blog_browsing <", value, "blogBrowsing");
            return (Criteria) this;
        }

        public Criteria andBlogBrowsingLessThanOrEqualTo(Long value) {
            addCriterion("blog_browsing <=", value, "blogBrowsing");
            return (Criteria) this;
        }

        public Criteria andBlogBrowsingIn(List<Long> values) {
            addCriterion("blog_browsing in", values, "blogBrowsing");
            return (Criteria) this;
        }

        public Criteria andBlogBrowsingNotIn(List<Long> values) {
            addCriterion("blog_browsing not in", values, "blogBrowsing");
            return (Criteria) this;
        }

        public Criteria andBlogBrowsingBetween(Long value1, Long value2) {
            addCriterion("blog_browsing between", value1, value2, "blogBrowsing");
            return (Criteria) this;
        }

        public Criteria andBlogBrowsingNotBetween(Long value1, Long value2) {
            addCriterion("blog_browsing not between", value1, value2, "blogBrowsing");
            return (Criteria) this;
        }

        public Criteria andBlogAbstractIsNull() {
            addCriterion("blog_abstract is null");
            return (Criteria) this;
        }

        public Criteria andBlogAbstractIsNotNull() {
            addCriterion("blog_abstract is not null");
            return (Criteria) this;
        }

        public Criteria andBlogAbstractEqualTo(String value) {
            addCriterion("blog_abstract =", value, "blogAbstract");
            return (Criteria) this;
        }

        public Criteria andBlogAbstractNotEqualTo(String value) {
            addCriterion("blog_abstract <>", value, "blogAbstract");
            return (Criteria) this;
        }

        public Criteria andBlogAbstractGreaterThan(String value) {
            addCriterion("blog_abstract >", value, "blogAbstract");
            return (Criteria) this;
        }

        public Criteria andBlogAbstractGreaterThanOrEqualTo(String value) {
            addCriterion("blog_abstract >=", value, "blogAbstract");
            return (Criteria) this;
        }

        public Criteria andBlogAbstractLessThan(String value) {
            addCriterion("blog_abstract <", value, "blogAbstract");
            return (Criteria) this;
        }

        public Criteria andBlogAbstractLessThanOrEqualTo(String value) {
            addCriterion("blog_abstract <=", value, "blogAbstract");
            return (Criteria) this;
        }

        public Criteria andBlogAbstractLike(String value) {
            addCriterion("blog_abstract like", value, "blogAbstract");
            return (Criteria) this;
        }

        public Criteria andBlogAbstractNotLike(String value) {
            addCriterion("blog_abstract not like", value, "blogAbstract");
            return (Criteria) this;
        }

        public Criteria andBlogAbstractIn(List<String> values) {
            addCriterion("blog_abstract in", values, "blogAbstract");
            return (Criteria) this;
        }

        public Criteria andBlogAbstractNotIn(List<String> values) {
            addCriterion("blog_abstract not in", values, "blogAbstract");
            return (Criteria) this;
        }

        public Criteria andBlogAbstractBetween(String value1, String value2) {
            addCriterion("blog_abstract between", value1, value2, "blogAbstract");
            return (Criteria) this;
        }

        public Criteria andBlogAbstractNotBetween(String value1, String value2) {
            addCriterion("blog_abstract not between", value1, value2, "blogAbstract");
            return (Criteria) this;
        }

        public Criteria andBlogCoverIsNull() {
            addCriterion("blog_cover is null");
            return (Criteria) this;
        }

        public Criteria andBlogCoverIsNotNull() {
            addCriterion("blog_cover is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCoverEqualTo(String value) {
            addCriterion("blog_cover =", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverNotEqualTo(String value) {
            addCriterion("blog_cover <>", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverGreaterThan(String value) {
            addCriterion("blog_cover >", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverGreaterThanOrEqualTo(String value) {
            addCriterion("blog_cover >=", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverLessThan(String value) {
            addCriterion("blog_cover <", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverLessThanOrEqualTo(String value) {
            addCriterion("blog_cover <=", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverLike(String value) {
            addCriterion("blog_cover like", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverNotLike(String value) {
            addCriterion("blog_cover not like", value, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverIn(List<String> values) {
            addCriterion("blog_cover in", values, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverNotIn(List<String> values) {
            addCriterion("blog_cover not in", values, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverBetween(String value1, String value2) {
            addCriterion("blog_cover between", value1, value2, "blogCover");
            return (Criteria) this;
        }

        public Criteria andBlogCoverNotBetween(String value1, String value2) {
            addCriterion("blog_cover not between", value1, value2, "blogCover");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("CREATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("CREATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("CREATED_BY =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("CREATED_BY <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("CREATED_BY >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATED_BY >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("CREATED_BY <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("CREATED_BY <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("CREATED_BY like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("CREATED_BY not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("CREATED_BY in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("CREATED_BY not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("CREATED_BY between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("CREATED_BY not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("CREATED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("CREATED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("CREATED_TIME =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("CREATED_TIME <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("CREATED_TIME >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_TIME >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("CREATED_TIME <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_TIME <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("CREATED_TIME in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("CREATED_TIME not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("CREATED_TIME between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_TIME not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNull() {
            addCriterion("UPDATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNotNull() {
            addCriterion("UPDATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByEqualTo(String value) {
            addCriterion("UPDATED_BY =", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotEqualTo(String value) {
            addCriterion("UPDATED_BY <>", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThan(String value) {
            addCriterion("UPDATED_BY >", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATED_BY >=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThan(String value) {
            addCriterion("UPDATED_BY <", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanOrEqualTo(String value) {
            addCriterion("UPDATED_BY <=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLike(String value) {
            addCriterion("UPDATED_BY like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotLike(String value) {
            addCriterion("UPDATED_BY not like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIn(List<String> values) {
            addCriterion("UPDATED_BY in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotIn(List<String> values) {
            addCriterion("UPDATED_BY not in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByBetween(String value1, String value2) {
            addCriterion("UPDATED_BY between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotBetween(String value1, String value2) {
            addCriterion("UPDATED_BY not between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("UPDATED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("UPDATED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("UPDATED_TIME =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("UPDATED_TIME <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("UPDATED_TIME >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATED_TIME >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("UPDATED_TIME <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATED_TIME <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("UPDATED_TIME in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("UPDATED_TIME not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATED_TIME between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATED_TIME not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table blog
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table blog
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}