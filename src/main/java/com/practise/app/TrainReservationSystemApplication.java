package com.practise.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import com.practise.app.models.BookedTickets;
import com.practise.app.service.impl.TrainReservationSystem;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class })
public class TrainReservationSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(TrainReservationSystemApplication.class, args);

	}

}
