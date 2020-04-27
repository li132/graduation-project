package com.lijin.mapper;

import com.lijin.pojo.Tag;
import com.lijin.pojo.TagExample;
import com.lijin.vo.TagVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TagMapper {
    List<Tag> search(Map<String, Object> map);

    int countByExample(TagExample example);

    int deleteByExample(TagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagExample example);

    Tag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    List<TagVO> findAllDetail();

    TagVO getTagDetail(Integer tagId);

    List<Tag> listHotTagsByArticleUse(int limit);

    void save(Tag tag);

    List<Tag> getByArticleId(Integer id);
}