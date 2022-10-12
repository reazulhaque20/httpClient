package com.apex.httpClient.controller;

import org.apache.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/test")
public class TestController {
	
	private RestTemplate restTemplate;
	
	
	public TestController(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}


	@GetMapping("/getData")
	public String getData() {
		String http_url = "http://192.168.4.24:80/ISAPI/AccessControl/AcsEvent?format=json";
		// Create the request body as a MultiValueMap
//		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		String body = "{\r\n"
				+ "   \"AcsEventCond\":{\r\n"
				+ "      \"searchID\":\"3242s34\",\r\n"
				+ "      \"searchResultPosition\":0,\r\n"
				+ "      \"numOfMatches\": 300,\r\n"
				+ "      \"maxResults\":600,\r\n"
				+ "      \"major\":0,\r\n"
				+ "      \"minor\":0,\r\n"
				+ "      \"startTime\":\"2022-09-09T17:30:08+08:00\",\r\n"
				+ "      \"endTime\":\"2022-12-12T17:30:08+08:00\"\r\n"
				+ "   }\r\n"
				+ "}";
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(body);
		ResponseEntity<String> response = restTemplate.exchange(http_url, HttpMethod.GET, entity, String.class);
	    System.out.println(response.getStatusCode());
	    return "Success";
	}

}
