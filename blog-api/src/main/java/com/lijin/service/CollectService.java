package com.lijin.service;


import com.lijin.pojo.Collect;
import com.lijin.pojo.User;
import com.lijin.vo.FollowVo;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface CollectService {
    Boolean isCollect(Integer id);

    List<Collect> getCollects();

    Object addCollect(Integer collectId, Integer articleId);

    Object cancelCollect(Integer collectId, Integer articleId);

    Object newCollects(String title);

    Object getCollect(Integer id);

    Object deleteCollect(Integer id);

    Boolean doFollow(FollowVo follow);

    Boolean cancelFollow(FollowVo follow);

    Boolean checkFollow(FollowVo follow);

    List<User> getFollow(Integer id);

    List<User> getauthors(Integer id);
}
