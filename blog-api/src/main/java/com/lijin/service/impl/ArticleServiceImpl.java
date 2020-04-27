package com.lijin.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lijin.mapper.*;
import com.lijin.pojo.*;
import com.lijin.vo.ArticleVo;
import com.lijin.vo.PageVo;
import com.lijin.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lijin.common.util.UserUtils;
import com.lijin.service.ArticleService;

/**
 * @author lijin
 * <p>
 * 2018年1月25日
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticlebodyMapper articlebodyMapper;
    @Autowired
    private ArticletagMapper articletagMapper;


    public PageVo change(PageVo page){
        String str=page.getName();
        if(str != null){
            String separator = "_";
            str = str.replaceAll("([a-z])([A-Z])", "$1"+separator+"$2").toLowerCase();
        }
        str = str+" "+page.getSort();
        System.out.println(str);
        page.setName(str);
        Integer start = (page.getPageNumber()-1)*page.getPageSize();
        Integer end = page.getPageSize()*page.getPageNumber()-1;
        page.setPageNumber(start);
        page.setPageSize(end);

        return page;
    }

    @Override
    public Map<String, Object> search(SearchVo search, PageVo page) {
        page=change(page);
        Map<String,Object> map=new HashMap<>();
        map.put("search",search);
        map.put("page",page);
        String searchType = search.getSearchType();
        List<Article> articles=articleMapper.search(map);
        List<User> users=userMapper.search(map);
        List<Tag> tags=tagMapper.search(map);
        Map<String,Object> result=new HashMap<>();
        if(searchType.equals("article")){
            System.out.println(articles);
            result.put("articles",articles);
        }else if(searchType.equals("tag")){
            System.out.println(tags);
            result.put("tags",tags);
        }else if(searchType.equals("user")){
            System.out.println(users);
            result.put("users",users);
        }else {
            result.put("articles",articles);
            result.put("users",users);
            result.put("tags",tags);
        }
        return result;
    }

    @Override
    public List<Article> listArticles(PageVo page) {
        page=change(page);
        List<Article> articles = articleMapper.listAllArticles(page);
        return articles;
    }

    @Override
    public List<Article> listArticles(ArticleVo article, PageVo page) {
        page=change(page);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("article",article);
        map.put("page",page);
        System.out.println("pageSort:"+page.getName());
        if(article.getUserId()!=null){
            return articleMapper.listArticlesByLike(map);
        }
        if(article.getCollectId()!=null){
            return articleMapper.listArticlesByCollectId(map);
        }
        List<Article> articles = articleMapper.listArticles(map);
        System.out.println("Service:"+articles);
        return articles;


    }

    @Override
    public List<Article> findAll() {
        return articleMapper.listAllArticles(new PageVo());
    }

    @Override
    public Article getArticleById(Integer id) {

        Article article = articleMapper.selectByPrimaryKey(id);
        List<Tag> tags = tagMapper.getByArticleId(article.getId());

        article.setTags(tags);
        return article;
    }

    @Override
    @Transactional
    public Integer publishArticle(Article article) {

        if(null != article.getId()){
            return this.updateArticle(article);
        }else{
            return this.saveArticle(article);
        }

    }

    @Override
    @Transactional
    public Integer saveArticle(Article article) {

        User currentUser = UserUtils.getCurrentUser();

        if (null != currentUser) {
            article.setAuthor(currentUser);
        }
        article.setCommentCounts(0);
        article.setViewCounts(0);
        article.setCollectCounts(0);
        article.setLoveCounts(0);
        article.setCreateDate(new Date());
        article.setWeight(Article.Article_Common);
        Articlebody body=article.getBody();
        articlebodyMapper.insert(body);
        article.setBodyId(body.getId());
        articleMapper.save(article);

        for(Tag tag:article.getTags()){
            Articletag articletag = new Articletag();
            articletag.setArticleId(article.getId());
            articletag.setTagId(tag.getId());
            articletagMapper.insert(articletag);
        }
        return article.getId();
    }

    @Override
    @Transactional
    public Integer updateArticle(Article article) {
        Article oldArticle = articleMapper.selectByPrimaryKey(article.getId());

        oldArticle.setTitle(article.getTitle());
        oldArticle.setSummary(article.getSummary());
        oldArticle.setBody(article.getBody());
        oldArticle.setCategory(article.getCategory());
        oldArticle.setTags(article.getTags());
        articleMapper.updateByPrimaryKey(oldArticle);
        return oldArticle.getId();
    }

    @Override
    @Transactional
    public void deleteArticleById(Integer id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Article> listArticlesByTag(Integer id) {
        Tag t = new Tag();
        t.setId(id);
        return articleMapper.findByTags(t);
    }

    @Override
    public List<Article> listArticlesByCategory(Integer id) {
        Category c = new Category();
        c.setId(id);

        return articleMapper.findByCategory(c);
    }

    @Override
    @Transactional
    public Article getArticleAndAddViews(Integer id) {
        int count = 1;
        Article article = articleMapper.selectByPrimaryKey(id);
        User author = article.getAuthor();
        System.out.println("=========author:"+author.getId()+" "+author.getAccount()+" "+author.getNickname());
        List<Tag> tags = tagMapper.getByArticleId(id);

        article.setTags(tags);
        article.setViewCounts(article.getViewCounts() + count);
        articleMapper.updateByPrimaryKey(article);
        return article;
    }

    @Override
    public List<Article> listHotArticles(int limit) {

        return articleMapper.findOrderByViewsAndLimit(limit);
    }

    @Override
    public List<Article> listNewArticles(int limit) {

        return articleMapper.findOrderByCreateDateAndLimit(limit);
    }

    @Override
    public List<ArticleVo> listArchives() {

        return articleMapper.listArchives();
    }

}
