package com.rt.repository;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rt.dto.UserRequestDto;
import com.rt.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>  {

	void save(@Valid UserRequestDto userRequestDto);

	User findByEmail(String email);

}
