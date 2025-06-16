package com.rt.cntrl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.dto.SignUpRequestDto;
import com.rt.service.SignUpService;

import lombok.val;

@RestController
@RequestMapping("/signUp_user")
@CrossOrigin("*")
public class SignUpController {
	
	@Autowired
	private SignUpService signUpService; 
	
	@PostMapping
	public ResponseEntity<String> signUpUser(@RequestBody @Valid SignUpRequestDto reqDto ) {
		
		boolean isAdded=signUpService.signUpUser(reqDto);
		
		if(isAdded) {
			return ResponseEntity.ok("Data is saved to Database Successfully");
		}else {
			return ResponseEntity.ok("Data is Not Added");
		}
		
		
//		System.out.println(reqDto.getFirstName());
//		System.out.println(reqDto.getLastName());
//		System.out.println(reqDto.getEmail());
//		System.out.println(reqDto.getMobile());
//		System.out.println(reqDto.getPassword());
//		System.out.println(reqDto.getRole());
	}

}
