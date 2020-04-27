package com.lijin.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Follow {
    private Integer userId;

    private Integer followerId;
    @JSONField(format = "yyyy.MM.dd HH:mm")
    private Date createDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}