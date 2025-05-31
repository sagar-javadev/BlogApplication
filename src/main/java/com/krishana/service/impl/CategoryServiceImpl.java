package com.krishana.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishana.dto.CategoryDto;
import com.krishana.entity.Category;
import com.krishana.exception.ResourceNotFoundException;
import com.krishana.repository.CategoryRepo;
import com.krishana.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{

	@Autowired
	private CategoryRepo repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
	Category category = this.mapper.map(categoryDto, Category.class);
	
	Category category2 = repo.save(category);
		return this.mapper.map(category2, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
		
		Category category = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "id", id));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDecription(categoryDto.getCategoryDecription());
		
		Category category2 = repo.save(category);
		
		return this.mapper.map(category2, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategoryById(Integer id) {
		Category category = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "id", id));
		
		return this.mapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		
		List<Category> list = repo.findAll();
		List<CategoryDto> categoryList = list.stream().map((k) -> mapper.map(k, CategoryDto.class)).collect(Collectors.toList());
		return categoryList;
	}

	@Override
	public void deleteCategoryById(Integer id) {
		
		Category category = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "id", id));
		
		repo.deleteById(id);
		
		
	}

}
