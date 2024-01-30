package com.practise.app.models;

import java.util.List;
import java.util.Map;

public class Train {
	
	String trainName;
	
	String trainId;
	
	String fromLocation;
	
	String toLocation;
	
	String cost;
	
	Map<String, List<String>> sectionSeats;
	
	final int totalSeats=35;
    
    String sectionType;

	/**
	 * @return the sectionType
	 */
	public String getSectionType() {
		return sectionType;
	}

	/**
	 * @param sectionType the sectionType to set
	 */
	public void setSectionType(String sectionType) {
		this.sectionType = sectionType;
	}

	/**
	 * @return the trainName
	 */
	public String getTrainName() {
		return trainName;
	}

	/**
	 * @param trainName the trainName to set
	 */
	public void setTrainName(String trainName) {
		this.trainName = trainName;
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
	 * @return the fromLocation
	 */
	public String getFromLocation() {
		return fromLocation;
	}

	/**
	 * @param fromLocation the fromLocation to set
	 */
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	/**
	 * @return the toLocation
	 */
	public String getToLocation() {
		return toLocation;
	}

	/**
	 * @param toLocation the toLocation to set
	 */
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	/**
	 * @return the cost
	 */
	public String getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(String cost) {
		this.cost = cost;
	}

	/**
	 * @return the totalSeats
	 */
	public int getTotalSeats() {
		return totalSeats;
	}
	
	/**
	 * @return the sectionSeats
	 */
	public Map<String, List<String>> getSectionSeats() {
		return sectionSeats;
	}

	/**
	 * @param sectionSeats the sectionSeats to set
	 */
	public void setSectionSeats(Map<String, List<String>> sectionSeats) {
		this.sectionSeats = sectionSeats;
	}


	/**
	 * @param totalSeats the totalSeats to set
	 */
	/*
	 * public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }
	 */

	
}
