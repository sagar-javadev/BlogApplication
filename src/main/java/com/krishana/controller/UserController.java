package com.krishana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishana.dto.UserDto;
import com.krishana.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser( @Valid @RequestBody UserDto userDto) {

		UserDto user = service.createUser(userDto);
		return new ResponseEntity<UserDto>(user, HttpStatus.CREATED);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<UserDto> updateUser( @Valid @PathVariable Integer id, @RequestBody UserDto userDto) {

		UserDto updateUser = service.updateUser(id, userDto);

		return new ResponseEntity<UserDto>(updateUser, HttpStatus.ACCEPTED);

	}

	@GetMapping("userId /{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {

		UserDto userById = service.getUserById(id);
		return new ResponseEntity<UserDto>(userById, HttpStatus.OK);
	}

	@GetMapping("allUser")
	public ResponseEntity<List<UserDto>> getAllUser() {

		List<UserDto> allUser = service.getAllUser();

		return new ResponseEntity<List<UserDto>>(allUser, HttpStatus.OK);
	}

	@DeleteMapping("deleteUserById/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Integer id) {

		service.deleteUser(id);

		return new ResponseEntity<String>("User Delete Sussfully with Given Id ", HttpStatus.OK);
	}

}
