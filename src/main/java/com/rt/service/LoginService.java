package com.rt.service;

import javax.validation.Valid;

import com.rt.dto.LoginRequestDto;
import com.rt.dto.LoginResponseDto;

public interface LoginService {

	LoginResponseDto login(@Valid LoginRequestDto reqDto);
	
	public void add(LoginRequestDto dto);

}
