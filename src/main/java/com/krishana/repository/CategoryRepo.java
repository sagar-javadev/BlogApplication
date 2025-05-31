package com.krishana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishana.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
