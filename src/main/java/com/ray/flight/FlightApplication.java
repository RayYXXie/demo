package com.ray.flight;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude=ErrorMvcAutoConfiguration.class)
@MapperScan("com.ray.flight.dao")	
public class FlightApplication extends SpringBootServletInitializer{

	public static void main(final String[] args) {
		SpringApplication.run(FlightApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(FlightApplication.class);
	}
}
