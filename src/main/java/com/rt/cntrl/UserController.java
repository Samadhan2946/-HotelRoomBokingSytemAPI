package com.rt.cntrl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.dto.UserRequestDto;
import com.rt.dto.UserResponseDto;
import com.rt.service.UserService;

@RestController
@RequestMapping("/signUp_user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<String> signUpUser(@RequestBody @Valid UserRequestDto userRequestDto) {

		boolean isAdded = userService.signUpUser(userRequestDto);

		if (isAdded) {
			return ResponseEntity.ok("Data is saved to Database Successfully");
		} else {
			return ResponseEntity.ok("Data is Not Added");
		}

	}

	@PostMapping("/login")
	public ResponseEntity<UserResponseDto> login(@RequestBody @Valid UserRequestDto userRequestDto) {
		UserResponseDto resDto = userService.loginUser(userRequestDto);

		if (resDto != null) {

			return ResponseEntity.status(HttpStatus.OK).body(resDto);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}

	}
}
