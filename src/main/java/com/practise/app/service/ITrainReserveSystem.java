package com.practise.app.service;

import java.util.List;

import com.practise.app.models.TrainReservDetails;

public interface ITrainReserveSystem {
	
public TrainReservDetails reserveTrain(final String reqUserId, final TrainReservDetails reservDetails);

public List<TrainReservDetails> getDetailsOfSection(final String sectionType);

public void removeUser(final String userId, final String trainId);

public String modifySeat(final String userId, final String trainId, final String currentSeat);

}
