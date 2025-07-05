package com.rt.repository;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rt.dto.SignUpRequestDto;
import com.rt.entity.SignUp;

@Repository
public interface SignUpRepository extends CrudRepository<SignUp, Integer>  {

	void save(@Valid SignUpRequestDto reqDto);

	SignUp findByEmail(String email);

}
