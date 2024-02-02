package com.practise.app.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class BookedTickets {

	String trainId;
	List<User> bookedUsers = new ArrayList<>();
	static public Map<String, ArrayList<String>> availableSeats = new HashMap<>();
	static public Map<String, ArrayList<String>> bookedSeats = new HashMap<>();

	public BookedTickets() {
		availableSeats.put("SectionA", new ArrayList());
		availableSeats.put("SectionB", new ArrayList());

		bookedSeats.put("SectionA", new ArrayList());
		bookedSeats.put("SectionB", new ArrayList());
	}

	public void addUser(User user) {
		bookedUsers.add(user);
	}

	public void updateUser(User user) {
		bookedUsers.replaceAll(usr -> {
			if (usr.getUserId().equals(user.getUserId())) {
				return user;
			}

			else
				return usr;

		});
	}

	public void removeBookedSeat(String section, String seatNo) {
		bookedSeats.put(section, new ArrayList<String>(
				bookedSeats.get(section).stream().filter(seat -> !seatNo.contains(seat)).collect(Collectors.toList())));
	}

	public void addBookedSeats(String section, String seatNo) {
		final ArrayList<String> tempList = bookedSeats.get(section);
		bookedSeats.get(section).add(seatNo);
	}

	/**
	 * @return the trainId
	 */
	public String getTrainId() {
		return trainId;
	}

	/**
	 * @param trainId the trainId to set
	 */
	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	/**
	 * @return the bookedUsers
	 */
	public List<User> getBookedUsers() {
		return bookedUsers;
	}

	/**
	 * @param bookedUsers the bookedUsers to set
	 */
	public void setBookedUsers(List<User> bookedUsers) {
		this.bookedUsers = bookedUsers;
	}

	/**
	 * @return the availableSeats
	 */
	public Map<String, ArrayList<String>> getAvailableSeats() {
		return availableSeats;
	}

	/**
	 * @param availableSeats the availableSeats to set
	 */
	public void setAvailableSeats(Map<String, ArrayList<String>> availableSeats) {
		this.availableSeats = availableSeats;
	}

	/**
	 * @return the bookedSeats
	 */
	public Map<String, ArrayList<String>> getBookedSeats() {
		return bookedSeats;
	}

	/**
	 * @param bookedSeats the bookedSeats to set
	 */
	public void setBookedSeats(Map<String, ArrayList<String>> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

}
