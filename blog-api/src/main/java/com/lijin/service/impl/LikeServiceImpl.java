package com.lijin.service.impl;

import com.lijin.common.util.UserUtils;
import com.lijin.mapper.ArticleMapper;
import com.lijin.mapper.ArticlelikeMapper;
import com.lijin.pojo.Article;
import com.lijin.pojo.Articlelike;
import com.lijin.pojo.User;
import com.lijin.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private ArticlelikeMapper articlelikeMapper;

    @Autowired
    private ArticleMapper articleMapper;



    @Override
    public Boolean isLike(Integer id) {
        User currentUser = UserUtils.getCurrentUser();
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId",currentUser.getId());
        map.put("articleId",id);
        Articlelike like=articlelikeMapper.isLike(map);
        return like!=null;
    }

    @Override
    @Transactional
    public void addLike(Integer id) {
        User currentUser = UserUtils.getCurrentUser();
        Articlelike articlelike = new Articlelike();
        articlelike.setArticleId(id);
        articlelike.setUserId(currentUser.getId().intValue());
        articlelike.setCreateDate(new Date());
        articlelikeMapper.insert(articlelike);
        Article oldArticle = articleMapper.selectByPrimaryKey(id);
        Integer likeCounts = oldArticle.getLoveCounts()==null?0:oldArticle.getLoveCounts();
        Article article = new Article();
        article.setLoveCounts(likeCounts+1);
        article.setId(id);
        articleMapper.updateLike(article);
    }

    @Override
    @Transactional
    public void cancelLike(Integer id) {
        User currentUser = UserUtils.getCurrentUser();
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId",currentUser.getId());
        map.put("articleId",id);
        articlelikeMapper.cancelLike(map);
        Article oldArticle = articleMapper.selectByPrimaryKey(id);
        Integer likeCounts = oldArticle.getLoveCounts()==null?0:oldArticle.getLoveCounts();
        Article article = new Article();
        article.setLoveCounts(likeCounts-1);
        article.setId(id);
        articleMapper.updateLike(article);
    }
}
