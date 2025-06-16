package com.rt.service;

import java.util.List;


import com.rt.dto.AddRoomsRequestDto;
import com.rt.dto.AddRoomsResponseDto;

public interface RoomsService {

	void addRoomsData(AddRoomsRequestDto roomReqDto);
	
	List<AddRoomsResponseDto> getRoomList();

	AddRoomsResponseDto getById(Long id);

	AddRoomsResponseDto updateRooms(AddRoomsRequestDto reqDto);

	String deleteRoom(Long id);

}
