package com.rt.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;


import com.rt.dto.AddRoomsRequestDto;
import com.rt.dto.AddRoomsResponseDto;
import com.rt.entity.AddRooms;

@Component
public class RoomsMapper {

	public AddRooms toEntity(AddRoomsRequestDto reqDto) {
		
		AddRooms add=new AddRooms();
		add.setId(reqDto.getId());
		add.setAc_type(reqDto.getAc_type());
		add.setRoomtypes(reqDto.getRoom_types());
		add.setRoom_number(reqDto.getRoom_number());
		add.setBed_count(reqDto.getBed_count());
		add.setPrice_per_night(reqDto.getPrice_per_night());
		add.setDescription(reqDto.getDescription());
		add.setRoom_image_path(reqDto.getRoom_image_path());
		add.setStatus(reqDto.getStatus());
		
		return add;
	}
	
	public List<AddRoomsResponseDto> toResponse(Iterable<AddRooms> iterable) {
		List<AddRoomsResponseDto> resDtoList=new ArrayList<AddRoomsResponseDto>();
		
		for(AddRooms add:iterable) {
			
			AddRoomsResponseDto resDto=new AddRoomsResponseDto();
			resDto.setAc_type(add.getAc_type());
			resDto.setId(add.getId());
			resDto.setBed_count(add.getBed_count());
			resDto.setDescription(add.getDescription());
			resDto.setPrice_per_night(add.getPrice_per_night());
			resDto.setRoom_image_path(add.getRoom_image_path());
		    resDto.setRoom_types(add.getRoomtypes());
		    resDto.setStatus(add.getStatus());
		    
		    resDtoList.add(resDto);
		}
		
		return resDtoList;
	}

	

	public AddRoomsResponseDto tores(AddRooms addRooms) {
		
		AddRoomsResponseDto resDto=new AddRoomsResponseDto();
		
		resDto.setId(addRooms.getId());
		resDto.setAc_type(addRooms.getAc_type());
		resDto.setRoom_types(addRooms.getRoomtypes());
		resDto.setRoom_number(addRooms.getRoom_number());
		resDto.setBed_count(addRooms.getBed_count());
		resDto.setPrice_per_night(addRooms.getPrice_per_night());
		resDto.setDescription(addRooms.getDescription());
		resDto.setRoom_image_path(addRooms.getRoom_image_path());
		resDto.setStatus(addRooms.getStatus());
		
		return resDto;
	}
	
}
