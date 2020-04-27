package com.lijin.mapper;

import com.lijin.pojo.Commentlike;
import com.lijin.pojo.CommentlikeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentlikeMapper {
    int countByExample(CommentlikeExample example);

    int deleteByExample(CommentlikeExample example);

    int insert(Commentlike record);

    int insertSelective(Commentlike record);

    List<Commentlike> selectByExample(CommentlikeExample example);

    int updateByExampleSelective(@Param("record") Commentlike record, @Param("example") CommentlikeExample example);

    int updateByExample(@Param("record") Commentlike record, @Param("example") CommentlikeExample example);
}