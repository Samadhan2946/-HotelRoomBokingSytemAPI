package com.rt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateReceiptResponseDto {
	
private Long checkOutId;
	
	private String customerName;

	private String roomType;

	private String bookingDate;

	private String checkoutDate;

	private int daysStayed;

	private double pricePerDay;

	private double totalAmount;

	private String paymentMode; // CASH / ONLINe


}
