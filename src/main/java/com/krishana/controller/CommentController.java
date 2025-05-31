package com.krishana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krishana.dto.CommentDto;
import com.krishana.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService service;
	
	@PostMapping("comment/post/{postId}/user/{userId}")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto , @PathVariable Integer postId ,@PathVariable Integer UserId){
		
		CommentDto comment = service.createComment(commentDto, UserId, postId);
		
		return new ResponseEntity<CommentDto>(comment, HttpStatus.CREATED);
	}
	
	
	@GetMapping("comment/{commentId}")
	public ResponseEntity<CommentDto> getCommentById(@PathVariable Integer commentId){
		
		CommentDto commentById = service.getCommentById(commentId);
		return new ResponseEntity<CommentDto>(commentById, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("comment/{commentId}")
	public ResponseEntity<String> deleteCommentById(@PathVariable Integer commentId){
		
		service.deleteComment(commentId);
		
		return new ResponseEntity<String>("Comment Delete suddfully ", HttpStatus.OK);
	}
}
