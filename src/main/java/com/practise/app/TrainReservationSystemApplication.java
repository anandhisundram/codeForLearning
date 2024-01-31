package com.practise.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practise.app.models.BookedTickets;

@SpringBootApplication
public class TrainReservationSystemApplication {

	@Autowired
	static  BookedTickets bookedTickets;

	 static void initializeStorageData() {
		 bookedTickets=new BookedTickets();
		bookedTickets.setTrainId("ABU12345");

		bookedTickets.setAvailableSeats(new HashMap<String, List<String>>() {
			{
				put("SectionA", Arrays.asList("10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"));
				put("SectionB", Arrays.asList("10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"));

			}
		});

		bookedTickets.setBookedSeats(new HashMap<String, List<String>>() {
			{
				put("SectionA", Arrays.asList());
				put("SectionB", Arrays.asList());
			}
		});

	}

	public static void main(String[] args) {

		SpringApplication.run(TrainReservationSystemApplication.class, args);

		initializeStorageData();
	}

}
