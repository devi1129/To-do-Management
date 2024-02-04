package com.springboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.entity.Userdetails;

@SpringBootApplication
public class ToDoManagementApplication {
	
	@Bean	
   public ModelMapper map()
   {
		return new ModelMapper();
   }

	public static void main(String[] args) {
		SpringApplication.run(ToDoManagementApplication.class, args);
		
	
	}

}
