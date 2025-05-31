package com.krishana.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishana.dto.UserDto;
import com.krishana.entity.User;
import com.krishana.exception.ResourceNotFoundException;
import com.krishana.repository.UserRepo;
import com.krishana.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepo userRepo;

	@Autowired
	public ModelMapper mapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User user2 = userRepo.save(user);
		return this.userTodto(user2);
	}

	@Override
	public UserDto updateUser(Integer id, UserDto userDto) {
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setUserAbout(userDto.getUserAbout());

		User user2 = userRepo.save(user);
		return this.userTodto(user2);
	}

	@Override
	public UserDto getUserById(Integer id) {

		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		return this.userTodto(user);
	}

	@Override
	public List<UserDto> getAllUser() {

		List<User> list = userRepo.findAll();
		List<UserDto> list2 = list.stream().map((k) -> userTodto(k)).collect(Collectors.toList());

		return list2;
	}

	@Override
	public void deleteUser(Integer id) {

		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		userRepo.deleteById(id);
	}

	public User dtoToUser(UserDto userDto) {
		return this.mapper.map(userDto, User.class);
	}

	public UserDto userTodto(User user) {
		return this.mapper.map(user, UserDto.class);
	}
}
