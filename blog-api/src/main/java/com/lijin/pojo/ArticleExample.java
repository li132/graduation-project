package com.lijin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCommentCountsIsNull() {
            addCriterion("comment_counts is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountsIsNotNull() {
            addCriterion("comment_counts is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountsEqualTo(Integer value) {
            addCriterion("comment_counts =", value, "commentCounts");
            return (Criteria) this;
        }

        public Criteria andCommentCountsNotEqualTo(Integer value) {
            addCriterion("comment_counts <>", value, "commentCounts");
            return (Criteria) this;
        }

        public Criteria andCommentCountsGreaterThan(Integer value) {
            addCriterion("comment_counts >", value, "commentCounts");
            return (Criteria) this;
        }

        public Criteria andCommentCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_counts >=", value, "commentCounts");
            return (Criteria) this;
        }

        public Criteria andCommentCountsLessThan(Integer value) {
            addCriterion("comment_counts <", value, "commentCounts");
            return (Criteria) this;
        }

        public Criteria andCommentCountsLessThanOrEqualTo(Integer value) {
            addCriterion("comment_counts <=", value, "commentCounts");
            return (Criteria) this;
        }

        public Criteria andCommentCountsIn(List<Integer> values) {
            addCriterion("comment_counts in", values, "commentCounts");
            return (Criteria) this;
        }

        public Criteria andCommentCountsNotIn(List<Integer> values) {
            addCriterion("comment_counts not in", values, "commentCounts");
            return (Criteria) this;
        }

        public Criteria andCommentCountsBetween(Integer value1, Integer value2) {
            addCriterion("comment_counts between", value1, value2, "commentCounts");
            return (Criteria) this;
        }

        public Criteria andCommentCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_counts not between", value1, value2, "commentCounts");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andViewCountsIsNull() {
            addCriterion("view_counts is null");
            return (Criteria) this;
        }

        public Criteria andViewCountsIsNotNull() {
            addCriterion("view_counts is not null");
            return (Criteria) this;
        }

        public Criteria andViewCountsEqualTo(Integer value) {
            addCriterion("view_counts =", value, "viewCounts");
            return (Criteria) this;
        }

        public Criteria andViewCountsNotEqualTo(Integer value) {
            addCriterion("view_counts <>", value, "viewCounts");
            return (Criteria) this;
        }

        public Criteria andViewCountsGreaterThan(Integer value) {
            addCriterion("view_counts >", value, "viewCounts");
            return (Criteria) this;
        }

        public Criteria andViewCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("view_counts >=", value, "viewCounts");
            return (Criteria) this;
        }

        public Criteria andViewCountsLessThan(Integer value) {
            addCriterion("view_counts <", value, "viewCounts");
            return (Criteria) this;
        }

        public Criteria andViewCountsLessThanOrEqualTo(Integer value) {
            addCriterion("view_counts <=", value, "viewCounts");
            return (Criteria) this;
        }

        public Criteria andViewCountsIn(List<Integer> values) {
            addCriterion("view_counts in", values, "viewCounts");
            return (Criteria) this;
        }

        public Criteria andViewCountsNotIn(List<Integer> values) {
            addCriterion("view_counts not in", values, "viewCounts");
            return (Criteria) this;
        }

        public Criteria andViewCountsBetween(Integer value1, Integer value2) {
            addCriterion("view_counts between", value1, value2, "viewCounts");
            return (Criteria) this;
        }

        public Criteria andViewCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("view_counts not between", value1, value2, "viewCounts");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(Long value) {
            addCriterion("author_id =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(Long value) {
            addCriterion("author_id <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(Long value) {
            addCriterion("author_id >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("author_id >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(Long value) {
            addCriterion("author_id <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(Long value) {
            addCriterion("author_id <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<Long> values) {
            addCriterion("author_id in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<Long> values) {
            addCriterion("author_id not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(Long value1, Long value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(Long value1, Long value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andBodyIdIsNull() {
            addCriterion("body_id is null");
            return (Criteria) this;
        }

        public Criteria andBodyIdIsNotNull() {
            addCriterion("body_id is not null");
            return (Criteria) this;
        }

        public Criteria andBodyIdEqualTo(Long value) {
            addCriterion("body_id =", value, "bodyId");
            return (Criteria) this;
        }

        public Criteria andBodyIdNotEqualTo(Long value) {
            addCriterion("body_id <>", value, "bodyId");
            return (Criteria) this;
        }

        public Criteria andBodyIdGreaterThan(Long value) {
            addCriterion("body_id >", value, "bodyId");
            return (Criteria) this;
        }

        public Criteria andBodyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("body_id >=", value, "bodyId");
            return (Criteria) this;
        }

        public Criteria andBodyIdLessThan(Long value) {
            addCriterion("body_id <", value, "bodyId");
            return (Criteria) this;
        }

        public Criteria andBodyIdLessThanOrEqualTo(Long value) {
            addCriterion("body_id <=", value, "bodyId");
            return (Criteria) this;
        }

        public Criteria andBodyIdIn(List<Long> values) {
            addCriterion("body_id in", values, "bodyId");
            return (Criteria) this;
        }

        public Criteria andBodyIdNotIn(List<Long> values) {
            addCriterion("body_id not in", values, "bodyId");
            return (Criteria) this;
        }

        public Criteria andBodyIdBetween(Long value1, Long value2) {
            addCriterion("body_id between", value1, value2, "bodyId");
            return (Criteria) this;
        }

        public Criteria andBodyIdNotBetween(Long value1, Long value2) {
            addCriterion("body_id not between", value1, value2, "bodyId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andLoveCountsIsNull() {
            addCriterion("love_counts is null");
            return (Criteria) this;
        }

        public Criteria andLoveCountsIsNotNull() {
            addCriterion("love_counts is not null");
            return (Criteria) this;
        }

        public Criteria andLoveCountsEqualTo(Integer value) {
            addCriterion("love_counts =", value, "loveCounts");
            return (Criteria) this;
        }

        public Criteria andLoveCountsNotEqualTo(Integer value) {
            addCriterion("love_counts <>", value, "loveCounts");
            return (Criteria) this;
        }

        public Criteria andLoveCountsGreaterThan(Integer value) {
            addCriterion("love_counts >", value, "loveCounts");
            return (Criteria) this;
        }

        public Criteria andLoveCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("love_counts >=", value, "loveCounts");
            return (Criteria) this;
        }

        public Criteria andLoveCountsLessThan(Integer value) {
            addCriterion("love_counts <", value, "loveCounts");
            return (Criteria) this;
        }

        public Criteria andLoveCountsLessThanOrEqualTo(Integer value) {
            addCriterion("love_counts <=", value, "loveCounts");
            return (Criteria) this;
        }

        public Criteria andLoveCountsIn(List<Integer> values) {
            addCriterion("love_counts in", values, "loveCounts");
            return (Criteria) this;
        }

        public Criteria andLoveCountsNotIn(List<Integer> values) {
            addCriterion("love_counts not in", values, "loveCounts");
            return (Criteria) this;
        }

        public Criteria andLoveCountsBetween(Integer value1, Integer value2) {
            addCriterion("love_counts between", value1, value2, "loveCounts");
            return (Criteria) this;
        }

        public Criteria andLoveCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("love_counts not between", value1, value2, "loveCounts");
            return (Criteria) this;
        }

        public Criteria andCollectCountsIsNull() {
            addCriterion("collect_counts is null");
            return (Criteria) this;
        }

        public Criteria andCollectCountsIsNotNull() {
            addCriterion("collect_counts is not null");
            return (Criteria) this;
        }

        public Criteria andCollectCountsEqualTo(Integer value) {
            addCriterion("collect_counts =", value, "collectCounts");
            return (Criteria) this;
        }

        public Criteria andCollectCountsNotEqualTo(Integer value) {
            addCriterion("collect_counts <>", value, "collectCounts");
            return (Criteria) this;
        }

        public Criteria andCollectCountsGreaterThan(Integer value) {
            addCriterion("collect_counts >", value, "collectCounts");
            return (Criteria) this;
        }

        public Criteria andCollectCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_counts >=", value, "collectCounts");
            return (Criteria) this;
        }

        public Criteria andCollectCountsLessThan(Integer value) {
            addCriterion("collect_counts <", value, "collectCounts");
            return (Criteria) this;
        }

        public Criteria andCollectCountsLessThanOrEqualTo(Integer value) {
            addCriterion("collect_counts <=", value, "collectCounts");
            return (Criteria) this;
        }

        public Criteria andCollectCountsIn(List<Integer> values) {
            addCriterion("collect_counts in", values, "collectCounts");
            return (Criteria) this;
        }

        public Criteria andCollectCountsNotIn(List<Integer> values) {
            addCriterion("collect_counts not in", values, "collectCounts");
            return (Criteria) this;
        }

        public Criteria andCollectCountsBetween(Integer value1, Integer value2) {
            addCriterion("collect_counts between", value1, value2, "collectCounts");
            return (Criteria) this;
        }

        public Criteria andCollectCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_counts not between", value1, value2, "collectCounts");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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