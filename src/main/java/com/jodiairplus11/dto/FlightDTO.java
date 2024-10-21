package com.jodiairplus11.dto;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.time.Year;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class FlightDTO {

	private Integer flightId;

	private DateTime departureTime;

	private DateTime arrivalTime;

	private Double duration;

	private String status;






}
