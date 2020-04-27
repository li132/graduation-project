package com.lijin.mapper;

import com.lijin.pojo.Collectarticle;
import com.lijin.pojo.CollectarticleExample;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface CollectarticleMapper {
    int countByExample(CollectarticleExample example);

    int deleteByExample(CollectarticleExample example);

    int insert(Collectarticle record);

    int insertSelective(Collectarticle record);

    List<Collectarticle> selectByExample(CollectarticleExample example);

    int updateByExampleSelective(@Param("record") Collectarticle record, @Param("example") CollectarticleExample example);

    int updateByExample(@Param("record") Collectarticle record, @Param("example") CollectarticleExample example);

    List<Collectarticle> getByCollectId(Integer collectId);

    void cancel(HashMap<Object, Object> map);
}