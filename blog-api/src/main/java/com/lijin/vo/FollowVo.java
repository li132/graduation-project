package com.lijin.vo;

import com.lijin.pojo.Follow;

import java.io.Serializable;

public class FollowVo implements Serializable {
    private Long userId;
    private Long authorId;
    private Integer tagId;

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

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "FollowVo{" +
                "userId=" + userId +
                ", authorId=" + authorId +
                ", tagId=" + tagId +
                '}';
    }
}
