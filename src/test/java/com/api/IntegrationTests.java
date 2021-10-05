package com.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.api.entity.Person;

@SpringBootTest(classes = SpringBootAPI.class , webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class IntegrationTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	@Order(1)
	public void testPeople() {
		Person[] p=restTemplate.getForObject("http://localhost:"+port+"/api/people", Person[].class);
		assertThat(p.length).isEqualTo(4);
		assertThat(p[1].getName()).isEqualTo("Gary");
	}
	
	@Test
	@Order(2)
	public void testInsert() {
		Person p=new Person(5,"Hussey","Kanpur");
		ResponseEntity<Person> out=restTemplate.postForEntity("http://localhost:"+port+"/api/people", p,Person.class);
        assertEquals(out.getStatusCodeValue(),201);
        
	}
}
