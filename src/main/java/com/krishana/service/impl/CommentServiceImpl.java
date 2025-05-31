package com.krishana.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishana.dto.CommentDto;
import com.krishana.entity.Comment;
import com.krishana.entity.Post;
import com.krishana.entity.User;
import com.krishana.exception.ResourceNotFoundException;
import com.krishana.repository.CommentRepository;
import com.krishana.repository.PostRepository;
import com.krishana.repository.UserRepo;
import com.krishana.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepo userRepo;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer userId, Integer postId) {

		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));

		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

		Comment comment = this.mapper.map(commentDto, Comment.class);
		comment.setPost(post);
		comment.setUser(user);
		Comment comment2 = commentRepository.save(comment);

		return this.mapper.map(comment2, CommentDto.class);
	}

	@Override
	public CommentDto getCommentById(Integer commentId) {

		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));

		return this.mapper.map(comment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment comment = commentRepository.findById(commentId).get();

		commentRepository.deleteById(commentId);

	}

}
