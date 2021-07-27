package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

@RestController
@RequestMapping(path="/api")
public class ApiController {
	
	//text
	@GetMapping(path="/text")
	public String text(@RequestParam String account) {
		return account;
	}
	
	//json
	@PostMapping(path="/json")
	public User json(@RequestBody User user) {
		return user;
	}
	
	@PutMapping(path="/put")
	public ResponseEntity<User> put(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	
}
