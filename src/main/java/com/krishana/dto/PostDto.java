package com.krishana.dto;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDto {

	private Integer id;

	private String postTitle;

	private String postContent;

	private String postImage;

	private Date newDate;

	private CategoryDto category;

	private UserDto user;
	
	

}
