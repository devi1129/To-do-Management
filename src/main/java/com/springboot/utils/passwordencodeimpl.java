package com.springboot.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class passwordencodeimpl {

	public static void main(String[] args) {

		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	        System.out.println(passwordEncoder.encode("devi"));

	        System.out.println(passwordEncoder.encode("durga"));
	        
	        System.out.println(passwordEncoder.encode("durgadevi"));
	        System.out.println(passwordEncoder.encode("john"));

	}

}
