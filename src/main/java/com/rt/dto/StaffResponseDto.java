package com.rt.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffResponseDto {

	private int id;

	private String fullName;
	private String email;
	private String phoneNumber;
	private String gender;

	/*
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate dateOfBirth;
	 */

	private String address;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;

	private String department; // Dropdown: Manager, Cleaner, Receptionist

}
