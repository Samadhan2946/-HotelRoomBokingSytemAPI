package com.rt.mapper;

import org.springframework.stereotype.Component;

import com.rt.dto.LoginRequestDto;
import com.rt.dto.LoginResponseDto;
import com.rt.entity.Login;

@Component
public class LoginMapper {
	
	public Login toLoginEntity(LoginRequestDto reqDto) {
		Login login=new Login();
		
		login.setEmail(reqDto.getEmail());
		login.setPassword(reqDto.getPassword());
		login.setRole(reqDto.getRole());
		
		return login;
	}
	
	public LoginResponseDto toResposeDto(Login login2) {
		LoginResponseDto dto=new LoginResponseDto();
		dto.setEmail(login2.getEmail());
		dto.setPassword(login2.getPassword());
		dto.setRole(login2.getRole());
		
		return dto;
	}

}
