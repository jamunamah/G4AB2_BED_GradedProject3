package com.greatlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketTrackerApplication.class, args);
		System.out.println("Welcome to Ticket Tracker Application!");
	}

}
