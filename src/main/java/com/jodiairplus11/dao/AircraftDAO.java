package com.jodiairplus11.dao;

import java.util.List;

import com.jodiairplus11.dao.GenericDAO;
import com.jodiairplus11.domain.Aircraft;





public interface AircraftDAO extends GenericDAO<Aircraft, Integer> {
  
	List<Aircraft> findAll();
	






}


