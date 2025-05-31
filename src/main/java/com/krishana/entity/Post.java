package com.krishana.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.krishana.dto.CategoryDto;
import com.krishana.dto.UserDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Post_Id")
	private Integer id;
	
	@Column(name = "Post_Title")
	private String postTitle;
	
	@Column(name = "Post_Content")
	private String postContent;
	
	@Column(name = "Post_Image")
	private String postImage;
	
	@Column(name = "Post_NewDate")
	private Date newDate;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "post" , cascade = CascadeType.ALL)
	private Set<Comment> comment = new HashSet<Comment>();

}
