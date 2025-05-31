package com.krishana.entity;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_Id")
	private Integer id;
	
	@Column(name = "User_Name")
	private String name;
	
	@Column(name = "User_Email")
	private String email;
	
	@Column(name = "User_Password")
	private String password;
	
	@Column(name = "User_About")
	private String userAbout;

	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
	private List<Post> post = new ArrayList<Post>();
	
	@OneToMany
	private Set<Comment> com = new HashSet<Comment>();
	
	

}
