package com.lijin.repository.wrapper;

import com.lijin.entity.Article;
import com.lijin.vo.ArticleVo;
import com.lijin.vo.PageVo;

import java.util.List;

public interface ArticleWrapper {
    List<Article> listArticles(PageVo page);

    List<Article> listArticles(ArticleVo article, PageVo page);

    List<ArticleVo> listArchives();

}
