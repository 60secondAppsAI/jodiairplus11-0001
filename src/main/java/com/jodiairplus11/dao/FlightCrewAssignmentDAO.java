package com.jodiairplus11.dao;

import java.util.List;

import com.jodiairplus11.dao.GenericDAO;
import com.jodiairplus11.domain.FlightCrewAssignment;





public interface FlightCrewAssignmentDAO extends GenericDAO<FlightCrewAssignment, Integer> {
  
	List<FlightCrewAssignment> findAll();
	






}


