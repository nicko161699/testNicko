package com.nicko.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	// kalo pake Model
	@RequestMapping("/")
	public String showHome() 
	{
		return "home";
	}
}
