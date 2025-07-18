package com.rt.mapper;

import org.springframework.stereotype.Component;


import com.rt.dto.UserRequestDto;
import com.rt.entity.User;


@Component
public class UserMapper {
	
	public User toEntity(UserRequestDto userRequestDto) {
	
		User user=new User();
		
		user.setEmail(userRequestDto.getEmail());
		user.setFirstName(userRequestDto.getFirstName());
		user.setLastName(userRequestDto.getLastName());
		user.setMobile(userRequestDto.getMobile());
		user.setPassword(userRequestDto.getPassword());
		user.setRole(userRequestDto.getRole());
	
		
		return user;
	}
	
//	public void toResponse(SignUp signUp) {
//		
//	}

}
