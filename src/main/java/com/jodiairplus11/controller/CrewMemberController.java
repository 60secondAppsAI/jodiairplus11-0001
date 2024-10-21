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

import com.jodiairplus11.domain.CrewMember;
import com.jodiairplus11.dto.CrewMemberDTO;
import com.jodiairplus11.dto.CrewMemberSearchDTO;
import com.jodiairplus11.dto.CrewMemberPageDTO;
import com.jodiairplus11.service.CrewMemberService;
import com.jodiairplus11.dto.common.RequestDTO;
import com.jodiairplus11.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/crewMember")
@RestController
public class CrewMemberController {

	private final static Logger logger = LoggerFactory.getLogger(CrewMemberController.class);

	@Autowired
	CrewMemberService crewMemberService;



	//@AllowSystem(AuthScopes.READ)
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<CrewMember> getAll() {

		List<CrewMember> crewMembers = crewMemberService.findAll();
		
		return crewMembers;	
	}

	//@ReadAccess
	@GetMapping(value = "/{crewMemberId}")
	@ResponseBody
	public CrewMemberDTO getCrewMember(@PathVariable Integer crewMemberId) {
		
		return (crewMemberService.getCrewMemberDTOById(crewMemberId));
	}

 	//@WriteAccess
 	@RequestMapping(value = "/addCrewMember", method = RequestMethod.POST)
	public ResponseEntity<?> addCrewMember(@RequestBody CrewMemberDTO crewMemberDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = crewMemberService.addCrewMember(crewMemberDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}
		
		return result.asResponseEntity();
	}

	//@ReadAccess
	@GetMapping("/crewMembers")
	public ResponseEntity<CrewMemberPageDTO> getCrewMembers(CrewMemberSearchDTO crewMemberSearchDTO) {
 
		return crewMemberService.getCrewMembers(crewMemberSearchDTO);
	}	

 	//@WriteAccess
	@RequestMapping(value = "/updateCrewMember", method = RequestMethod.POST)
	public ResponseEntity<?> updateCrewMember(@RequestBody CrewMemberDTO crewMemberDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = crewMemberService.updateCrewMember(crewMemberDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
