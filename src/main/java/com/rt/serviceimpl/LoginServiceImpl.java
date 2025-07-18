	package com.rt.serviceimpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.dto.LoginRequestDto;
import com.rt.dto.LoginResponseDto;
import com.rt.entity.Login;

import com.rt.entity.User;
import com.rt.mapper.LoginMapper;
import com.rt.repository.LoginRepository;

import com.rt.repository.UserRepository;
import com.rt.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public LoginResponseDto login(@Valid LoginRequestDto reqDto) {

		Login login = loginRepository.findByEmail(reqDto.getEmail());

		if (login != null) {
			if (login.getRole().equals("Admin")) {

				Login login2 = loginRepository.findByEmail(login.getEmail());
				LoginResponseDto resDto = loginMapper.toResposeDto(login);
				resDto.setEmail(login2.getEmail());
				resDto.setPassword(login2.getPassword());

				return resDto;

			} else if (login.getRole().equals("Customer")) {

				User user = userRepository.findByEmail(login.getEmail());
				LoginResponseDto resDto = loginMapper.toResposeDto(login);
				resDto.setEmail(user.getEmail());
				resDto.setPassword(user.getPassword());

				return resDto;

			}

//				return resDto;

		}

		return null;
	}

	@Override
	public void add(LoginRequestDto dto) {
		Login login = loginMapper.toLoginEntity(dto);
		loginRepository.save(login);

	}

}
