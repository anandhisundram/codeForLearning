package com.practise.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.practise.app.data.TrainDataInitializer;
import com.practise.app.models.BookedTickets;
import com.practise.app.models.TrainReservDetails;
import com.practise.app.models.User;
import com.practise.app.service.ITrainReserveSystem;

@Component
public class TrainReservationSystem implements ITrainReserveSystem {

	private static List<TrainReservDetails> reservationList = new ArrayList<>();

	private static List<BookedTickets> bookedTickets = new ArrayList<>();

	public Predicate<BookedTickets> checkSectionSeatA = bt -> (bt.getAvailableSeats().get("SectionA").size() > 0);

	public Predicate<BookedTickets> checkSectionSeatB = bt -> (bt.getAvailableSeats().get("SectionB").size() > 0);

	public BiConsumer<BookedTickets, String> updateSection = (bt, sec) -> {
		String seatNumber = bt.getAvailableSeats().get(sec).get(0);
		bt.addBookedSeats(sec, seatNumber);
		bt.removeBookedSeat(sec, seatNumber);
	};

	public BiConsumer<BookedTickets, String> removeSeatA = (bt, seatNo) -> {
		bt.getBookedSeats().get("SectionA").removeIf(seat -> seat.equals(seatNo));
	};

	public BiConsumer<BookedTickets, String> removeSeatB = (bt, seatNo) -> {
		bt.getBookedSeats().get("SectionB").removeIf(seat -> seat.equals(seatNo));
	};

	@Override
	public TrainReservDetails reserveTrain(String reqUserId, TrainReservDetails reservDetails) {

		String trainId = reservDetails.getTrainDetails().getTrainId();
		if (bookedTickets.size() == 0)
			bookedTickets = TrainDataInitializer.getInstance().bookedTickets;
		reservDetails.getUsersDetails().stream().forEach(user -> {
			bookedTickets.stream().forEach(bt -> {
				if (checkSectionSeatA.test(bt)) {
					user.setSeatNumber(bt.getAvailableSeats().get("SectionA").get(0));
					updateSection.accept(bt, "SectionA");
					user.setSectionType("SectionA");
				} else if (checkSectionSeatB.test(bt)) {
					user.setSeatNumber(bt.getAvailableSeats().get("SectionB").get(0));
					updateSection.accept(bt, "SectionB");
					user.setSectionType("SectionB");
				} else {
					// throw NoSeatAvailableException();
				}
				bt.addUser(user);
				bt.setTrainId(trainId);
			});
		});
		reservDetails.setTrainRefId(UUID.randomUUID().toString());
		reservDetails.setStatus("Reserved");
		reservationList.add(reservDetails);
		return reservDetails;
	}

	@Override
	public List<User> getDetailsOfSection(String traindId, String sectionType) {
		return reservationList.stream()
				.filter(trainReserv -> trainReserv.getTrainDetails().getTrainId().equals(traindId)).findFirst()
				.orElse(null).getUsersDetails().stream().filter(user -> user.getSectionType().equals(sectionType))
				.collect(Collectors.toList());

	}

	@Override
	public void removeUser(String userId, String trainId) {
		reservationList.stream().filter(trainReserv -> trainReserv.getTrainDetails().getTrainId().equals(trainId))
				.findFirst().orElse(null).getUsersDetails().removeIf(usr -> usr.getUserId().equals(userId));

	}

	@Override
	public TrainReservDetails modifySeat(String userId, String trainRefId) {
		reservationList.stream().filter(trainReserv -> trainReserv.getTrainRefId().equals(trainRefId)).findFirst()
				.orElse(null).getUsersDetails().stream().forEach(user -> {
					bookedTickets.stream().forEach(bt -> {
						if (checkSectionSeatA.test(bt)) {
							String tmp = user.getSeatNumber();
							user.setSeatNumber(bt.getAvailableSeats().get("SectionA").get(0));
							removeSeatA.accept(bt, tmp);
							updateSection.accept(bt, "SectionA");
							user.setSectionType("SectionA");
						} else if (checkSectionSeatB.test(bt)) {
							String tmp = user.getSeatNumber();
							user.setSeatNumber(bt.getAvailableSeats().get("SectionB").get(0));
							removeSeatA.accept(bt, tmp);
							updateSection.accept(bt, "SectionB");
							user.setSectionType("SectionB");
						} else {
							// throw NoSeatAvailableException();
						}
						bt.updateUser(user);
					});
				});

		return (reservationList.stream()
				.filter(trainReserv -> trainReserv.getTrainRefId().equals(trainRefId)).findFirst().orElse(null));
	}

	@Override
	public TrainReservDetails getDetailsOfReservation(String reservId) {
		return reservationList.stream().filter(trainReserv -> trainReserv.getTrainRefId().equals(reservId)).findFirst()
				.orElse(null);
	}

	public static List<TrainReservDetails> getReservationList() {
		return reservationList;
	}

	public static void setReservationList(List<TrainReservDetails> reservationList) {
		TrainReservationSystem.reservationList = reservationList;
	}

	public static List<BookedTickets> getBookedTickets() {
		return bookedTickets;
	}

	public static void setBookedTickets(List<BookedTickets> bookedTickets) {
		TrainReservationSystem.bookedTickets = bookedTickets;
	}

	public static void addBookedTickets(BookedTickets bookedTicket) {
		TrainReservationSystem.bookedTickets.add(bookedTicket);
	}

}
