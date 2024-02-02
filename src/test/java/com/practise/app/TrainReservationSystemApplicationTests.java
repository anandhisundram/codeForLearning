package com.practise.app;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practise.app.models.StandardRequest;
import com.practise.app.models.TrainReservDetails;

@PropertySource("classpath:application.properties")
@SpringBootTest
class TrainReservationSystemApplicationTests {
	
	final String url="http://localhost:8080/v1/reserveTicket";
	
	final String urlView="http://localhost:8080/v1/getReservationDetails";
	
	final String urlViewSection="http://localhost:8080/v1/fetchUsersDetails";
	
	final String urlDelete="http://localhost:8080/v1/removeUser";
	
	final String urlUpdate="http://localhost:8080/v1/updateSeat";


	@Value("${spring.security.user.name}")
	private String username;
	
	@Value("${spring.security.user.password}")
	private String psw;
	
	@Test
	void reserveTicketHappyPathTest() throws StreamReadException, DatabindException, IOException {
		InputStream inJson = this.getClass().getResourceAsStream("/NEW_RESERVE/HappyPath.json");
		String auth=username+":"+psw;
		StandardRequest<TrainReservDetails> request = new ObjectMapper().readValue(inJson, StandardRequest.class);
		String basicDigestHeaderValue = "Basic YW5hbmRoaXN1bmRyYW1AZ21haWwuY29tOlhYWFhY";//"Basic " + new String(Base64.encodeBase64(auth).getBytes());
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders hdr=new HttpHeaders();
		//hdr.add("Authorization", basicDigestHeaderValue);
		hdr.add("Content-Type", "application/json");
		hdr.add("X-API-KEY", "Baeldung");
		HttpEntity<StandardRequest<TrainReservDetails>> entity = new HttpEntity<>(request, hdr);
		
		
		ResponseEntity<TrainReservDetails> resp=restTemplate.postForEntity(url, entity, TrainReservDetails.class);
		System.out.println(resp.toString());
		
		
	}
	
	TrainReservDetails reserveTicketHappyPath() throws StreamReadException, DatabindException, IOException {
		InputStream inJson = this.getClass().getResourceAsStream("/NEW_RESERVE/HappyPath.json");
		String auth=username+":"+psw;
		StandardRequest<TrainReservDetails> request = new ObjectMapper().readValue(inJson, StandardRequest.class);
		String basicDigestHeaderValue = "Basic YW5hbmRoaXN1bmRyYW1AZ21haWwuY29tOlhYWFhY";//"Basic " + new String(Base64.encodeBase64(auth).getBytes());
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders hdr=new HttpHeaders();
		//hdr.add("Authorization", basicDigestHeaderValue);
		hdr.add("Content-Type", "application/json");
		hdr.add("X-API-KEY", "Baeldung");
		HttpEntity<StandardRequest<TrainReservDetails>> entity = new HttpEntity<>(request, hdr);
		
		
		ResponseEntity<TrainReservDetails> resp=restTemplate.postForEntity(url, entity, TrainReservDetails.class);
		System.out.println(resp.toString());
		
		return resp.getBody();
	}
	
	
	@Test
	void viewTicketHappyPathTest() throws StreamReadException, DatabindException, IOException {
		//InputStream inJson = this.getClass().getResourceAsStream("/NEW_RESERVE/HappyPath.json");
		String auth=username+":"+psw;
		String basicDigestHeaderValue = "Basic YW5hbmRoaXN1bmRyYW1AZ21haWwuY29tOlhYWFhY";//"Basic " + new String(Base64.encodeBase64(auth).getBytes());
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders hdr=new HttpHeaders();
		//hdr.add("Authorization", basicDigestHeaderValue);
		//hdr.add("Content-Type", "application/json");
		hdr.add("X-API-KEY", "Baeldung");
		HttpEntity entity = new HttpEntity(hdr);
		ResponseEntity<TrainReservDetails> resp=restTemplate.exchange(urlView+"/RE123444",HttpMethod.GET, entity, TrainReservDetails.class);
		System.out.println(resp.toString());
	}
	
	
	@Test
	void viewSectionHappyPathTest() throws StreamReadException, DatabindException, IOException {
		reserveTicketHappyPathTest();
		//InputStream inJson = this.getClass().getResourceAsStream("/NEW_RESERVE/HappyPath.json");
		//String auth=username+":"+psw;
		//String basicDigestHeaderValue = "Basic YW5hbmRoaXN1bmRyYW1AZ21haWwuY29tOlhYWFhY";//"Basic " + new String(Base64.encodeBase64(auth).getBytes());
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders hdr=new HttpHeaders();
		//hdr.add("Authorization", basicDigestHeaderValue);
		//hdr.add("Content-Type", "application/json");
		hdr.add("X-API-KEY", "Baeldung");
		HttpEntity entity = new HttpEntity(hdr);
		ResponseEntity<TrainReservDetails> resp=restTemplate.exchange(urlViewSection+"/ABHU1234/SectionA",HttpMethod.GET, entity, TrainReservDetails.class);
		System.out.println(resp.toString());
	}
	
	@Test
	void removeUser() throws StreamReadException, DatabindException, IOException {
		reserveTicketHappyPathTest();
		//InputStream inJson = this.getClass().getResourceAsStream("/NEW_RESERVE/HappyPath.json");
		//String auth=username+":"+psw;
		//String basicDigestHeaderValue = "Basic YW5hbmRoaXN1bmRyYW1AZ21haWwuY29tOlhYWFhY";//"Basic " + new String(Base64.encodeBase64(auth).getBytes());
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders hdr=new HttpHeaders();
		//hdr.add("Authorization", basicDigestHeaderValue);
		//hdr.add("Content-Type", "application/json");
		hdr.add("X-API-KEY", "Baeldung");
		HttpEntity entity = new HttpEntity(hdr);
		ResponseEntity<TrainReservDetails> resp=restTemplate.exchange(urlDelete+"/ABHU1234/ashanmu3",HttpMethod.DELETE, entity, TrainReservDetails.class);
		System.out.println(resp.toString());
	}
	
	@Test
	void updateUserSeat() throws StreamReadException, DatabindException, IOException {
		String refId=reserveTicketHappyPath().getTrainRefId();
		//InputStream inJson = this.getClass().getResourceAsStream("/NEW_RESERVE/HappyPath.json");
		//String auth=username+":"+psw;
		//String basicDigestHeaderValue = "Basic YW5hbmRoaXN1bmRyYW1AZ21haWwuY29tOlhYWFhY";//"Basic " + new String(Base64.encodeBase64(auth).getBytes());
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders hdr=new HttpHeaders();
		//hdr.add("Authorization", basicDigestHeaderValue);
		//hdr.add("Content-Type", "application/json");
		hdr.add("X-API-KEY", "Baeldung");
		HttpEntity entity = new HttpEntity(hdr);
		ResponseEntity<TrainReservDetails> resp=restTemplate.exchange(urlUpdate+"/"+refId+"/ashanmu3",HttpMethod.POST, entity, TrainReservDetails.class);
		System.out.println(resp.toString());
	}
	
	
	
	

}
