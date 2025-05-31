package com.krishana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishana.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
