package com.krishana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krishana.dto.CategoryDto;
import com.krishana.service.CategoryService;
import com.krishana.utils.ApiResponse;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@PostMapping
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
		
		CategoryDto category = service.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(category, HttpStatus.CREATED);
	}
	
	@PutMapping("category/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto , @PathVariable Integer id){
		
		CategoryDto updateCategory = service.updateCategory(categoryDto, id);
		
		return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getCategoryById/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id){
		
		CategoryDto categoryById = service.getCategoryById(id);
		
		return new ResponseEntity<CategoryDto>(categoryById, HttpStatus.OK);
	}
	
	@GetMapping("getAllCategory")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		
		List<CategoryDto> allCategory = service.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(allCategory, HttpStatus.OK);
	}
	
	@DeleteMapping("categoryDeleteById/{id}")
	public ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable Integer id){
		
		service.deleteCategoryById(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Delete Sussfully ", true), HttpStatus.OK);
	}
}
