package com.assignment.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.assignment.beans.Persons;


public interface TrackingRepository extends JpaRepository<Persons, Integer> {
	
@Query(nativeQuery=true , value="select name from Persons ORDER BY id DESC LIMIT 10")	
List<String> getTrackingHistory() ;

}
