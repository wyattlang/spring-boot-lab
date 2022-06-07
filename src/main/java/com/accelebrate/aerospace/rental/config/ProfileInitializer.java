package com.accelebrate.aerospace.rental.config;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.env.ConfigurableEnvironment;

public class ProfileInitializer 
		implements ApplicationContextInitializer<AnnotationConfigServletWebServerApplicationContext> {

	@Override
	public void initialize(AnnotationConfigServletWebServerApplicationContext applicationContext) {
		ConfigurableEnvironment env = applicationContext.getEnvironment();
		env.addActiveProfile(env.getProperty("profile"));
	}

}
