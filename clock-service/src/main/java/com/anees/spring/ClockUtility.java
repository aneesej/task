package com.anees.spring;

import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class ClockUtility {

	 private static final String[] HOURS = {
	            "twelve", "one", "two", "three", "four", "five",
	            "six", "seven", "eight", "nine", "ten", "eleven"
	    };

	 private static final String[] MINUTES = {
	            "o'clock", "oh one", "oh two", "oh three", "oh four", "oh five",
	            "oh six", "oh seven", "oh eight", "oh nine", "ten", "eleven",
	            "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
	            "eighteen", "nineteen", "twenty", "twenty one", "twenty two",
	            "twenty three", "twenty four", "twenty five", "twenty six",
	            "twenty seven", "twenty eight", "twenty nine", "thirty", "thirty one",
	            "thirty two", "thirty three", "thirty four", "thirty five", "thirty six",
	            "thirty seven", "thirty eight", "thirty nine", "forty", "forty one",
	            "forty two", "forty three", "forty four", "forty five", "forty six",
	            "forty seven", "forty eight", "forty nine", "fifty", "fifty one",
	            "fifty two", "fifty three", "fifty four", "fifty five", "fifty six",
	            "fifty seven", "fifty eight", "fifty nine"
	    };
	    
	    
	public static String speakCurrentTime() {
		
		StringBuilder speakTime = new StringBuilder();
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime.getHour() +":" +localTime.getMinute());
		speakTime.append(HOURS[localTime.getHour() % 12]);
		speakTime.append(" "+ MINUTES[localTime.getMinute()]);
		
		if(localTime.getHour() <12)
			speakTime.append(" AM");
		else
			speakTime.append(" PM");
		
		return speakTime.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(speakCurrentTime());
	}
}
