package com.lijin.repository.wrapper;

import java.util.List;

import com.lijin.vo.TagVO;

/**
 * @author lijin
 * <p>
 * 2018年1月25日
 */
public interface TagWrapper {

    List<TagVO> findAllDetail();

    TagVO getTagDetail(Integer tagId);
}
