package com.rt.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.dto.AddRoomsResponseDto;
import com.rt.service.RoomBookingService;



@RestController
@CrossOrigin("*")
@RequestMapping("/roomBooking")
public class RoomBookingController {
	
	@Autowired
	private RoomBookingService roomBookingService;
	
	
	@GetMapping("/singleRoomList")
	public List<AddRoomsResponseDto> getSingleRoomList() {
		List<AddRoomsResponseDto> resDto = roomBookingService.getSingleRoomList();
	
		return resDto;
	}
	
	

	@GetMapping("/DoubleRoomList")
	public List<AddRoomsResponseDto> getDoubleRoomList() {
		List<AddRoomsResponseDto> resDto = roomBookingService.getDoubleRoomList();
		
		return resDto;
	}


}
