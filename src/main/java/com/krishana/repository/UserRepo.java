package com.krishana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishana.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
