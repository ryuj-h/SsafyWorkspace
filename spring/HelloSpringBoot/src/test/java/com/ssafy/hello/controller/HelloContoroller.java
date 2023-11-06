package com.ssafy.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.hello.service.HelloService;

@Controller
public class HelloContoroller {
	
	@Value("${file.uploadpath}")
	
	private HelloService helloService;
	
	
	public HelloContoroller(HelloService helloService) {
		super();
		this.helloService = helloService;
	}


	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("msg", "안녕스프링부트");
		model.addAttribute("greet", helloService.greeting());
		return "hello";
	}
}
