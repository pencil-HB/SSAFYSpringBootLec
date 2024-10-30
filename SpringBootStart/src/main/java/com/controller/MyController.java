package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/bye")
	public String bye() {
		return "bye";
	}
}