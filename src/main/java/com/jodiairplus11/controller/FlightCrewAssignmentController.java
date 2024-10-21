package com.jodiairplus11.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.jodiairplus11.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.jodiairplus11.domain.FlightCrewAssignment;
import com.jodiairplus11.dto.FlightCrewAssignmentDTO;
import com.jodiairplus11.dto.FlightCrewAssignmentSearchDTO;
import com.jodiairplus11.dto.FlightCrewAssignmentPageDTO;
import com.jodiairplus11.service.FlightCrewAssignmentService;
import com.jodiairplus11.dto.common.RequestDTO;
import com.jodiairplus11.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/flightCrewAssignment")
@RestController
public class FlightCrewAssignmentController {

	private final static Logger logger = LoggerFactory.getLogger(FlightCrewAssignmentController.class);

	@Autowired
	FlightCrewAssignmentService flightCrewAssignmentService;



	//@AllowSystem(AuthScopes.READ)
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<FlightCrewAssignment> getAll() {

		List<FlightCrewAssignment> flightCrewAssignments = flightCrewAssignmentService.findAll();
		
		return flightCrewAssignments;	
	}

	//@ReadAccess
	@GetMapping(value = "/{flightCrewAssignmentId}")
	@ResponseBody
	public FlightCrewAssignmentDTO getFlightCrewAssignment(@PathVariable Integer flightCrewAssignmentId) {
		
		return (flightCrewAssignmentService.getFlightCrewAssignmentDTOById(flightCrewAssignmentId));
	}

 	//@WriteAccess
 	@RequestMapping(value = "/addFlightCrewAssignment", method = RequestMethod.POST)
	public ResponseEntity<?> addFlightCrewAssignment(@RequestBody FlightCrewAssignmentDTO flightCrewAssignmentDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = flightCrewAssignmentService.addFlightCrewAssignment(flightCrewAssignmentDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}
		
		return result.asResponseEntity();
	}

	//@ReadAccess
	@GetMapping("/flightCrewAssignments")
	public ResponseEntity<FlightCrewAssignmentPageDTO> getFlightCrewAssignments(FlightCrewAssignmentSearchDTO flightCrewAssignmentSearchDTO) {
 
		return flightCrewAssignmentService.getFlightCrewAssignments(flightCrewAssignmentSearchDTO);
	}	

 	//@WriteAccess
	@RequestMapping(value = "/updateFlightCrewAssignment", method = RequestMethod.POST)
	public ResponseEntity<?> updateFlightCrewAssignment(@RequestBody FlightCrewAssignmentDTO flightCrewAssignmentDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = flightCrewAssignmentService.updateFlightCrewAssignment(flightCrewAssignmentDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
