
package com.anees.spring;
  
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

  
  @RunWith(SpringRunner.class)
  @SpringBootTest 
  public class ClockServiceApplicationTests 
  {
	  @Test
	  public void contextLoads() {
		  
	  }
	  
	  @Autowired
	  private ClockService clockService;
  
	  @Test
	  public void getDayOrNightTest() throws ClockException {
		  
		  assertEquals("12:00 It's Midday", clockService.getDayOrNight("12:00"));
	  }
	  
	  @Test
	  public void getDayOrNightNegativeTest() throws ClockException {
		  
		  assertEquals("33:00 is not midday or midnight", clockService.getDayOrNight("33:00"));
	  }
	  
	  @Test(expected = ClockException.class)
	  public void getDayOrNightExceptionTest() throws ClockException {
		  clockService.getDayOrNight("bla");
		  
	  }
	  
	  @Test
	  public void getCurrentTimeToYoWordTest() throws ClockException {
		  
		  assertNotNull(clockService.getCurrentTimeToYoWord());
	  }
  }
 