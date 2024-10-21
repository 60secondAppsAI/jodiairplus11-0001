package com.jodiairplus11.dao;

import java.util.List;

import com.jodiairplus11.dao.GenericDAO;
import com.jodiairplus11.domain.Passenger;





public interface PassengerDAO extends GenericDAO<Passenger, Integer> {
  
	List<Passenger> findAll();
	






}


