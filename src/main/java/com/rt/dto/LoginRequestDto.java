package com.rt.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {

	
	
	@NotNull
	@Size(max=32)
	private String email;
	
	@NotNull
	@Size(max=32)
	private String password;

	
	@NotNull
	@Size(max=32)
	private String role;
   
	
}
