package com.accelebrate.aerospace.rental.dao;

public class RentalCar {

	private long id;
	private String category;
	 
	private double dailyRate;
	private String make;
	private String model;
	private String location;

	public RentalCar() {
	}

	public RentalCar(String location, String category, double dailyCost, String make, String model) {
		this.setLocation(location);
		this.setCategory(category);
		this.setDailyRate(dailyCost);
		this.setMake(make);
		this.setModel(model);
	}

	public RentalCar(long id, String location, String category, double dailyCost, String make, String model) {
		this(location, category, dailyCost, make, model);
		this.setId(id);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "RentalCar [id=" + id + ", category=" + category + ", dailyRate=" + dailyRate + ", make=" + make
				+ ", model=" + model + ", location=" + location + "]";
	}

}
