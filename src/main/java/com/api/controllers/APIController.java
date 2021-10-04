package com.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {
	
   @GetMapping("/greet")
   public String greet() {
      return "Spring boot is working";
   }
      
}
