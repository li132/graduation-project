package com.lijin.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Followtag {
    private Integer userId;

    private Integer tagId;
    @JSONField(format = "yyyy.MM.dd HH:mm")
    private Date createDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}