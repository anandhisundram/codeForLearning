package com.practise.app;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practise.app.models.StandardRequest;
import com.practise.app.models.TrainReservDetails;

@SpringBootTest
class TrainReservationSystemApplicationTests {
	
	final String url="https://localhost:8080/v1/reserveTicket";

	@Test
	void reserveTicketHappyPathTest() throws StreamReadException, DatabindException, IOException {
		InputStream inJson = this.getClass().getResourceAsStream("/NEW_RESERVE/HappyPath.json");
		StandardRequest<TrainReservDetails> request = new ObjectMapper().readValue(inJson, StandardRequest.class);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<TrainReservDetails> resp=restTemplate.postForObject(url, request, ResponseEntity.class);
		System.out.println(resp.toString());
	}
	

}
