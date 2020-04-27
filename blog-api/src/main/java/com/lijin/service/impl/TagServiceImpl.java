package com.lijin.service.impl;

import java.util.List;

import com.lijin.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lijin.pojo.Tag;
import com.lijin.repository.TagRepository;
import com.lijin.service.TagService;
import com.lijin.vo.TagVO;

/**
 * @author lijin
 * <p>
 * 2018年1月25日
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> findAll() {
        return tagMapper.selectByExample(null);
    }

    @Override
    public Tag getTagById(Integer id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Integer saveTag(Tag tag) {
        tagMapper.save(tag);
        return tag.getId();
    }

    @Override
    @Transactional
    public Integer updateTag(Tag tag) {
        Tag oldTag = tagMapper.selectByPrimaryKey(tag.getId());

        oldTag.setTagname(tag.getTagname());
        oldTag.setAvatar(tag.getAvatar());
        tagMapper.updateByPrimaryKey(oldTag);
        return oldTag.getId();
    }

    @Override
    @Transactional
    public void deleteTagById(Integer id) {
        tagMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Tag> listHotTags(int limit) {

        return tagMapper.listHotTagsByArticleUse(limit);
    }

    @Override
    public List<TagVO> findAllDetail() {
        return tagMapper.findAllDetail();
    }

    @Override
    public TagVO getTagDetail(Integer tagId) {
        return tagMapper.getTagDetail(tagId);
    }
}
