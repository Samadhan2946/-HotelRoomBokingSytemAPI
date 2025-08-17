package com.rt.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomBookingResponseDto {
	
	private Long id;
	private String fullName;

	private Long roomId;
	private int bedCount;
	private double pricePerNight;
	private String status;

	private LocalDate booking_date;

}
