package com.rt.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptResponseDto {

	private Long id;

	private String customerName;

	private String roomType;

	private String bookingDate;

	private String checkoutDate;

	private int daysStayed;

	private double pricePerDay;

	private double totalAmount;

}
