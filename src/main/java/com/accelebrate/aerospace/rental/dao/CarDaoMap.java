package com.accelebrate.aerospace.rental.dao;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component 
@Profile("test")
public class CarDaoMap implements CarService{
	
	private static Map<Long, RentalCar> inventory;
	 
	static {
		 	
		inventory = new ConcurrentHashMap<Long, RentalCar>();
		inventory.put(1L, new RentalCar(1L, "BMI", "Economy", 23.00, "Kia", "Rio" ));
		inventory.put(2L, new RentalCar(2L, "BMI", "Compact", 26.00, "Nissan", "Versa" ));
	    inventory.put(6L, new RentalCar(6L,"PEA", "Economy", 24.00, "Ford", "Fiesta" ));
		inventory.put(7L, new RentalCar(7L,"PEA", "Compact", 25.00, "Ford", "Focus" ));
		inventory.put(8L, new RentalCar(8L,"PEA", "MidSize", 32.00, "Honda", "Civic" ));
	} 
	public Collection<RentalCar> getCarsPerLocationAndPrice(String location, double price) {
		return  inventory.values().stream().filter(p-> {
			 return p.getLocation().equals(location) && p.getDailyRate() < price;
		 }).collect(Collectors.toList()); 
	}
	public Collection<RentalCar> getAll() {
	 	return inventory.values();
	}

	public RentalCar getByID(long id) {
	 	return inventory.get(id);
	}
}
