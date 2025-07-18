package com.rt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.dto.AddRoomsResponseDto;
import com.rt.mapper.RoomsMapper;
import com.rt.repository.AddRoomsRepository;
import com.rt.service.RoomBookingService;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {

	@Autowired
	private AddRoomsRepository addRoomsRepository;

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

}
