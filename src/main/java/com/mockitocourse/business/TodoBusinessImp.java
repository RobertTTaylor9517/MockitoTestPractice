package com.mockitocourse.business;

import java.util.ArrayList;
import java.util.List;

import com.mockitocourse.data.api.TodoService;
//ToDoBusinessImp is the SUT

public class TodoBusinessImp {
	private TodoService todoService;

	public TodoBusinessImp(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	public List<String> retreiveTodosRelatedToSpring(String user){
		List<String> filteredTodos = new ArrayList<String>();
		List<String> todoStrings = todoService.retreiveTodos(user);
		for(String todo:todoStrings) {
			if(todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		
		return filteredTodos;
		
	}
	
	public void deleteTodosNotRelatedToSpring(String user){
		List<String> todoStrings = todoService.retreiveTodos(user);
		for(String todo:todoStrings) {
			if(todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}

		
	}
}
