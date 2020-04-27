package com.lijin.controller;

import java.util.List;
import java.util.Map;

import com.lijin.common.annotation.LogAnnotation;
import com.lijin.pojo.*;
import com.lijin.service.CollectService;
import com.lijin.service.LikeService;
import com.lijin.vo.ArticleVo;
import com.lijin.vo.FollowVo;
import com.lijin.vo.PageVo;
import com.lijin.vo.SearchVo;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;
import com.lijin.common.constant.Base;
import com.lijin.common.constant.ResultCode;
import com.lijin.common.result.Result;
import com.lijin.service.ArticleService;

/**
 * 文章api
 *
 * @author lijin
 * <p>
 * 2018年1月25日
 */
@RestController
@RequestMapping(value = "/articles")
public class ArticleController {


    @Autowired
    private ArticleService articleService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private CollectService collectService;

    @GetMapping
    @FastJsonView(
            exclude = {
                    @FastJsonFilter(clazz = Article.class, props = {"body", "category", "comments"}),
                    @FastJsonFilter(clazz = Tag.class, props = {"id", "avatar"})},
            include = {@FastJsonFilter(clazz = User.class, props = {"id","nickname"})})
    @LogAnnotation(module = "文章", operation = "获取所有文章")
    public Result listArticles(ArticleVo article, PageVo page) {
        System.out.println("articleVo:"+article);
        System.out.println(page);
        List<Article> articles = articleService.listArticles(article, page);
        System.out.println(articles);
        return Result.success(articles);
    }

    @GetMapping("/search")
    @FastJsonView(
            exclude = {
                    @FastJsonFilter(clazz = Article.class, props = {"body", "category", "comments"})})
    @LogAnnotation(module = "搜索", operation = "搜索")
    public Result searchArticles(SearchVo search, PageVo page) {
        System.out.println(page);
        System.out.println("search:"+search.toString());
        Map<String,Object> map=articleService.search(search,page);
        return Result.success(map);
    }

    @GetMapping("/hot")
    @FastJsonView(include = {@FastJsonFilter(clazz = Article.class, props = {"id", "title"})})
    @LogAnnotation(module = "文章", operation = "获取最热文章")
    public Result listHotArticles() {
        int limit = 6;
        List<Article> articles = articleService.listHotArticles(limit);

        return Result.success(articles);
    }

    @GetMapping("/new")
    @FastJsonView(include = {@FastJsonFilter(clazz = Article.class, props = {"id", "title"})})
    @LogAnnotation(module = "文章", operation = "获取最新文章")
    public Result listNewArticles() {
        int limit = 6;
        List<Article> articles = articleService.listNewArticles(limit);

        return Result.success(articles);
    }


    @GetMapping("/{id}")
    @FastJsonView(
            exclude = {
                    @FastJsonFilter(clazz = Article.class, props = {"comments"}),
                    @FastJsonFilter(clazz = Articlebody.class, props = {"contentHtml"})})
    @LogAnnotation(module = "文章", operation = "根据id获取文章")
    public Result getArticleById(@PathVariable("id") Integer id) {

        Result r = new Result();

        if (null == id) {
            r.setResultCode(ResultCode.PARAM_IS_BLANK);
            return r;
        }

        Article article = articleService.getArticleById(id);

        r.setResultCode(ResultCode.SUCCESS);
        r.setData(article);
        return r;
    }

    @GetMapping("/view/{id}")
    @FastJsonView(
            exclude = {
                    @FastJsonFilter(clazz = Article.class, props = {"comments"}),
                    @FastJsonFilter(clazz = Articlebody.class, props = {"contentHtml"}),
                    @FastJsonFilter(clazz = Tag.class, props = {"avatar"})},
            include = {@FastJsonFilter(clazz = User.class, props = {"id", "nickname", "avatar"})})
    @LogAnnotation(module = "文章", operation = "根据id获取文章，添加阅读数")
    public Result getArticleAndAddViews(@PathVariable("id") Integer id) {

        Result r = new Result();

        if (null == id) {
            r.setResultCode(ResultCode.PARAM_IS_BLANK);
            return r;
        }

        Article article = articleService.getArticleAndAddViews(id);

        r.setResultCode(ResultCode.SUCCESS);
        r.setData(article);
        return r;
    }

    @GetMapping("/tag/{id}")
    @FastJsonView(
            exclude = {
                    @FastJsonFilter(clazz = Article.class, props = {"body", "category", "comments"}),
                    @FastJsonFilter(clazz = Tag.class, props = {"id", "avatar"})},
            include = {@FastJsonFilter(clazz = User.class, props = {"nickname"})})
    @LogAnnotation(module = "文章", operation = "根据标签获取文章")
    public Result listArticlesByTag(@PathVariable Integer id) {
        List<Article> articles = articleService.listArticlesByTag(id);

        return Result.success(articles);
    }


    @GetMapping("/category/{id}")
    @FastJsonView(
            exclude = {
                    @FastJsonFilter(clazz = Article.class, props = {"body", "category", "comments"}),
                    @FastJsonFilter(clazz = Tag.class, props = {"id", "avatar"})},
            include = {@FastJsonFilter(clazz = User.class, props = {"nickname"})})
    @LogAnnotation(module = "文章", operation = "根据分类获取文章")
    public Result listArticlesByCategory(@PathVariable Integer id) {
        List<Article> articles = articleService.listArticlesByCategory(id);

        return Result.success(articles);
    }

