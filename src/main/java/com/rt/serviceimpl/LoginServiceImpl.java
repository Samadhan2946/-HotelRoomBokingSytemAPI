 package com.rt.serviceimpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.dto.LoginRequestDto;
import com.rt.dto.LoginResponseDto;
import com.rt.entity.Login;
import com.rt.mapper.LoginMapper;
import com.rt.repository.LoginRepository;
import com.rt.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public LoginResponseDto login(@Valid LoginRequestDto reqDto) {
		
		System.out.println(reqDto.getPassword());
		System.out.println(reqDto.getEmail());
		
		Login login=loginRepository.findByEmail(reqDto.getEmail());
		
		if(login !=null ) {
			
				Login login2=loginRepository.findByEmail(reqDto.getEmail());
				LoginResponseDto resDto=loginMapper.toResposeDto(login2);
				resDto.setEmail(login2.getEmail());
				resDto.setPassword(login2.getPassword());
				resDto.setRole(login2.getRole());
				
				return resDto;
				
			}
		
		return null;
	}

	@Override
	public void add(LoginRequestDto dto) {
		Login login=loginMapper.toLoginEntity(dto);
		loginRepository.save(login);
		
		
		
	}
	
	

}
