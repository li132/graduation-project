package com.lijin.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lijin.BlogApiApplicationTests;
import com.lijin.repository.CategoryRepository;

public class CategoryRepositoryTest extends BlogApiApplicationTests{

	@Autowired
	private CategoryRepository	categoryRepository;

	@Test
	public void test() {
	}
}
