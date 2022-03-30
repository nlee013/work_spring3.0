package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloBootController {
	
	@RequestMapping("/")
	public String hello() {
		
		return "처음보는 Boot";
	}
	
}
