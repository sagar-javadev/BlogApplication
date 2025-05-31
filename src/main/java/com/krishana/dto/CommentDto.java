package com.krishana.dto;

import com.krishana.entity.Post;
import com.krishana.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDto {

	private Integer commentId;

	private String content;

	private Post post;

	private User user;
}
