package com.lijin.mapper;

import com.lijin.pojo.Articlelike;
import com.lijin.pojo.ArticlelikeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
@Component
public interface ArticlelikeMapper {
    int countByExample(ArticlelikeExample example);

    int deleteByExample(ArticlelikeExample example);

    int insert(Articlelike record);

    int insertSelective(Articlelike record);

    List<Articlelike> selectByExample(ArticlelikeExample example);

    int updateByExampleSelective(@Param("record") Articlelike record, @Param("example") ArticlelikeExample example);

    int updateByExample(@Param("record") Articlelike record, @Param("example") ArticlelikeExample example);

    Articlelike isLike(HashMap<String, Object> map);

    void cancelLike(HashMap<String, Object> map);
}