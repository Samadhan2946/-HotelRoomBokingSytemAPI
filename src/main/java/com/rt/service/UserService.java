package com.rt.service;

import javax.validation.Valid;

import com.nt.dto.UserResponseDto;

import com.rt.dto.UserRequestDto;

public interface UserService {

	boolean signUpUser(@Valid UserRequestDto userRequestDto);

	UserResponseDto loginUser(@Valid UserRequestDto userRequestDto);

}
