package com.jodiairplus11.dao;

import java.util.List;

import com.jodiairplus11.dao.GenericDAO;
import com.jodiairplus11.domain.Booking;





public interface BookingDAO extends GenericDAO<Booking, Integer> {
  
	List<Booking> findAll();
	






}


