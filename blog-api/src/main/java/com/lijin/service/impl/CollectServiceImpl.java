package com.lijin.service.impl;

import com.lijin.common.util.UserUtils;
import com.lijin.mapper.*;
import com.lijin.pojo.*;
import com.lijin.service.CollectService;
import com.lijin.vo.FollowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private CollectarticleMapper collectArticleMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private FollowMapper followMapper;
    @Autowired
    private FollowtagMapper followtagMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean isCollect(Integer id) {
        User currentUser = UserUtils.getCurrentUser();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("articleId",id);
        map.put("userId",currentUser.getId());
        return collectMapper.isCollect(map)>0;
    }

    @Override
    public List<Collect> getCollects() {
        User currentUser = UserUtils.getCurrentUser();
        CollectExample example = new CollectExample();
        CollectExample.Criteria criteria = new CollectExample().createCriteria();
        criteria.andUserIdEqualTo(currentUser.getId().intValue());
        example.setOrderByClause("create_date desc");
        List<Collect> collects = collectMapper.selectByExample(example);

        for(Collect collect:collects){
            List<Article> articles=new ArrayList<>();
            List<Collectarticle> collectarticles = collectArticleMapper.getByCollectId(collect.getCollectId());
            for(Collectarticle co:collectarticles){
                articles.add(co.getArticle());
                System.out.println(co.getArticle());
            }
            System.out.println("articles:"+articles);
            collect.setArticles(articles);
        }

        return collects;
    }

    @Override
    @Transactional
    public Object addCollect(Integer collectId, Integer articleId) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("collectId",collectId);
        map.put("articleId",articleId);
        map.put("i",1);
        if(!isCollect(articleId)){
            articleMapper.changeCollectcounts(map);
        }
        collectMapper.changeArticleNo(map);
        Collectarticle collectarticle = new Collectarticle();
        collectarticle.setArticleId(articleId);
        collectarticle.setCollectId(collectId);
        collectarticle.setCreateDate(new Date());
        collectArticleMapper.insert(collectarticle);

        return null;
    }

    @Override
    @Transactional
    public Object cancelCollect(Integer collectId, Integer articleId) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("articleId",articleId);
        map.put("collectId",collectId);
        map.put("i",-1);
        collectMapper.changeArticleNo(map);
        collectArticleMapper.cancel(map);
        if(!isCollect(articleId)){
            articleMapper.changeCollectcounts(map);
        }
        return null;
    }

    @Override
    public Object newCollects(String title) {
        Collect collect = new Collect();
        User currentUser = UserUtils.getCurrentUser();
        collect.setCreateDate(new Date());
        collect.setTitle(title);
        collect.setUserId(currentUser.getId().intValue());
        collect.setArticleNo(0);
        collectMapper.insert(collect);
        return collect.getCollectId();
    }

    @Override
    public Object getCollect(Integer id) {
        return collectMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Object deleteCollect(Integer id) {

        List<Article> articles = articleMapper.listAllArticlesByCollectId(id);
        for(Article article:articles){
            cancelCollect(id,article.getId());
        }
        collectMapper.deleteByPrimaryKey(id);
        return null;
    }

    @Override
    @Transactional
    public Boolean doFollow(FollowVo follow) {
        if (follow.getAuthorId()!=null){
            Follow follow1 = new Follow();
            follow1.setCreateDate(new Date());
            follow1.setUserId(follow.getUserId().intValue());
            follow1.setFollowerId(follow.getAuthorId().intValue());
            followMapper.insert(follow1);
        }
        if(follow.getTagId()!=null){
            Followtag followtag = new Followtag();
            followtag.setUserId(follow.getUserId().intValue());
            followtag.setTagId(follow.getTagId());
            followtag.setCreateDate(new Date());
            followtagMapper.insert(followtag);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean cancelFollow(FollowVo follow) {
        if (follow.getAuthorId()!=null ){
            followMapper.cancelFollow(follow);
        }
        if(follow.getTagId()!=null){
            followtagMapper.cancelFollow(follow);
        }
        return true;
    }

    @Override
    public Boolean checkFollow(FollowVo follow) {
        System.out.println("======================follow:"+follow);
        if (follow.getAuthorId()!=null){
            return followMapper.find(follow)>0;
        }
        if(follow.getTagId()!=null){
            return followtagMapper.find(follow)>0;
        }
        return false;
    }

    @Override
    public List<User> getFollow(Integer id) {
        return userMapper.getFollow(id);

    }

    @Override
    public List<User> getauthors(Integer id) {
        return userMapper.getauthors(id);
    }
}
