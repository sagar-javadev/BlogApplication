
package com.krishana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishana.dto.PageResponse;
import com.krishana.dto.PostDto;
import com.krishana.service.PostService;
import com.krishana.utils.ApiResponse;

@RestController
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("post/userId/{userId}/categoryId/{categoryId}")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {

		PostDto post = postService.createPost(userId, categoryId, postDto);

		return new ResponseEntity<PostDto>(post, HttpStatus.CREATED);
	}

	@PutMapping("postId/{id}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer id) {

		PostDto updatePost = postService.updatePost(id, postDto);

		return new ResponseEntity<PostDto>(updatePost, HttpStatus.ACCEPTED);
	}

	@GetMapping("post/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer id) {

		PostDto postById = postService.getPostById(id);

		return new ResponseEntity<PostDto>(postById, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<PageResponse> getAllPost(
			@RequestParam(value ="pageNumber" ,defaultValue = "0 ", required = false )Integer pageNumber ,
			@RequestParam(value = "pageSize" , defaultValue = "5", required = false) Integer pageSize
			
			) {

		 PageResponse allPost = (PageResponse) postService.getAllPost(pageNumber, pageSize);

		return new ResponseEntity<PageResponse>(allPost, HttpStatus.OK);
	}

	@DeleteMapping("deletePostById/{id}")
	public ResponseEntity<ApiResponse> deletePostById(@PathVariable Integer id) {

		postService.deleteById(id);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Post Delete Sussfully ", true), HttpStatus.OK);
	}

	@GetMapping("postGetByUser/{userId}")
	public ResponseEntity<List<PostDto>> postGetByUser(@PathVariable Integer userId) {

		List<PostDto> postByUser = postService.getPostByUser(userId);

		return new ResponseEntity<List<PostDto>>(postByUser, HttpStatus.OK);
	}

	@GetMapping("postGetByCategory/{categoryId}")
	public ResponseEntity<List<PostDto>> postGetByCategory(@PathVariable Integer categoryId) {

		List<PostDto> categroy = postService.getPostByCategroy(categoryId);

		return new ResponseEntity<List<PostDto>>(categroy, HttpStatus.OK);	}
	
	
}
