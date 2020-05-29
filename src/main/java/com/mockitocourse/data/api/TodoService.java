package com.mockitocourse.data.api;

import java.util.List;

//Create ToDoServiceStub
//Test ToDOBusiness
public interface TodoService {
	public List<String> retreiveTodos(String user);
	public void deleteTodo(String todo);
	
}
