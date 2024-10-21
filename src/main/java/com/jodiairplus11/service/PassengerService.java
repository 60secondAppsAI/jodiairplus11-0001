package com.jodiairplus11.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.jodiairplus11.domain.Passenger;
import com.jodiairplus11.dto.PassengerDTO;
import com.jodiairplus11.dto.PassengerSearchDTO;
import com.jodiairplus11.dto.PassengerPageDTO;
import com.jodiairplus11.dto.PassengerConvertCriteriaDTO;
import com.jodiairplus11.service.GenericService;
import com.jodiairplus11.dto.common.RequestDTO;
import com.jodiairplus11.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface PassengerService extends GenericService<Passenger, Integer> {

	List<Passenger> findAll();

	ResultDTO addPassenger(PassengerDTO passengerDTO, RequestDTO requestDTO);

	ResultDTO updatePassenger(PassengerDTO passengerDTO, RequestDTO requestDTO);

    Page<Passenger> getAllPassengers(Pageable pageable);

    Page<Passenger> getAllPassengers(Specification<Passenger> spec, Pageable pageable);

	ResponseEntity<PassengerPageDTO> getPassengers(PassengerSearchDTO passengerSearchDTO);
	
	List<PassengerDTO> convertPassengersToPassengerDTOs(List<Passenger> passengers, PassengerConvertCriteriaDTO convertCriteria);

	PassengerDTO getPassengerDTOById(Integer passengerId);







}





