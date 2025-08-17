package com.rt.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rt.entity.AddRooms;
import com.rt.entity.RoomBooking;

@Repository
public interface RoomBookingRepository extends CrudRepository<RoomBooking, Integer> {

	void save(AddRooms room);

	Optional<RoomBooking> findById(Long id);

}
