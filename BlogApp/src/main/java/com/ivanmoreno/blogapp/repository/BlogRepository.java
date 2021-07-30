package com.ivanmoreno.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivanmoreno.blogapp.model.jpa.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
