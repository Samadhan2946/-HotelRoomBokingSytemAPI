package com.rt.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckOutResponseDto {
	
	private Long id;
	private String customerName;
	private String roomType;
	private LocalDate bookingDate;
	private LocalDate checkoutDate;
	private long daysStayed;
	private double pricePerDay;
	private double totalAmount;

}

