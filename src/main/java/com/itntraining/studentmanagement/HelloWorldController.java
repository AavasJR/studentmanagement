package com.itntraining.studentmanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello")		//this helps the local host to identify the method
	public String helloWorld() {		//making a method that returns helloworld
		return "Hello World";
	}

	
}
