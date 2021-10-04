package com.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.annotation.Annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.controllers.APIController;

@SpringBootTest
class SpringBootUnitIntegrationTestingApplicationTests {
	
	@Autowired
	APIController controller;
	
	@Autowired
	APIController controller2;

	@Test
	@DisplayName("APIControlled class must be instantiated as singleon")
	void controllerExistsAndAutowired() {
		 assertNotNull(controller);
		 assertNotNull(controller2);
		 assertEquals(controller, controller2);
		 
	}
	
	@Test
	@DisplayName("Asserting whether it is RestController and has root path specified")
	public void decoratedCorrectly() {
		Class api=APIController.class;
		Annotation []list =api.getAnnotations();
		
		assertEquals(list.length, 2);
		assertEquals(list[0].annotationType().getSimpleName(),"RestController");
		assertEquals(list[1].annotationType().getSimpleName(),"RequestMapping");
	
	}
	 
     
}
