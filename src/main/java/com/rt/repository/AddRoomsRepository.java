package com.rt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rt.dto.AddRoomsResponseDto;
import com.rt.entity.AddRooms;

@Repository
public interface AddRoomsRepository extends CrudRepository<AddRooms, Integer> {

	Optional<AddRooms> findById(Long id);

	String deleteAllById(Long id);

	Iterable<AddRooms> findByRoomtypesIgnoreCase(String string);

}
