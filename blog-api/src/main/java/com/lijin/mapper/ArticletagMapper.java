package com.lijin.mapper;

import com.lijin.pojo.Articletag;
import com.lijin.pojo.ArticletagExample;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface ArticletagMapper {
    int countByExample(ArticletagExample example);

    int deleteByExample(ArticletagExample example);

    int insert(Articletag record);

    int insertSelective(Articletag record);

    List<Articletag> selectByExample(ArticletagExample example);

    int updateByExampleSelective(@Param("record") Articletag record, @Param("example") ArticletagExample example);

    int updateByExample(@Param("record") Articletag record, @Param("example") ArticletagExample example);

}