package com.rt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

	private Long id;

	private String fullName;

	private String email;

	private String phone;

	private String address;

	private String city;

	private String state;

	private String country;

	private String pincode;

	private String idProof;

}
