package com.krishana.service;

import java.util.List;

import com.krishana.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	CategoryDto updateCategory(CategoryDto categoryDto , Integer id);
	
	CategoryDto getCategoryById(Integer id);
	
	List<CategoryDto> getAllCategory();
	
	void deleteCategoryById(Integer id);

}