    @PostMapping("/publish")
    @RequiresAuthentication
    @LogAnnotation(module = "文章", operation = "发布文章")
    public Result saveArticle(@Validated @RequestBody Article article) {
        Integer articleId = articleService.publishArticle(article);

        Result r = Result.success();
        r.simple().put("articleId", articleId);
        return r;
    }

    @PostMapping("/update")
    @RequiresRoles(Base.ROLE_ADMIN)
    @LogAnnotation(module = "文章", operation = "修改文章")
    public Result updateArticle(@RequestBody Article article) {
        Result r = new Result();

        if (null == article.getId()) {
            r.setResultCode(ResultCode.USER_NOT_EXIST);
            return r;
        }

        Integer articleId = articleService.updateArticle(article);

        r.setResultCode(ResultCode.SUCCESS);
        r.simple().put("articleId", articleId);
        return r;
    }

    @GetMapping("/delete/{id}")
    @RequiresRoles(Base.ROLE_ADMIN)
    @LogAnnotation(module = "文章", operation = "删除文章")
    public Result deleteArticleById(@PathVariable("id") Integer id) {
        Result r = new Result();

        if (null == id) {
            r.setResultCode(ResultCode.PARAM_IS_BLANK);
            return r;
        }

        articleService.deleteArticleById(id);

        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }

    @GetMapping("/listArchives")
    @LogAnnotation(module = "文章", operation = "获取文章归档日期")
    public Result listArchives() {
        return Result.success(articleService.listArchives());
    }

    @GetMapping("/isLike/{id}")
    @LogAnnotation(module = "点赞", operation = "获取是否点赞")
    public Result isLike(@PathVariable("id") Integer id) {
        return Result.success(likeService.isLike(id));
    }

    @GetMapping("/addLike/{id}")
    @LogAnnotation(module = "点赞", operation = "点赞")
    public Result addLike(@PathVariable("id") Integer id) {
        Result r = new Result();

        if (null == id) {
            r.setResultCode(ResultCode.PARAM_IS_BLANK);
            return r;
        }
        likeService.addLike(id);
        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }

    @GetMapping("/cancelLike/{id}")
    @LogAnnotation(module = "点赞", operation = "取消点赞")
    public Result cancelLike(@PathVariable("id") Integer id) {
        Result r = new Result();

        if (null == id) {
            r.setResultCode(ResultCode.PARAM_IS_BLANK);
            return r;
        }
        likeService.cancelLike(id);
        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }

    @GetMapping("/isCollect/{id}")
    @LogAnnotation(module = "收藏", operation = "获取是否收藏")
    public Result isCollect(@PathVariable("id") Integer id) {
        return Result.success(collectService.isCollect(id));
    }

    @GetMapping("/getCollects")
    @LogAnnotation(module = "收藏", operation = "获取收藏夹")
    public Result getCollects() {
        List<Collect> collects=collectService.getCollects();
        return Result.success(collects);
    }

    @GetMapping("/addCollect")
    @LogAnnotation(module = "收藏", operation = "收藏")
    public Result addCollect( Integer collectId,Integer articleId) {
        return Result.success(collectService.addCollect(collectId,articleId));
    }

    @GetMapping("/cancelCollect")
    @LogAnnotation(module = "收藏", operation = "取消收藏")
    public Result cancelCollect( Integer collectId,Integer articleId) {
        return Result.success(collectService.cancelCollect(collectId,articleId));
    }

    @GetMapping("/newCollects/{title}")
    @LogAnnotation(module = "收藏", operation = "取消收藏")
    public Result newCollects( @PathVariable("title") String title) {
        return Result.success(collectService.newCollects(title));
    }

    @GetMapping("/getCollect/{id}")
    @LogAnnotation(module = "收藏", operation = "根据Id获取收藏夹")
    public Result getCollect(@PathVariable("id") Integer id) {

        return Result.success(collectService.getCollect(id));
    }

    @GetMapping("/deleteCollect/{id}")
    @LogAnnotation(module = "收藏", operation = "根据Id获取收藏夹")
    public Result deleteCollect(@PathVariable("id") Integer id) {

        return Result.success(collectService.deleteCollect(id));
    }

    @GetMapping("/doFollow")
    @LogAnnotation(module = "关注", operation = "关注")
    public Result doFollow(FollowVo follow) {

        Boolean result=collectService.doFollow(follow);
        return Result.success(result);
    }

    @GetMapping("/cancelFollow")
    @LogAnnotation(module = "关注", operation = "取消关注")
    public Result cancelFollow(FollowVo follow) {
        Boolean result=collectService.cancelFollow(follow);
        return Result.success(result);
    }

    @GetMapping("/checkFollow")
    @LogAnnotation(module = "关注", operation = "获取关注信息")
    public Result checkFollow(FollowVo follow) {
        Boolean result=collectService.checkFollow(follow);
        return Result.success(result);
    }

    @GetMapping("/getFollow/{id}")
    @LogAnnotation(module = "关注", operation = "获取关注了")
    public Result getFollow(@PathVariable("id") Integer id) {
        return Result.success(collectService.getFollow(id));
    }

    @GetMapping("/getauthors/{id}")
    @LogAnnotation(module = "关注", operation = "获取关注者")
    public Result getauthors(@PathVariable("id") Integer id) {
        return Result.success(collectService.getauthors(id));
    }
}
