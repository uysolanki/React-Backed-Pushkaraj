package com.react.reactbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyRestController {

	@GetMapping("/test")
	public String test() {
		return "Apple";
	}
	
	@GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<>("Hello, World!", HttpStatus.NOT_FOUND);
    }
}
