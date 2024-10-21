package com.jodiairplus11.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.jodiairplus11.dao.GenericDAO;
import com.jodiairplus11.service.GenericService;
import com.jodiairplus11.service.impl.GenericServiceImpl;
import com.jodiairplus11.dao.FlightCrewAssignmentDAO;
import com.jodiairplus11.domain.FlightCrewAssignment;
import com.jodiairplus11.dto.FlightCrewAssignmentDTO;
import com.jodiairplus11.dto.FlightCrewAssignmentSearchDTO;
import com.jodiairplus11.dto.FlightCrewAssignmentPageDTO;
import com.jodiairplus11.dto.FlightCrewAssignmentConvertCriteriaDTO;
import com.jodiairplus11.dto.common.RequestDTO;
import com.jodiairplus11.dto.common.ResultDTO;
import com.jodiairplus11.service.FlightCrewAssignmentService;
import com.jodiairplus11.util.ControllerUtils;





@Service
public class FlightCrewAssignmentServiceImpl extends GenericServiceImpl<FlightCrewAssignment, Integer> implements FlightCrewAssignmentService {

    private final static Logger logger = LoggerFactory.getLogger(FlightCrewAssignmentServiceImpl.class);

	@Autowired
	FlightCrewAssignmentDAO flightCrewAssignmentDao;

	


	@Override
	public GenericDAO<FlightCrewAssignment, Integer> getDAO() {
		return (GenericDAO<FlightCrewAssignment, Integer>) flightCrewAssignmentDao;
	}
	
	public List<FlightCrewAssignment> findAll () {
		List<FlightCrewAssignment> flightCrewAssignments = flightCrewAssignmentDao.findAll();
		
		return flightCrewAssignments;	
		
	}

	public ResultDTO addFlightCrewAssignment(FlightCrewAssignmentDTO flightCrewAssignmentDTO, RequestDTO requestDTO) {

		FlightCrewAssignment flightCrewAssignment = new FlightCrewAssignment();

		flightCrewAssignment.setFlightCrewAssignmentId(flightCrewAssignmentDTO.getFlightCrewAssignmentId());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		flightCrewAssignment = flightCrewAssignmentDao.save(flightCrewAssignment);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<FlightCrewAssignment> getAllFlightCrewAssignments(Pageable pageable) {
		return flightCrewAssignmentDao.findAll(pageable);
	}

	public Page<FlightCrewAssignment> getAllFlightCrewAssignments(Specification<FlightCrewAssignment> spec, Pageable pageable) {
		return flightCrewAssignmentDao.findAll(spec, pageable);
	}

	public ResponseEntity<FlightCrewAssignmentPageDTO> getFlightCrewAssignments(FlightCrewAssignmentSearchDTO flightCrewAssignmentSearchDTO) {
	
			Integer flightCrewAssignmentId = flightCrewAssignmentSearchDTO.getFlightCrewAssignmentId(); 
 			String sortBy = flightCrewAssignmentSearchDTO.getSortBy();
			String sortOrder = flightCrewAssignmentSearchDTO.getSortOrder();
			String searchQuery = flightCrewAssignmentSearchDTO.getSearchQuery();
			Integer page = flightCrewAssignmentSearchDTO.getPage();
			Integer size = flightCrewAssignmentSearchDTO.getSize();

	        Specification<FlightCrewAssignment> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, flightCrewAssignmentId, "flightCrewAssignmentId"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<FlightCrewAssignment> flightCrewAssignments = this.getAllFlightCrewAssignments(spec, pageable);
		
		//System.out.println(String.valueOf(flightCrewAssignments.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(flightCrewAssignments.getTotalPages()));
		
		List<FlightCrewAssignment> flightCrewAssignmentsList = flightCrewAssignments.getContent();
		
		FlightCrewAssignmentConvertCriteriaDTO convertCriteria = new FlightCrewAssignmentConvertCriteriaDTO();
		List<FlightCrewAssignmentDTO> flightCrewAssignmentDTOs = this.convertFlightCrewAssignmentsToFlightCrewAssignmentDTOs(flightCrewAssignmentsList,convertCriteria);
		
		FlightCrewAssignmentPageDTO flightCrewAssignmentPageDTO = new FlightCrewAssignmentPageDTO();
		flightCrewAssignmentPageDTO.setFlightCrewAssignments(flightCrewAssignmentDTOs);
		flightCrewAssignmentPageDTO.setTotalElements(flightCrewAssignments.getTotalElements());
		return ResponseEntity.ok(flightCrewAssignmentPageDTO);
	}

	public List<FlightCrewAssignmentDTO> convertFlightCrewAssignmentsToFlightCrewAssignmentDTOs(List<FlightCrewAssignment> flightCrewAssignments, FlightCrewAssignmentConvertCriteriaDTO convertCriteria) {
		
		List<FlightCrewAssignmentDTO> flightCrewAssignmentDTOs = new ArrayList<FlightCrewAssignmentDTO>();
		
		for (FlightCrewAssignment flightCrewAssignment : flightCrewAssignments) {
			flightCrewAssignmentDTOs.add(convertFlightCrewAssignmentToFlightCrewAssignmentDTO(flightCrewAssignment,convertCriteria));
		}
		
		return flightCrewAssignmentDTOs;

	}
	
	public FlightCrewAssignmentDTO convertFlightCrewAssignmentToFlightCrewAssignmentDTO(FlightCrewAssignment flightCrewAssignment, FlightCrewAssignmentConvertCriteriaDTO convertCriteria) {
		
		FlightCrewAssignmentDTO flightCrewAssignmentDTO = new FlightCrewAssignmentDTO();
		
		flightCrewAssignmentDTO.setFlightCrewAssignmentId(flightCrewAssignment.getFlightCrewAssignmentId());

	

		
		return flightCrewAssignmentDTO;
	}

	public ResultDTO updateFlightCrewAssignment(FlightCrewAssignmentDTO flightCrewAssignmentDTO, RequestDTO requestDTO) {
		
		FlightCrewAssignment flightCrewAssignment = flightCrewAssignmentDao.getById(flightCrewAssignmentDTO.getFlightCrewAssignmentId());

		flightCrewAssignment.setFlightCrewAssignmentId(ControllerUtils.setValue(flightCrewAssignment.getFlightCrewAssignmentId(), flightCrewAssignmentDTO.getFlightCrewAssignmentId()));



        flightCrewAssignment = flightCrewAssignmentDao.save(flightCrewAssignment);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public FlightCrewAssignmentDTO getFlightCrewAssignmentDTOById(Integer flightCrewAssignmentId) {
	
		FlightCrewAssignment flightCrewAssignment = flightCrewAssignmentDao.getById(flightCrewAssignmentId);
			
		
		FlightCrewAssignmentConvertCriteriaDTO convertCriteria = new FlightCrewAssignmentConvertCriteriaDTO();
		return(this.convertFlightCrewAssignmentToFlightCrewAssignmentDTO(flightCrewAssignment,convertCriteria));
	}







}
