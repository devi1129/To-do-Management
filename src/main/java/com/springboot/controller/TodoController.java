package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.TodoDto;
import com.springboot.entity.Todo;
import com.springboot.service.TodoService;

import jakarta.annotation.security.PermitAll;

@RestController
@RequestMapping("api/todo")
public class TodoController {
	
	@Autowired
	private TodoService ts;
	
	@PreAuthorize("hasRole('ROLE_admin')")
	@PostMapping("create")
	public ResponseEntity<Todo> createtodo(@RequestBody Todo t)
	{
		Todo savedtodo=ts.createTodo(t);
		
		return new ResponseEntity<>(savedtodo,HttpStatus.CREATED);
	}
	
	  
	@PreAuthorize("permitAll()")
	@GetMapping("get/{id}")
	public ResponseEntity<TodoDto> gettodo(@PathVariable Long id)
	{
		TodoDto dto=ts.gettodo(id);
		
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	@PreAuthorize("permitAll()")
	@GetMapping("getall")
	public ResponseEntity<List<TodoDto>> getall()
	{
		List<TodoDto> dto=ts.getall();
		
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	@PreAuthorize("hasAnyRole('ROLE_admin','ROLE_hr')")
	@PutMapping("update/{id}")
	public ResponseEntity<Todo> updatetodo(@RequestBody Todo t,@PathVariable Long id)
	{
		t.setId(id);
		Todo savedtodo=ts.updatetodo(t);
		
		return new ResponseEntity<>(savedtodo,HttpStatus.CREATED);
	}
	@PreAuthorize("hasAnyRole('ROLE_admin','ROLE_hr')")
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deletetodo(@PathVariable Long id)
	{
		ts.deletetodo(id);
		
		return new ResponseEntity<>("Todo deleted successfully",HttpStatus.OK);
	}
	@PreAuthorize("hasAnyRole('ROLE_admin','ROLE_hr')")
	@PatchMapping("complete/{id}")
	public ResponseEntity<Todo> completetodo(@PathVariable Long id)
	{
		
		Todo savedtodo=ts.completetodo(id);
		
		return new ResponseEntity<>(savedtodo,HttpStatus.CREATED);
	}
	@PreAuthorize("hasAnyRole('ROLE_admin','ROLE_hr')")
	@PatchMapping("incomplete/{id}")
	public ResponseEntity<Todo> incompletetodo(@PathVariable Long id)
	{
		
		Todo savedtodo=ts.incompletetodo(id);
		
		return new ResponseEntity<>(savedtodo,HttpStatus.CREATED);
	}
   
}
