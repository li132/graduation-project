package com.lijin.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Articlelike {
    private Integer articleId;

    private Integer userId;
    @JSONField(format = "yyyy.MM.dd HH:mm")
    private Date createDate;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}