package com.rt.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rt.entity.AddRooms;

@Repository
public interface AddRoomsRepository extends CrudRepository<AddRooms, Integer> {

	Optional<AddRooms> findById(Long id);

	String deleteAllById(Long id);

	Iterable<AddRooms> findByRoomtypesIgnoreCase(String string);

	@Modifying
    @Transactional
    @Query("UPDATE AddRooms r SET r.status = :status WHERE r.id = :roomId")
    void updateRoomStatus(@Param("roomId") Long roomId, @Param("status") String status);


}
