package com.lijin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.lijin.mapper.ArticleMapper;
import com.lijin.mapper.CommentMapper;
import com.lijin.mapper.UserMapper;
import com.lijin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lijin.common.util.UserUtils;
import com.lijin.pojo.Article;
import com.lijin.pojo.Comment;
import com.lijin.service.CommentService;

/**
 * @author lijin
 * <p>
 * 2018年1月25日
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<Comment> findAll() {
        List<Comment> comments = commentMapper.selectByExample(null);
        for(Comment comment:comments){
            comment=makeComment(comment);
        }
        return comments;
    }

    @Override
    public Comment getCommentById(Integer id) {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        comment=makeComment(comment);
        return comment;
    }

    @Override
    @Transactional
    public Integer saveComment(Comment comment) {
        commentMapper.save(comment);
        Article article = articleMapper.selectByPrimaryKey(comment.getArticleId());
        article.setCommentCounts(article.getCommentCounts()+1);
        articleMapper.addCommentCounts(article);
        return comment.getId();
    }

    @Override
    @Transactional
    public void deleteCommentById(Integer id) {
        commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Comment> listCommentsByArticle(Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("level","0");
        List<Comment> comments = commentMapper.findByArticleAndLevelOrderByCreateDateDesc(map);

        for(Comment comment:comments){
            comment=makeComment(comment);
            System.out.println("comment:"+comment.toString());
        }
        return comments;
    }

    @Override
    @Transactional
    public Comment saveCommentAndChangeCounts(Comment comment) {

        int count = 1;
        Article a = articleMapper.selectByPrimaryKey(comment.getArticle().getId());
        a.setCommentCounts(a.getCommentCounts() + count);
        articleMapper.addCommentCounts(a);
        comment.setAuthor(UserUtils.getCurrentUser());
        comment.setCreateDate(new Date());
        //设置level
        if(null == comment.getParent()){
            comment.setLevel("0");
        }else{
            if(null == comment.getToUser()){
                comment.setLevel("1");
            }else{
                comment.setLevel("2");
            }
        }
        commentMapper.save(comment);
        return comment;

    }

    @Override
    @Transactional
    public void deleteCommentByIdAndChangeCounts(Integer id) {
        int count = 1;
        Comment c = commentMapper.selectByPrimaryKey(id);
        Article a = c.getArticle();

        a.setCommentCounts(a.getCommentCounts() - count);

        commentMapper.deleteByPrimaryKey(c.getId());
    }

    public Comment makeComment(Comment comment){
        Integer articleId = comment.getArticleId();
        Article article = articleMapper.selectByPrimaryKey(articleId);
        comment.setArticle(article);
        Long authorId = comment.getAuthorId();
        User author = userMapper.selectByPrimaryKey(authorId);
        comment.setAuthor(author);
        Integer parentId = comment.getParentId();
        Comment parent = commentMapper.selectByPrimaryKey(parentId);
        comment.setParent(parent);
        User toUser = userMapper.selectByPrimaryKey(comment.getToUid());
        comment.setToUser(toUser);
        List<Comment> childrens=new ArrayList<>();
        if(comment.getLevel().equals("0")){
            childrens = commentMapper.findChildrens(comment.getId());
            System.out.println("childrens:"+childrens);
            for(Comment children:childrens){
                makeComment(children);
            }
        }
        comment.setChildrens(childrens);
        return comment;
    }


}
