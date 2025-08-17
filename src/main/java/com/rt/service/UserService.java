package com.rt.service;

import javax.validation.Valid;

import com.rt.dto.UserRequestDto;
import com.rt.dto.UserResponseDto;

public interface UserService {

	boolean signUpUser(@Valid UserRequestDto userRequestDto);

	UserResponseDto loginUser(@Valid UserRequestDto userRequestDto);

}
