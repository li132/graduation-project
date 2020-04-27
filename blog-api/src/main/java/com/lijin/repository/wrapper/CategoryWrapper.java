package com.lijin.repository.wrapper;

import java.util.List;

import com.lijin.vo.CategoryVO;

/**
 * @author lijin
 * <p>
 * 2018年1月25日
 */
public interface CategoryWrapper {

    List<CategoryVO> findAllDetail();

    CategoryVO getCategoryDetail(Integer categoryId);
}
