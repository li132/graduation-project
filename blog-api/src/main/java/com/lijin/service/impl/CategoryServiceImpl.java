package com.lijin.service.impl;

import java.util.List;

import com.lijin.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lijin.pojo.Category;
import com.lijin.repository.CategoryRepository;
import com.lijin.service.CategoryService;
import com.lijin.vo.CategoryVO;

/**
 * @author lijin
 * <p>
 * 2018年1月25日
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        return categoryMapper.selectByExample(null);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Integer saveCategory(Category category) {
        categoryMapper.save(category);
        return category.getId();
    }

    @Override
    @Transactional
    public Integer updateCategory(Category category) {
        categoryMapper.updateByPrimaryKey(category);
        return category.getId();
    }

    @Override
    @Transactional
    public void deleteCategoryById(Integer id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CategoryVO> findAllDetail() {
        return categoryMapper.findAllDetail();
    }

    @Override
    public CategoryVO getCategoryDetail(Integer categoryId) {
        return categoryMapper.getCategoryDetail(categoryId);
    }

}
