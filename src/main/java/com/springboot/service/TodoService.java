package com.springboot.service;


import java.util.List;

import com.springboot.dto.TodoDto;
import com.springboot.entity.Todo;

public interface TodoService {
	
	
	
	Todo createTodo(Todo t);
    
	
	TodoDto gettodo(Long id);
	
	List<TodoDto> getall();
	
	Todo updatetodo(Todo t);
	
	void deletetodo(Long id);
	
	Todo completetodo(Long id);
	Todo incompletetodo(Long id);
	
}
