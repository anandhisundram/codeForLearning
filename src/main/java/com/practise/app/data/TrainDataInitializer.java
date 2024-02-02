package com.practise.app.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.practise.app.models.BookedTickets;

public class TrainDataInitializer {
	
	private static TrainDataInitializer dataInit;
	

	@Autowired
	 public static List<BookedTickets> bookedTickets;
	
	
	private TrainDataInitializer() {}
	
	public static synchronized TrainDataInitializer getInstance(){
		if(dataInit==null)
		{
			dataInit=new TrainDataInitializer();
			bookedTickets=dataInit.initializeStorageData();
			
		}
		
		return dataInit;
	}
	

	
	private List<BookedTickets> initializeStorageData() {
		BookedTickets bookedTicket = new BookedTickets();
		bookedTicket.setTrainId("ABU12345");

		bookedTicket.setAvailableSeats(new HashMap<String, ArrayList<String>>() {
			{
				put("SectionA", new ArrayList<String>(Arrays.asList("10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20")));
				put("SectionB", new ArrayList<String>(Arrays.asList("10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20")));

			}

		});

		bookedTicket.setBookedSeats(new HashMap<String, ArrayList<String>>() {
			{
				put("SectionA", new ArrayList());
				put("SectionB", new ArrayList());
			}
		});
		return Arrays.asList(bookedTicket);
	}

}
