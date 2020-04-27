package com.lijin.mapper;

import com.lijin.pojo.Follow;
import com.lijin.pojo.FollowExample;
import com.lijin.pojo.User;
import com.lijin.vo.FollowVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FollowMapper {
    int countByExample(FollowExample example);

    int deleteByExample(FollowExample example);

    int insert(Follow record);

    int insertSelective(Follow record);

    List<Follow> selectByExample(FollowExample example);

    int updateByExampleSelective(@Param("record") Follow record, @Param("example") FollowExample example);

    int updateByExample(@Param("record") Follow record, @Param("example") FollowExample example);

    int find(FollowVo follow);

    void cancelFollow(FollowVo follow);



}