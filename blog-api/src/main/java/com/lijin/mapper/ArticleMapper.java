package com.lijin.mapper;

import com.lijin.pojo.Article;
import com.lijin.pojo.ArticleExample;
import com.lijin.pojo.Category;
import com.lijin.pojo.Tag;
import com.lijin.vo.ArticleVo;
import com.lijin.vo.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ArticleMapper {
    int countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> listAllArticles(PageVo page);


    List<Article> findByTags(Tag t);

    List<Article> findByCategory(Category c);

    List<Article> findOrderByViewsAndLimit(int limit);

    List<Article> findOrderByCreateDateAndLimit(int limit);

    List<ArticleVo> listArchives();

    void save(Article article);

    List<Article> listArticles(HashMap<String, Object> map);

    void addCommentCounts(Article article);

    List<Article> search(Map<String, Object> map);

    void updateLike(Article article);

    void changeCollectcounts(HashMap<Object, Object> map);

    List<Article> listArticlesByLike(HashMap<String, Object> map);

    List<Article> listArticlesByCollectId(HashMap<String, Object> map);

    List<Article> listAllArticlesByCollectId(Integer id);
}