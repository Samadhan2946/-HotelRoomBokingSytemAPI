package com.rt.serviceimpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.rt.dto.UserRequestDto;
import com.rt.dto.UserResponseDto;
import com.rt.entity.User;
import com.rt.mapper.UserMapper;
import com.rt.repository.UserRepository;
import com.rt.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserRepository userRepository;

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

	@Override
	public UserResponseDto loginUser(@Valid UserRequestDto userRequestDto) {

		User user = userRepository.findByEmail(userRequestDto.getEmail());

		if (user != null) {
			String pass = user.getPassword();
			if (pass.equals(userRequestDto.getPassword())) {

				UserResponseDto userResponseDto = new UserResponseDto();
				userResponseDto.setEmail(user.getEmail());
				userResponseDto.setRole(user.getRole());
				return userResponseDto;
			} else {
				throw new RuntimeException("Invalid password");
			}
		} else {
			throw new RuntimeException("User not found with email: " + userRequestDto.getEmail());
		}
	}

}
