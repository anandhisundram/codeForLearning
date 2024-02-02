package com.practise.app.service;

import java.util.List;

import com.practise.app.models.TrainReservDetails;
import com.practise.app.models.User;

public interface ITrainReserveSystem {

	public TrainReservDetails reserveTrain(final String reqUserId, final TrainReservDetails reservDetails);

	public List<User>  getDetailsOfSection(final String trainId,final String sectionType);

	public TrainReservDetails getDetailsOfReservation(final String reservId);

	public void removeUser(final String userId, final String trainId);

	public TrainReservDetails modifySeat(final String userId, final String trainId);

}
