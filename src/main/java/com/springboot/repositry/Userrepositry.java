package com.springboot.repositry;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Userdetails;



public interface Userrepositry extends JpaRepository<Userdetails,Long> {
	
	
	 Optional<Userdetails> findByUsername(String username);

	    boolean existsByEmail(String email);

	    Optional<Userdetails> findByUsernameOrEmail(String username, String email);


}
