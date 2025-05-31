package com.krishana.service;

import com.krishana.dto.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto ,Integer userId ,Integer postId);
	
	CommentDto getCommentById(Integer commentId);
	
	void deleteComment(Integer commentId);
}
