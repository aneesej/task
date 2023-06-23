package com.anees.spring;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class ClockService {

	private static final Logger log= LoggerFactory.getLogger(ClockService.class);
	
	/**
	 * To get current time in words
	 * @return
	 */
	public String getCurrentTimeToYoWord() {
		
		String timeToWord=ClockUtility.speakCurrentTime();
		log.info("Time: {}",timeToWord);
		return timeToWord;
	}
	
	/**
	 * To Check given time is day or night
	 * @param time
	 * @return
	 * @throws Exception 
	 */
	public String getDayOrNight(String time)  throws ClockException {
		
		try 
		{
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
			
			Date date=dateFormat.parse(time);
			LocalTime lcTime=LocalTime.of(date.getHours(), date.getMinutes());
			log.info("Date: {}",lcTime);
			if(lcTime.equals(LocalTime.NOON))
				return time+ " It's Midday";
			else if(lcTime.equals(LocalTime.MIDNIGHT))
				return time+ ": It's Midnight";
			else {
				return time+ " is not midday or midnight";
			}
			
		} catch (Exception e) {
			throw new ClockException("Invalid time formmat, must be in HH:mm", HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
