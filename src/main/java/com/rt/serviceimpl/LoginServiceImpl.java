 package com.rt.serviceimpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.dto.LoginRequestDto;
import com.rt.dto.LoginResponseDto;
import com.rt.entity.Login;
import com.rt.entity.SignUp;
import com.rt.mapper.LoginMapper;
import com.rt.repository.LoginRepository;
import com.rt.repository.SignUpRepository;
import com.rt.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private SignUpRepository signUpRepository;
    
	@Override
	public LoginResponseDto login(@Valid LoginRequestDto reqDto) {
		
		
		Login login=loginRepository.findByEmail(reqDto.getEmail());
		
		if(login !=null ) {
			if(login.getRole().equals("Admin")	) {		
					
				SignUp signUp=signUpRepository.findByEmail(login.getEmail());
				LoginResponseDto resDto=loginMapper.toResposeDto(login);
				resDto.setEmail(signUp.getEmail());
				resDto.setPassword(signUp.getPassword());
				
				return resDto;
				
			}else if(login.getRole().equals("Customer")) {
					
					SignUp signUp=signUpRepository.findByEmail(login.getEmail());
					LoginResponseDto resDto=loginMapper.toResposeDto(login);
					resDto.setEmail(signUp.getEmail());
					resDto.setPassword(signUp.getPassword());
					
					return resDto;
					
					
				}
				
//				return resDto;
				
			}
		
		return null;
	}

	@Override
	public void add(LoginRequestDto dto) {
		Login login=loginMapper.toLoginEntity(dto);
		loginRepository.save(login);
		
		
		
	}
	
	

}
