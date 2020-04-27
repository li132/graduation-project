package com.lijin.service;

import java.util.List;
import java.util.Map;

import com.lijin.pojo.Article;
import com.lijin.vo.ArticleVo;
import com.lijin.vo.PageVo;
import com.lijin.vo.SearchVo;

/**
 * @author lijin
 * <p>
 * 2018年1月25日
 */
public interface ArticleService {

    Map<String, Object> search(SearchVo search, PageVo page);

    List<Article> listArticles(PageVo page);

    List<Article> listArticles(ArticleVo article, PageVo page);

    List<Article> findAll();

    Article getArticleById(Integer id);

    Integer publishArticle(Article article);

    Integer saveArticle(Article article);

    Integer updateArticle(Article article);

    void deleteArticleById(Integer id);

    List<Article> listArticlesByTag(Integer id);

    List<Article> listArticlesByCategory(Integer id);

    Article getArticleAndAddViews(Integer id);

    List<Article> listHotArticles(int limit);

    List<Article> listNewArticles(int limit);

    List<ArticleVo> listArchives();


}
