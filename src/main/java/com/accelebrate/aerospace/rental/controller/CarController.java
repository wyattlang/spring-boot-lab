package com.accelebrate.aerospace.rental.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accelebrate.aerospace.rental.dao.CarService;
import com.accelebrate.aerospace.rental.dao.RentalCar;

@Controller
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping
	public String getCars(Model model) {
		Collection<RentalCar> allCars = carService.getAll();
		model.addAttribute("cars", allCars);
		return "car";
	}
	
}
