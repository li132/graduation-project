package com.lijin.mapper;

import com.lijin.pojo.Followtag;
import com.lijin.pojo.FollowtagExample;
import com.lijin.vo.FollowVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FollowtagMapper {
    int countByExample(FollowtagExample example);

    int deleteByExample(FollowtagExample example);

    int insert(Followtag record);

    int insertSelective(Followtag record);

    List<Followtag> selectByExample(FollowtagExample example);

    int updateByExampleSelective(@Param("record") Followtag record, @Param("example") FollowtagExample example);

    int updateByExample(@Param("record") Followtag record, @Param("example") FollowtagExample example);

    int find(FollowVo follow);

    void cancelFollow(FollowVo follow);

}