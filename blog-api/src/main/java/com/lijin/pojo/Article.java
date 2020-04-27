package com.lijin.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Article implements Serializable {

    public static final int Article_Common = 0;

    private Integer id;
    //评论数
    private Integer commentCounts;
    //评论
    private List<Comment> comments;
    //创建时间
    @JSONField(format = "yyyy.MM.dd HH:mm")
    private Date createDate;
    //摘要
    private String summary;
    //标题
    private String title;
    //浏览量
    private Integer viewCounts;

    private Integer weight = Article_Common;
    //作者
    private Integer authorId;

    private User author;
    //文章内容
    private Long bodyId;
    private Articlebody body;
    //分类
    private Integer categoryId;
    private Category category;
    //标签
    private List<Tag> tags;
    //点赞数
    private Integer loveCounts;
    //收藏数
    private Integer collectCounts;
    //状态
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(Integer commentCounts) {
        this.commentCounts = commentCounts;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getViewCounts() {
        return viewCounts;
    }

    public void setViewCounts(Integer viewCounts) {
        this.viewCounts = viewCounts;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getLoveCounts() {
        return loveCounts;
    }

    public void setLoveCounts(Integer loveCounts) {
        this.loveCounts = loveCounts;
    }

    public Integer getCollectCounts() {
        return collectCounts;
    }

    public void setCollectCounts(Integer collectCounts) {
        this.collectCounts = collectCounts;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Articlebody getBody() {
        return body;
    }

    public void setBody(Articlebody body) {
        this.body = body;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Long getBodyId() {
        return bodyId;
    }

    public void setBodyId(Long bodyId) {
        this.bodyId = bodyId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", commentCounts=" + commentCounts +
                ", createDate=" + createDate +
                ", summary='" + summary + '\'' +
                ", title='" + title + '\'' +
                ", viewCounts=" + viewCounts +
                ", weight=" + weight +
                ", authorId=" + authorId +
                ", author=" + author +
                ", bodyId=" + bodyId +
                ", categoryId=" + categoryId +
                ", loveCounts=" + loveCounts +
                ", collectCounts=" + collectCounts +
                ", status=" + status +
                '}';
    }
}