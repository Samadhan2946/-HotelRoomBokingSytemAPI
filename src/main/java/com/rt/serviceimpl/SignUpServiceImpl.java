package com.rt.serviceimpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.dto.SignUpRequestDto;
import com.rt.entity.SignUp;
import com.rt.mapper.SignUpMapper;
import com.rt.repository.SignUpRepository;
import com.rt.service.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {
	
	
	@Autowired
	private SignUpRepository signUpRepository;
	
	@Autowired
	private SignUpMapper signUpMapper ;
  
	@Override
	public boolean signUpUser(@Valid SignUpRequestDto reqDto) {
		SignUp sign=signUpMapper.toEntity(reqDto);
		
		if(sign!=null) {
			signUpRepository.save(sign);
			return true;
		}else {
			return false;
		}
		
		
		
		
	}

}
