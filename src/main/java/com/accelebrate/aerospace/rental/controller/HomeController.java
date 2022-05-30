package com.accelebrate.aerospace.rental.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class HomeController {

	@Value("${cars.title}")
	private String appTitle;
	
	@GetMapping
	public String goHome(Model model) {
		model.addAttribute("title", appTitle);
		return "home";
	}
	
}
