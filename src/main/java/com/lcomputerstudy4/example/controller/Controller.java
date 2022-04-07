package com.lcomputerstudy4.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.lcomputerstudy4.example.domain.User;

@org.springframework.stereotype.Controller
public class Controller {
	
//	@Autowired 
	
	@RequestMapping("/")
	public String home() {
		return "/index";
	}
	
	@RequestMapping("/beforeSignUp")
	public String beforeSignUp() {
		return "/signup";
	}
	
	
	@RequestMapping("/signup")
	public String signup(User user) {
		return "/login";
	}
	
}
