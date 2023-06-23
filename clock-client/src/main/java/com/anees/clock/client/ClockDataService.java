package com.anees.clock.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class ClockDataService {

	@Autowired
	RestTemplate restTemplate;
	
	
	public String getTime() {
		return restTemplate.getForObject("http://CLOCK-SERVICE/speakCurrentTime", String.class);
	}
	
	@HystrixCommand(
	fallbackMethod = "getDefaultDayOrNight" ,
	commandProperties = {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
			@HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "4"),
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value = "10000")
	 })
	public String getDayOrNight(String time) {
		return restTemplate.getForObject("http://CLOCK-SERVICE/getdaytype/"+time, String.class);
	}
	
	/**
	 * Fallback method with default data
	 * @param time
	 * @return
	 */
	private String getDefaultDayOrNight(String time) {
		
		return "default value: "+time +" unknown";
	}
}
