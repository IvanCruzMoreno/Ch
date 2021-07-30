package com.ivanmoreno.blogapp.repository;

public interface UserRepository extends CustomRepository<User, Long> {
	
	void deleteByUsername(String username);

}
