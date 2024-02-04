package com.springboot.service.TodoServiceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dto.TodoDto;
import com.springboot.entity.Todo;
import com.springboot.repositry.Todorepositry;
import com.springboot.service.TodoService;
@Service
public class Serviceimpl implements TodoService {
	
	@Autowired
private	Todorepositry tr;
	@Autowired
	ModelMapper mapper;

	@Override
	public Todo createTodo(Todo t) {
		
		
		Todo todo=new Todo();
		
		todo.setTask(t.getTask());
		
		todo.setStatus(t.isStatus());
		
		Todo saved= tr.save(todo);
		
		
		return saved;
		
		
		
		
		
	}

	@Override
	public TodoDto gettodo(Long id) {
	
		
		Todo t=tr.findById(id).get();
		
		TodoDto dto=mapper.map(t, TodoDto.class);
		
		return dto;
		
		
		
		
	}

	@Override
	public List<TodoDto> getall() {
		
		List<Todo> t=tr.findAll();
		List<TodoDto> dto=new ArrayList();
		
		for (Todo todo : t) {
			
			dto.add(mapper.map(todo,TodoDto.class));
			
		}
		return dto;
	}
	@Override
	public Todo updatetodo(Todo t) {
		
		
		Todo todo=tr.findById(t.getId()).get();
		
	
		todo.setTask(t.getTask());
		
		todo.setStatus(t.isStatus());
		
		Todo saved= tr.save(todo);
		
		
		return saved;
		
		
		
		
		
	}

	@Override
	public void deletetodo(Long id) {
		
		Todo t=tr.findById(id).get();
		tr.delete(t);
		
		
		
	}

	@Override
	public Todo completetodo(Long id) {
	
		
		Todo t=tr.findById(id).get();
		t.setStatus(true);
		
		return t;
	}

	@Override
	public Todo incompletetodo(Long id) {
		Todo t=tr.findById(id).get();
		t.setStatus(false);
		
		return t;
	}

}
