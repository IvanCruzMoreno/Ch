package com.ivanmoreno.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivanmoreno.blogapp.model.jpa.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
