package com.mockitocourse.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mockitocourse.data.api.ToDoServiceStub;
import com.mockitocourse.data.api.TodoService;

public class TodoBusinessImpStubTest {

	@Test
	public void test() {
		TodoService todoServiceStub = new ToDoServiceStub();
		TodoBusinessImp todoBusinessImp = new TodoBusinessImp(todoServiceStub);
		List<String> filteredTodos = todoBusinessImp.retreiveTodosRelatedToSpring("dummy");
		
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void test2() {
		TodoService todoServiceStub = new ToDoServiceStub();
		TodoBusinessImp todoBusinessImp = new TodoBusinessImp(todoServiceStub);
		List<String> filteredTodos = todoBusinessImp.retreiveTodosRelatedToSpring("dummy");
		
		assertEquals(0, filteredTodos.size());
	}

}
