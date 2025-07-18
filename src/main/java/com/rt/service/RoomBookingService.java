package com.rt.service;

import java.util.List;

import com.rt.dto.AddRoomsResponseDto;

public interface RoomBookingService {

	List<AddRoomsResponseDto> getSingleRoomList();

	List<AddRoomsResponseDto> getDoubleRoomList();

}
