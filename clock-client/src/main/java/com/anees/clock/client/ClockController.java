package com.anees.clock.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClockController {
	
	@Autowired
	ClockDataService clockDataService;
	
	@GetMapping("/getcurrenttime")
	public String getCurrentTime() {
		
		return clockDataService.getTime();
	}
	
	@GetMapping("/getdaytype/{time}")
	public String getDayType(@PathVariable String time) {
		
		return clockDataService.getDayOrNight(time);
	}

}
