package com.mockitocourse.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mockitocourse.data.api.ToDoServiceStub;
import com.mockitocourse.data.api.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImpMockInjectionTest {
	
	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImp todoBusinessImp;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	
	@Test
	public void test() {
		
		
		List<String> todoStrings = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		
		when(todoServiceMock.retreiveTodos("dummy")).thenReturn(todoStrings);
		
		List<String> filteredTodos = todoBusinessImp.retreiveTodosRelatedToSpring("dummy");
		
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void test_usingBDD() {
		
		//Given
		
		
		List<String> todoStrings = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		
		given(todoServiceMock.retreiveTodos("dummy")).willReturn(todoStrings);
		
		//When
		List<String>filteredTodos = todoBusinessImp.retreiveTodosRelatedToSpring("dummy"); 
		
		//Then
		assertThat(filteredTodos.size(), is(2));
	}
	
	@Test
	public void deleteTest_usingBDD() {
		
		//Given
		
		
		List<String> todoStrings = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		
		given(todoServiceMock.retreiveTodos("dummy")).willReturn(todoStrings);
		
		//When
		todoBusinessImp.deleteTodosNotRelatedToSpring("dummy"); 
		
		//Then
		then(todoServiceMock).should().deleteTodo("Learn to Dance");
		
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
	}
	
	@Test
	public void deleteTest_usingBDDArgumentCapture() {
		//Declare Argument Captor
		
		//Given
		
		List<String> todoStrings = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		
		given(todoServiceMock.retreiveTodos("dummy")).willReturn(todoStrings);
		
		//When
		todoBusinessImp.deleteTodosNotRelatedToSpring("dummy"); 
		
		//Then
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getValue(), is("Learn To Dance"));
		
	}
	
	@Test
	public void deleteTest_usingBDDArgumentCaptureMultiple() {
		//Declare Argument Captor
		
		//Given
		
		List<String> todoStrings = Arrays.asList("Learn to Rock and Roll", "Learn Spring", "Learn to Dance");
		
		given(todoServiceMock.retreiveTodos("dummy")).willReturn(todoStrings);
		
		//When
		todoBusinessImp.deleteTodosNotRelatedToSpring("dummy"); 
		
		//Then
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
		
	}

}
