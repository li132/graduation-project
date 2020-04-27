package com.lijin.mapper;

import com.lijin.pojo.Article;
import com.lijin.pojo.Comment;
import com.lijin.pojo.CommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CommentMapper {
    int countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    int save(Comment comment);

    List<Comment> findByArticleAndLevelOrderByCreateDateDesc(HashMap<String, Object> map);

    List<Comment> getByArticleId(Integer id);

    List<Comment> findChildrens(Integer id);
}