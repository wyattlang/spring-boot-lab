package com.accelebrate.aerospace.rental.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.accelebrate.aerospace.rental.config.RentalProperties;

@Controller("/")
public class HomeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

	@Value("${cars.title}")
	private String appTitle;
	
	@Autowired
	private RentalProperties rentalProperties;
	
	@GetMapping
	public String goHome(Model model) {
		try {
			model.addAttribute("title", appTitle);
		} catch (IllegalArgumentException e) {
			LOG.error("null attributeName passed to org.springframework.ui.Model's addAttribute() method");
			throw new IllegalArgumentException();
		}
		model.addAttribute("airports", rentalProperties.getAirports());
		
		LOG.info("serving up home.html");
		
		return "home";
	}
	
}
