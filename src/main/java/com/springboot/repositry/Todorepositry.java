package com.springboot.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Todo;

import jakarta.persistence.Id;

public interface Todorepositry extends JpaRepository<Todo, Long> {

}
