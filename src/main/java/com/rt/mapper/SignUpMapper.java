package com.rt.mapper;

import org.springframework.stereotype.Component;

import com.rt.dto.SignUpRequestDto;
import com.rt.entity.SignUp;

@Component
public class SignUpMapper {
	
	public SignUp toEntity(SignUpRequestDto reqDto) {
	
		SignUp sign=new SignUp();
		
		sign.setEmail(reqDto.getEmail());
		sign.setFirstName(reqDto.getFirstName());
		sign.setLastName(reqDto.getLastName());
		sign.setMobile(reqDto.getMobile());
		sign.setPassword(reqDto.getPassword());
		sign.setRole(reqDto.getRole());
	
		
		return sign;
	}
	
//	public void toResponse(SignUp signUp) {
//		
//	}

}
