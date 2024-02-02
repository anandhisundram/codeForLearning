package com.practise.app.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practise.app.models.StandardRequest;
import com.practise.app.models.StandardResponse;
import com.practise.app.models.TrainReservDetails;
import com.practise.app.service.ITrainReserveSystem;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/v1")
@CrossOrigin(origins = "http://localhost:8080")
public class TrainReservationSystemController {

	@Autowired
	private ITrainReserveSystem trainReservation;

	@RequestMapping(value = "/reserveTicket", method = { RequestMethod.POST, RequestMethod.OPTIONS })
	public ResponseEntity<StandardResponse<TrainReservDetails>> reserveTicket(HttpServletRequest req,
			@RequestBody StandardRequest<TrainReservDetails> request) {
		final String reqId = request.getContext().getUserId();
		StandardResponse<TrainReservDetails> response = new StandardResponse(
				trainReservation.reserveTrain(reqId, (TrainReservDetails) request.getPayload()));

		return new ResponseEntity(response, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getReservationDetails/{reserveId}", method = RequestMethod.GET)
	public ResponseEntity<TrainReservDetails> getReservationDetails(HttpServletRequest req,
			@PathVariable(value = "reserveId") String reserveId) {
		StandardResponse<TrainReservDetails> response = new StandardResponse(
				trainReservation.getDetailsOfReservation(reserveId));

		return new ResponseEntity(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/fetchUsersDetails/{trainId}/{sectionType}", method = RequestMethod.GET)
	public ResponseEntity<TrainReservDetails> fetchUsersDetails(HttpServletRequest req,
			@PathVariable(value = "sectionType") String sectionType, @PathVariable(value = "trainId") String trainId) {
		StandardResponse<TrainReservDetails> response = new StandardResponse(
				trainReservation.getDetailsOfSection(trainId, sectionType));

		return new ResponseEntity(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/removeUser/{trainId}/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<TrainReservDetails> removeUser(HttpServletRequest req,
			@PathVariable(value = "userId") String userId, @PathVariable(value = "trainId") String trainId) {
		trainReservation.removeUser(userId, trainId);
		StandardResponse<HashMap<String, String>> response = new StandardResponse(new HashMap<String, String>() {
			{
				put("message", "Deleted");
			}
		});

		return new ResponseEntity(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateSeat/{trainRefId}/{userId}", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse<TrainReservDetails>> updateSeat(HttpServletRequest req,
			@PathVariable(value = "userId") String userId, @PathVariable(value = "trainRefId") String trainRefId) {
		
		StandardResponse<TrainReservDetails> response = new StandardResponse(
				trainReservation.modifySeat(userId,trainRefId));

		return new ResponseEntity(response, HttpStatus.OK);
	}
}
