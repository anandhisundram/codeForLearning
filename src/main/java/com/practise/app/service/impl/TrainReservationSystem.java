package com.practise.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.practise.app.models.BookedTickets;
import com.practise.app.models.TrainReservDetails;
import com.practise.app.service.ITrainReserveSystem;

@Component
public class TrainReservationSystem implements ITrainReserveSystem{
	
	private static List<TrainReservDetails> reservationList=new ArrayList<>();
	
	private static List<BookedTickets> bookedTickets=new ArrayList<>();
	
	public Predicate<BookedTickets> checkSectionSeatA=bt->(bt.getAvailableSeats().get("SectionA").size()>0);
	
	public Predicate<BookedTickets> checkSectionSeatB=bt->(bt.getAvailableSeats().get("SectionB").size()>0);
	
	public BiConsumer<BookedTickets, String> updateSection=(bt,sec)->{
		String seatNumber=bt.getAvailableSeats().get(sec).get(0);
		bt.addBookedSeats(sec,seatNumber);
		bt.removeBookedSeat(sec,seatNumber);
	};
	

	@Override
	public TrainReservDetails reserveTrain(String reqUserId, TrainReservDetails reservDetails) {
		
		String trainId=reservDetails.getTrainDetails().getTrainId();
		
		reservDetails.getUsersDetails().stream().forEach(user->{
		bookedTickets.stream().forEach(bt->{
			if(checkSectionSeatA.test(bt))
			{
				user.setSeatNumber(bt.getAvailableSeats().get("SectionA").get(0));
				updateSection.accept(bt, "SectionA");
			}
			else if(checkSectionSeatB.test(bt))
			{
				user.setSeatNumber(bt.getAvailableSeats().get("SectionB").get(0));
				updateSection.accept(bt, "SectionB");
			}
			else
			{
				//throw NoSeatAvailableException();
			}
			bt.addUser(user);
			bt.setTrainId(trainId);
		});
		});
		
		reservationList.add(reservDetails);
		return reservDetails;
	}

	@Override
	public List<TrainReservDetails> getDetailsOfSection(String sectionType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(String userId, String trainId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String modifySeat(String userId, String trainId, String currentSeat) {
		// TODO Auto-generated method stub
		return null;
	}
	 

}
