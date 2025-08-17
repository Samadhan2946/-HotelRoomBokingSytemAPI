package com.rt.service;

import java.util.List;

import com.rt.dto.AddRoomsResponseDto;
import com.rt.dto.RoomBookingRequestDto;
import com.rt.dto.RoomBookingResponseDto;

public interface RoomBookingService {

	List<AddRoomsResponseDto> getSingleRoomList();

	List<AddRoomsResponseDto> getDoubleRoomList();

	boolean roomBookNow(RoomBookingRequestDto roomBookingRequestDto);

	List<RoomBookingResponseDto> getAllBookings();

	
}
