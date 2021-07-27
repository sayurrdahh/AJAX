package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.User;

@Controller
public class PageController {

	@RequestMapping(path="/main")
	public String main() {
		return "main.html";
	}
	
	//ResponseEntity
	@ResponseBody
	@GetMapping(path="/user")
	public User user() {
		var user = new User();
		user.setName("dahee");
		user.setAddress("패캠");
		return user;
	}
	
}
