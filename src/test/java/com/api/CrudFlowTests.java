package com.api;



import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.entity.Person;
import com.api.repository.PeopleRepository;
import com.api.services.DataService;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CrudFlowTests {
  
	@InjectMocks
	DataService data;
	
	@Mock
	PeopleRepository people;
	
	public static int  testCount;
    static List<Person> list=new ArrayList<Person>();
	
	public void mock() {
		System.out.println("inside"+testCount);

	

		doReturn(null).when(people).findBySno(any(Integer.class));
	    
	    doAnswer(x->{
	    	
	    	list.add(x.getArgument(0));
	    	System.out.println(list);
	    	return null;
	    }).when(people).save(any(Person.class));
	}
	
	@ParameterizedTest
	@DisplayName("Data Driven Test")
	@CsvFileSource(resources = "/sample.csv",numLinesToSkip = 1)
	public void controlTest(Integer sno, String name,String city) {
	
		testCount++;
		mock();
		System.out.println(testCount);
	

			assertDoesNotThrow(()->data.addPerson(new Person(sno,name,city)));
	}
	
	@Test
	public void Test() {
		assertEquals(list.size(), 5);
	}
}
