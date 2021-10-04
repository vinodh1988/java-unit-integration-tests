package com.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.controllers.APIController;
import com.api.services.IDataService;

@SpringBootTest
public class FlowIntegrationTests {
   @Autowired
   APIController first;
   
   @Autowired
   IDataService data;
   
   @Test
   @DisplayName("Testing People Function")
   public void getPeopleTest() {
	  assertThat(first.people()).hasSizeGreaterThanOrEqualTo(1);
   }
}
