package com.rt.cntrl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.dto.LoginRequestDto;
import com.rt.dto.LoginResponseDto;
import com.rt.service.LoginService;



@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	
	@PostMapping
	public ResponseEntity<LoginResponseDto> loginUser(@RequestBody @Valid LoginRequestDto reqDto) {
		LoginResponseDto resDto=loginService.login(reqDto);
		
		
		if(resDto!=null) {
			
			return ResponseEntity.status(HttpStatus.OK).body(resDto);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
		
	
		
	}
}
