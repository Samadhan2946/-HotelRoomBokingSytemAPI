package com.rt.mapper;

import org.springframework.stereotype.Component;

import com.nt.dto.UserResponseDto;

import com.rt.dto.UserRequestDto;
import com.rt.entity.User;

@Component
public class UserMapper {

	public User toEntity(UserRequestDto userRequestDto) {

		User user = new User();
		user.setId(userRequestDto.getId());
		user.setEmail(userRequestDto.getEmail());
		user.setFirstName(userRequestDto.getFirstName());
		user.setLastName(userRequestDto.getLastName());
		user.setMobile(userRequestDto.getMobile());
		user.setPassword(userRequestDto.getPassword());
		user.setRole(userRequestDto.getRole());

		return user;
	}

	public UserResponseDto toResponse(User user) {
		UserResponseDto dto = new UserResponseDto();
		user.setId(user.getId());
		user.setEmail(user.getEmail());
		user.setFirstName(user.getFirstName());
		user.setLastName(user.getLastName());
		user.setMobile(user.getMobile());
		user.setPassword(user.getPassword());
		user.setRole(user.getRole());
		return dto;
	}

}
