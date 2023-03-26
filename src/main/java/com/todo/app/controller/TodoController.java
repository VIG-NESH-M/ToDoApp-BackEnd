package com.todo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.dto.ApiResponseDto;
import com.todo.app.dto.TodoDto;
import com.todo.app.service.ITodoService;

@RestController
@RequestMapping("/todo")
@CrossOrigin("*")
public class TodoController {

	@Autowired
	private ITodoService todoService;
	
	@PostMapping("/save")
	public ResponseEntity<ApiResponseDto> createTodo(@RequestBody TodoDto todo){
		var response = new ApiResponseDto("1200", "Success", todoService.createTodo(todo));
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponseDto> getAllTodo(){
		var response = new ApiResponseDto("1200", "Success", todoService.getAllTodo());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@DeleteMapping("/{todoId}")
	public ResponseEntity<ApiResponseDto> deleteTodo(@PathVariable("todoId") int todoId){
		var response = new ApiResponseDto("1200","Success", todoService.deleteTodo(todoId));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}