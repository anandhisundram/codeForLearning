package com.practise.app.models;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookedTickets {
	
	String trainId;
	List<User> bookedUsers;
	Map<String,List<String>> availableSeats;
	Map<String,List<String>> bookedSeats;
	
	public void addUser(User user)
	{
		bookedUsers.add(user);
	}
	
	public void removeBookedSeat(String section, String seatNo)
	{
		bookedSeats.put(section, bookedSeats.get(section).stream().filter(seat -> !seatNo.contains(seat)).collect(Collectors.toList()));
	}
	
	public void addBookedSeats(String section, String seatNo)
	{
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
	public Map<String, List<String>> getAvailableSeats() {
		return availableSeats;
	}
	/**
	 * @param availableSeats the availableSeats to set
	 */
	public void setAvailableSeats(Map<String, List<String>> availableSeats) {
		this.availableSeats = availableSeats;
	}
	/**
	 * @return the bookedSeats
	 */
	public Map<String, List<String>> getBookedSeats() {
		return bookedSeats;
	}
	/**
	 * @param bookedSeats the bookedSeats to set
	 */
	public void setBookedSeats(Map<String, List<String>> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	
	

}
