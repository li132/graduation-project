package com.lijin.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Collectarticle {
    private Integer collectId;

    private Integer articleId;

    private Article article;
    @JSONField(format = "yyyy.MM.dd HH:mm")
    private Date createDate;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}