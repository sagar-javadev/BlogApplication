package com.krishana.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krishana.dto.PostDto;
import com.krishana.entity.Category;
import com.krishana.entity.Post;
import com.krishana.entity.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByCategory(Category category);
	
	List<Post> findByUser(User user);
	
	List<Post> findByPostContent(String postContent);
}
