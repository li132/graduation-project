package com.lijin.mapper;

import com.lijin.pojo.Articlebody;
import com.lijin.pojo.ArticlebodyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticlebodyMapper {
    int countByExample(ArticlebodyExample example);

    int deleteByExample(ArticlebodyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Articlebody record);

    int insertSelective(Articlebody record);

    List<Articlebody> selectByExampleWithBLOBs(ArticlebodyExample example);

    List<Articlebody> selectByExample(ArticlebodyExample example);

    Articlebody selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Articlebody record, @Param("example") ArticlebodyExample example);

    int updateByExampleWithBLOBs(@Param("record") Articlebody record, @Param("example") ArticlebodyExample example);

    int updateByExample(@Param("record") Articlebody record, @Param("example") ArticlebodyExample example);

    int updateByPrimaryKeySelective(Articlebody record);

    int updateByPrimaryKeyWithBLOBs(Articlebody record);
}