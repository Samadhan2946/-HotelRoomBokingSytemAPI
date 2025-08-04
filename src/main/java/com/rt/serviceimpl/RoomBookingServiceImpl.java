package com.rt.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.RoomBookingRequestDto;
import com.rt.dto.AddRoomsResponseDto;
import com.rt.entity.RoomBooking;
import com.rt.mapper.RoomsMapper;
import com.rt.repository.AddRoomsRepository;
import com.rt.repository.RoomBookingRepository;
import com.rt.service.RoomBookingService;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {

	@Autowired
	private AddRoomsRepository addRoomsRepository;

	@Autowired
	private RoomBookingRepository roomBookingRepository;

	@Autowired
	private RoomsMapper roomsMapper;

	@Override
	public List<AddRoomsResponseDto> getSingleRoomList() {
		return roomsMapper.toResponse(addRoomsRepository.findByRoomtypesIgnoreCase("SINGLE ROOM"));

	}

	@Override
	public List<AddRoomsResponseDto> getDoubleRoomList() {
		return roomsMapper.toResponse(addRoomsRepository.findByRoomtypesIgnoreCase("Double ROOM"));

	}

	@Override
	@Transactional
	public boolean roomBookNow(RoomBookingRequestDto dto) {

		RoomBooking booking = new RoomBooking();
		booking.setCustomerId(dto.getCustomerId());
		booking.setId(dto.getId()); // room_id
		booking.setBookingDate(LocalDate.now());

		roomBookingRepository.save(booking);

		addRoomsRepository.updateRoomStatus(dto.getId(), "BOOKED");

		return true;
	}

}
