package com.mockitocourse.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void mockListSize() {
		List listMockList = mock(List.class);
		when(listMockList.size()).thenReturn(2);
		
		assertEquals(2, listMockList.size());
	}
	
	@Test
	public void mockListSize_ReturnMultiple() {
		List listMockList = mock(List.class);
		when(listMockList.size()).thenReturn(2).thenReturn(3);
		
		assertEquals(2, listMockList.size());
		assertEquals(3, listMockList.size());
	}
	
	@Test
	public void mockListGet() {
		List listMockList = mock(List.class);
		//Argument Matcher
		when(listMockList.get(anyInt())).thenReturn("in28Min");
		
		assertEquals("in28Min", listMockList.get(0));
		assertEquals("in28Min", listMockList.get(1));
		
	}
	
	@Test
	public void mockListGet_usingBDD() {
		//Given
		List<String> mockList = mock(List.class);
		given(mockList.get(anyInt())).willReturn("in28Min");
		
		//When
		String firstElement = mockList.get(0);
		
		//Then
		assertThat(firstElement, is("in28Min"));
		
	}
	
	@Test(expected = RuntimeException.class)
	public void mockList_throwAnException() {
		List listMockList = mock(List.class);
		//Argument Matcher
		when(listMockList.get(anyInt())).thenThrow(new RuntimeException("Something"));
		
		listMockList.get(0);
	}
	
	@Test(expected = RuntimeException.class)
	public void mockList_mixingUp() {
		List listMockList = mock(List.class);
		//Argument Matcher
		when(listMockList.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something"));
		
		listMockList.get(0);
	}

}
