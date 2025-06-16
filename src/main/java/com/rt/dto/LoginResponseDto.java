package com.rt.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

	private int id;
	
	@NotNull
	@Size(max=32)
	private String email;
	
	@NotNull
	@Size(max=32)
	private String password;
	
	private String role;
}
