package com.mockitocourse.data.api;

import java.util.Arrays;
import java.util.List;

public class ToDoServiceStub implements TodoService {

	public List<String> retreiveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
	}

	public void deleteTodo(String todo) {
		
	}
}
