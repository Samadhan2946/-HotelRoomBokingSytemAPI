package com.rt.repository;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rt.entity.RoomBooking;

@Repository
public interface RoomBookingRepository extends CrudRepository<RoomBooking, Integer> {

	
	
	 
}
