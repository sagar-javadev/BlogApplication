package com.krishana.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.krishana.dto.PageResponse;
import com.krishana.dto.PostDto;

public interface PostService {
	
	PostDto createPost( Integer userId , Integer categoryId ,PostDto postDto );
	
	PostDto updatePost(Integer id , PostDto postDto);
	
	PostDto getPostById(Integer id);
	
	PageResponse getAllPost (Integer pageNumber , Integer pageSize );
	
	List<PostDto> getPostByUser(Integer userId);
	
	List<PostDto> getPostByCategroy(Integer categoryId);
	
	void deleteById(Integer id);
	
	List<PostDto> getPostSearch(String keyword);
  
}
