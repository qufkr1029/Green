package com.green.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/hello")
	public String hello(Model model, @RequestParam(value="name",required=false)String name) {
		model.addAttribute("greeting", name+"님 안녕하세요");
		
		return "hello";
		
	}
	
}
