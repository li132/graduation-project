package com.lijin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lijin.entity.Article;
import com.lijin.entity.Comment;

/**
 * @author lijin
 * <p>
 * 2018年1月25日
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByArticleAndLevelOrderByCreateDateDesc(Article a, String level);


}
