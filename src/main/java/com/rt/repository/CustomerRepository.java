package com.rt.repository;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rt.entity.AddRooms;
import com.rt.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	Optional<Customer> findById(Long id);

	String deleteAllById(Long id);

}
