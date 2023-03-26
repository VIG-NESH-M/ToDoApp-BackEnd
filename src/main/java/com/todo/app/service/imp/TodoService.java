package com.todo.app.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.app.dto.TodoDto;
import com.todo.app.entity.Todo;
import com.todo.app.repo.TodoRepository;
import com.todo.app.service.ITodoService;

@Service
public class TodoService implements ITodoService {
	
	@Autowired
	private TodoRepository todoRepo;

	@Override
	public Todo createTodo(TodoDto todo) {
		return todoRepo.save(new Todo(todo.getId(),todo.getList()));
	}

	@Override
	public Todo getTodo(int todoId) {
		var todoOpt = todoRepo.findById(todoId);
		if(todoOpt.isEmpty()) {
			System.out.println("Id is invalid");
		}
		return todoOpt.get();
	}

	@Override
	public List<Todo> getAllTodo() {
		var todo  = todoRepo.findAll();
		if(todo.isEmpty()) {
			System.out.println("Todo list is empty");
		}
		return todo;
	}

	@Override
	public String deleteTodo(int todoId) {
		var todo = todoRepo.findById(todoId);
		if(todo.isEmpty()) {
			System.out.println("TodoId is Invalid");
		}
		todoRepo.deleteById(todoId);
		return "Todo "+ todoId +" deleted successfully" ;
	}

}
