package com.accelebrate.aerospace.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.accelebrate.aerospace.rental.config.ProfileInitializer;

@SpringBootApplication
public class RentalCarsApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RentalCarsApplication.class);
		app.addInitializers(new ProfileInitializer());
		app.run(args);
	}

}
