package com.rt.repository;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;

import com.rt.dto.LoginRequestDto;
import com.rt.entity.Login;

public interface LoginRepository extends CrudRepository<Login, Integer>  {

	

	Login findByEmail(String email);

	
}
