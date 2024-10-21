package com.jodiairplus11.dao;

import java.util.List;

import com.jodiairplus11.dao.GenericDAO;
import com.jodiairplus11.domain.Flight;





public interface FlightDAO extends GenericDAO<Flight, Integer> {
  
	List<Flight> findAll();
	






}


