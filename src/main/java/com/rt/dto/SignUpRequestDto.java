package com.rt.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
	



	@NotNull
	@Size(max=32)
	private String firstName;
	
	@NotNull
	@Size(max=32)
	private String lastName;
	
	@NotNull
	@Size(max=32)
	private String mobile;
	
	@NotNull
	@Size(max=32)
	private String email;
	
	@NotNull
	@Size(max=32)
	private String password;
	
	
}
