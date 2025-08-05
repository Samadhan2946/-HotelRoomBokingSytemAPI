package com.rt.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rt.entity.Staff;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Integer> {

	String deleteAllById(int id);

}
