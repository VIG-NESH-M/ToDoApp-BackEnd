package com.todo.app.service;

import java.util.List;

import com.todo.app.dto.TodoDto;
import com.todo.app.entity.Todo;

public interface ITodoService {

	Todo createTodo(TodoDto todo);
	Todo getTodo(int todoId);
	List<Todo> getAllTodo();
	String deleteTodo(int todoId);
}
