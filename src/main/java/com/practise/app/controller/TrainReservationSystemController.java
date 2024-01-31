package com.practise.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practise.app.models.StandardRequest;
import com.practise.app.models.StandardResponse;
import com.practise.app.models.TrainReservDetails;
import com.practise.app.service.ITrainReserveSystem;
import com.practise.app.service.impl.TrainReservationSystem;

@RestController
@RequestMapping(value = "/v1")
public class TrainReservationSystemController {

	@Autowired
	private ITrainReserveSystem trainReservation;

	@RequestMapping(value = "/reserveTicket", method = RequestMethod.POST , consumes = "application/json")
	public ResponseEntity<StandardResponse<TrainReservDetails>> reserveTicket(HttpRequest req,@RequestBody StandardRequest<TrainReservDetails> request)
	{
		final String reqId = request.getContext().getUserId();
		StandardResponse<TrainReservationSystem> response = new StandardResponse(
				trainReservation.reserveTrain(reqId, (TrainReservDetails)request.getPayload()));

		return new ResponseEntity(response,HttpStatus.CREATED);
	}

}
