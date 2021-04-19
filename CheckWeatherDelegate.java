package com.dpoint.tutorial.delegates;

import java.util.Arrays;
import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class CheckWeatherDelegate implements JavaDelegate{

	@Autowired
	   RestTemplate restTemplate;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		Random rando = new Random();
		execution.setVariable("name","value");
		System.out.println("WeatherOk : "+rando.nextBoolean());
		execution.setVariable("WeatherOk",rando.nextBoolean());
		
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      String response =  restTemplate.exchange("http://localhost:8085/get", HttpMethod.GET, entity, String.class).getBody();
	   
		System.out.println("Response : " +response);
		
	}

}
