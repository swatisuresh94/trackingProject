package com.assignment.trackingServices;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.Dao.TrackingRepository;
import com.assignment.beans.Persons;

@Service


public class TrackingService {
	Logger logger = LoggerFactory.getLogger(TrackingService.class);
	@Autowired
	TrackingRepository trackingDao;
	
	public List<String> getTrackingHistory() {
		logger.info("inside TrackingService.getTrackingHistory() method");
		var persons =trackingDao.getTrackingHistory();
		return persons;
	}


	public String addPerson(String name) {
		logger.info("inside TrackingService.addPerson() method");
		Persons person=new Persons();
		person.setName(name);
		Optional<Persons> previousPerson=null;
		try {
		 person=trackingDao.save(person);
		 previousPerson=trackingDao.findById(person.getId()-1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if (!previousPerson.isEmpty()) 
			return previousPerson.get().getName(); 
		else
			return "null";
		}
	
}
