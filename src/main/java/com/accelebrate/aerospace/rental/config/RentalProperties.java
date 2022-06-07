package com.accelebrate.aerospace.rental.config;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@ConfigurationProperties("rent")
@PropertySource("classpath:config/airport.properties")
public class RentalProperties {

	private List<Airport> airports = new ArrayList<>();
	@Min(value=5)
	@Max(value=7)
	private int maxInventory;
	
	public static class Airport {
		
		private String iataCode;
		private String desc;
		private Double tax;
		public String getIataCode() {
			return iataCode;
		}
		public void setIataCode(String iataCode) {
			this.iataCode = iataCode;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public Double getTax() {
			return tax;
		}
		public void setTax(Double tax) {
			this.tax = tax;
		}
		
	}

	public List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

	public int getMaxInventory() {
		return maxInventory;
	}

	public void setMaxInventory(int maxInventory) {
		this.maxInventory = maxInventory;
	}

}
