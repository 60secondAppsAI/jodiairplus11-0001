package com.jodiairplus11.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.jodiairplus11.domain.FlightCrewAssignment;
import com.jodiairplus11.dto.FlightCrewAssignmentDTO;
import com.jodiairplus11.dto.FlightCrewAssignmentSearchDTO;
import com.jodiairplus11.dto.FlightCrewAssignmentPageDTO;
import com.jodiairplus11.dto.FlightCrewAssignmentConvertCriteriaDTO;
import com.jodiairplus11.service.GenericService;
import com.jodiairplus11.dto.common.RequestDTO;
import com.jodiairplus11.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface FlightCrewAssignmentService extends GenericService<FlightCrewAssignment, Integer> {

	List<FlightCrewAssignment> findAll();

	ResultDTO addFlightCrewAssignment(FlightCrewAssignmentDTO flightCrewAssignmentDTO, RequestDTO requestDTO);

	ResultDTO updateFlightCrewAssignment(FlightCrewAssignmentDTO flightCrewAssignmentDTO, RequestDTO requestDTO);

    Page<FlightCrewAssignment> getAllFlightCrewAssignments(Pageable pageable);

    Page<FlightCrewAssignment> getAllFlightCrewAssignments(Specification<FlightCrewAssignment> spec, Pageable pageable);

	ResponseEntity<FlightCrewAssignmentPageDTO> getFlightCrewAssignments(FlightCrewAssignmentSearchDTO flightCrewAssignmentSearchDTO);
	
	List<FlightCrewAssignmentDTO> convertFlightCrewAssignmentsToFlightCrewAssignmentDTOs(List<FlightCrewAssignment> flightCrewAssignments, FlightCrewAssignmentConvertCriteriaDTO convertCriteria);

	FlightCrewAssignmentDTO getFlightCrewAssignmentDTOById(Integer flightCrewAssignmentId);







}





