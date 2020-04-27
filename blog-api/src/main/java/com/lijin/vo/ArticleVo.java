package com.lijin.vo;

import com.lijin.entity.Article;

public class ArticleVo extends Article {

    private Integer year;

    private Integer month;

    private Integer tagId;

    private Integer categoryId;

    private Integer count;

    private Long userId;

    private Long authorId;

    private Integer collectId;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ArticleVo{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", tagId=" + tagId +
                ", categoryId=" + categoryId +
                ", count=" + count +
                '}';
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }
}
