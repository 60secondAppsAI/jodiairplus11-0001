package com.jodiairplus11.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.jodiairplus11.domain.Aircraft;
import com.jodiairplus11.dto.AircraftDTO;
import com.jodiairplus11.dto.AircraftSearchDTO;
import com.jodiairplus11.dto.AircraftPageDTO;
import com.jodiairplus11.dto.AircraftConvertCriteriaDTO;
import com.jodiairplus11.service.GenericService;
import com.jodiairplus11.dto.common.RequestDTO;
import com.jodiairplus11.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface AircraftService extends GenericService<Aircraft, Integer> {

	List<Aircraft> findAll();

	ResultDTO addAircraft(AircraftDTO aircraftDTO, RequestDTO requestDTO);

	ResultDTO updateAircraft(AircraftDTO aircraftDTO, RequestDTO requestDTO);

    Page<Aircraft> getAllAircrafts(Pageable pageable);

    Page<Aircraft> getAllAircrafts(Specification<Aircraft> spec, Pageable pageable);

	ResponseEntity<AircraftPageDTO> getAircrafts(AircraftSearchDTO aircraftSearchDTO);
	
	List<AircraftDTO> convertAircraftsToAircraftDTOs(List<Aircraft> aircrafts, AircraftConvertCriteriaDTO convertCriteria);

	AircraftDTO getAircraftDTOById(Integer aircraftId);







}





