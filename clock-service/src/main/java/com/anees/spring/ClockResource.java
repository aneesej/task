package com.anees.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClockResource {

	@Autowired
	private ClockService clockService;
	
	@GetMapping("/speakCurrentTime")
	public String speakCurrentTime() {
		
		return clockService.getCurrentTimeToYoWord();
	}
	
	@GetMapping("/getdaytype/{time}")
	public String getDayType(@PathVariable String time) throws ClockException {
		
		return clockService.getDayOrNight(time);
	}
}
