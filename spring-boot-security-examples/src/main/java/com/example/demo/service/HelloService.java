package com.example.demo.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {

	@RequestMapping(path="sayHello")
	public String sayHello() {
		return "Hello ["+System.currentTimeMillis()+"]";
	}
}
