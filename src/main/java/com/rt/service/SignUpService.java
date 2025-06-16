package com.rt.service;

import javax.validation.Valid;

import com.rt.dto.SignUpRequestDto;

public interface SignUpService {

	boolean signUpUser(@Valid SignUpRequestDto reqDto);

}
