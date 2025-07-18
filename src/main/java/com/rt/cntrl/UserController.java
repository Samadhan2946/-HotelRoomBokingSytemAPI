package com.rt.cntrl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.dto.UserRequestDto;
import com.rt.service.UserService;

import lombok.val;

@RestController
@RequestMapping("/signUp_user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	@PostMapping
	public ResponseEntity<String> signUpUser(@RequestBody @Valid UserRequestDto userRequestDto ) {
		
		boolean isAdded=userService.signUpUser(userRequestDto);
		
		if(isAdded) {
			return ResponseEntity.ok("Data is saved to Database Successfully");
		}else {
			return ResponseEntity.ok("Data is Not Added");
		}
		
		
		}

}
