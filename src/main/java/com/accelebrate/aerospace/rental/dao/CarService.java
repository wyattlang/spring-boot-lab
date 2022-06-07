package com.accelebrate.aerospace.rental.dao;

import java.util.Collection;

public interface CarService {
	
	public Collection<RentalCar> getCarsPerLocationAndPrice(String location, double price) ; 
	public Collection<RentalCar> getAll();
	public RentalCar getByID(long id);
 
}
