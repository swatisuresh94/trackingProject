package com.assignment.track;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.trackingServices.TrackingService;


@RestController
public class TrackingController {
	Logger logger = LoggerFactory.getLogger(TrackingController.class);
	@Autowired
	TrackingService trackingService;

	//This Api fetches the tracking history from Persons table upto 10 values with last inserted value first.
	@GetMapping("track/getHistory")  
	public List<String> getHistory()  
	{ 
		logger.info("Inside TrackingController.getHistory() method");
		List<String> persons=trackingService.getTrackingHistory();
		return persons;
	
	}  
	
	//This Api insert a new record to the Persons table and returns the previously added value.
	@PostMapping("track/trackValue")
	public String addPerson(@RequestParam String input) {
		logger.info("Inside TrackingController.addPerson() method");
		String lastPerson=trackingService.addPerson(input);
		return lastPerson;
	}
	
	 
}
