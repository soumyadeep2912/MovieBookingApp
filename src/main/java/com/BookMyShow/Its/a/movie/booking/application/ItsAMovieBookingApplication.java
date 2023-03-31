package com.BookMyShow.Its.a.movie.booking.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ItsAMovieBookingApplication {
	private static final Logger LOGGER= LoggerFactory.getLogger(ItsAMovieBookingApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(ItsAMovieBookingApplication.class, args);
		LOGGER.debug("I am writing a debug log");
	}


}
