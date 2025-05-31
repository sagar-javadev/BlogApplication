package com.krishana.service;

import java.util.List;

import com.krishana.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(Integer id , UserDto userDto);
	
	UserDto getUserById(Integer id);
	
	List<UserDto> getAllUser();
	
	void deleteUser(Integer id);
}
