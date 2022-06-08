package com.accelebrate.aerospace.rental.controller;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accelebrate.aerospace.rental.config.RentalProperties;
import com.accelebrate.aerospace.rental.config.RentalProperties.Airport;
import com.accelebrate.aerospace.rental.dao.CarService;
import com.accelebrate.aerospace.rental.dao.RentalCar;

@Controller
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;
	@Autowired
	private RentalProperties rentalProperties;
	
	@GetMapping
	public String getCars(Model model, @RequestParam("code") Optional<String> optionalString) {
		String code = optionalString.orElse("ORD");
		Collection<RentalCar> allCars = carService.getAll().stream()
				.filter(p -> p.getLocation().equals(code))
				.collect(Collectors.toList());
		model.addAttribute("cars", allCars);
		return "car";
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public RentalCar getIndividualCar(@PathVariable("id") Long id) {
		RentalCar car = carService.getByID(id);
		Airport airport = rentalProperties.getAirports().stream()
				.filter(p -> p.getIataCode().equals(car.getLocation()))
				.findFirst()
				.get();
		double tax = car.getDailyRate() * airport.getTax() / 100;
		car.setDailyRate(car.getDailyRate() + tax);
		return car;
	}
	
}
