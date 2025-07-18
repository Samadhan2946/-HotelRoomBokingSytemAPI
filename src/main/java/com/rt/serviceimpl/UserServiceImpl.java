package com.rt.serviceimpl;

import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.dto.UserRequestDto;
import com.rt.mapper.UserMapper;
import com.rt.repository.UserRepository;
import com.rt.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean signUpUser(@Valid UserRequestDto userRequestDto) {
		com.rt.entity.User user = userMapper.toEntity(userRequestDto);

		if (user != null) {
			userRepository.save(user);
			return true;
		} else {
			return false;
		}
	}

}
