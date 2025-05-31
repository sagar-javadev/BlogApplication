package com.krishana.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.krishana.dto.PageResponse;
import com.krishana.dto.PostDto;
import com.krishana.entity.Category;
import com.krishana.entity.Post;
import com.krishana.entity.User;
import com.krishana.exception.ResourceNotFoundException;
import com.krishana.repository.CategoryRepo;
import com.krishana.repository.PostRepository;
import com.krishana.repository.UserRepo;
import com.krishana.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(Integer userId, Integer categoryId, PostDto postDto) {

		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

		Post post = this.mapper.map(postDto, Post.class);
		post.setCategory(category);
		post.setUser(user);
		post.setPostImage("default.img");
		post.setNewDate(new Date());

		Post postSave = postRepository.save(post);

		return this.mapper.map(postSave, PostDto.class);
	}

	@Override
	public PostDto updatePost(Integer id, PostDto postDto) {

		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

		post.setPostTitle(postDto.getPostTitle());
		post.setPostContent(postDto.getPostContent());
		post.setPostImage("deafult.img");
		//post.setCategory(postDto);
		post.setNewDate(new Date());

		Post post2 = postRepository.save(post);
		return this.mapper.map(post2, PostDto.class);
	}

	@Override
	public PostDto getPostById(Integer id) {

		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		return this.mapper.map(post, PostDto.class);
	}

	@Override
	public PageResponse getAllPost(Integer pageNumber , Integer pageSize ) {
		
		PageRequest of = PageRequest.of(pageNumber, pageSize);

		 Page<Post> page = postRepository.findAll(of);
		 List<Post> list = page.getContent();
		List<PostDto> list2 = list.stream().map((g) -> mapper.map(g, PostDto.class)).collect(Collectors.toList());
		
		PageResponse page2 = new PageResponse();
		
		page2.setContent(list2);
		page2.setPageNumber(of.getPageNumber());
		page2.setPageSize(of.getPageSize());
		page2.setTotalElements(page.getTotalElements());
		page2.setLastPage(page.isLast());
		return page2;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {

		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		 List<Post> user2 = postRepository.findByUser(user);
		List<PostDto> list = user2.stream().map((s) -> mapper.map(s, PostDto.class)).collect(Collectors.toList());

		return list;
	}

	@Override
	public List<PostDto> getPostByCategroy(Integer categoryId) {

		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

	 List<Post> category2 = postRepository.findByCategory(category);
		List<PostDto> list = category2.stream().map((s) -> mapper.map(s, PostDto.class)).collect(Collectors.toList());
		return list;
	}

	@Override
	public void deleteById(Integer id) {

		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

		postRepository.deleteById(id);

	}

	@Override
	public List<PostDto> getPostSearch(String keyword) {

		 List<Post> postContent = postRepository.findByPostContent(keyword);
		List<PostDto> list = postContent.stream().map((a) -> mapper.map(a, PostDto.class)).collect(Collectors.toList());
		return list;
	}

}
