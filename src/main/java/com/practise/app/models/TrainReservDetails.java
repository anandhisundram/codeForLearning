package com.practise.app.models;

import java.util.HashMap;
import java.util.List;

public class TrainReservDetails {

	Train trainDetails;

	List<User> usersDetails;

	String status;

	HashMap<String, String> allottedUserSeats=new HashMap<>();

	String paidAmount;

	/**
	 * @return the trainDetails
	 */
	public Train getTrainDetails() {
		return trainDetails;
	}

	/**
	 * @param trainDetails the trainDetails to set
	 */
	public void setTrainDetails(Train trainDetails) {
		this.trainDetails = trainDetails;
	}

	/**
	 * @return the usersDetails
	 */
	public List<User> getUsersDetails() {
		return usersDetails;
	}

	/**
	 * @param usersDetails the usersDetails to set
	 */
	public void setUsersDetails(List<User> usersDetails) {
		this.usersDetails = usersDetails;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the allottedUserSeats
	 */
	public HashMap<String, String> getAllottedUserSeats() {
		return allottedUserSeats;
	}

	/**
	 * @param allottedUserSeats the allottedUserSeats to set
	 */
	public void setAllottedUserSeats(HashMap<String, String> allottedUserSeats) {
		this.allottedUserSeats = allottedUserSeats;
	}

	/**
	 * @return the paidAmount
	 */
	public String getPaidAmount() {
		return paidAmount;
	}

	/**
	 * @param paidAmount the paidAmount to set
	 */
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

}
