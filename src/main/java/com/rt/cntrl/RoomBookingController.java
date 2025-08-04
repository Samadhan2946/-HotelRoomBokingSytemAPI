package com.rt.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.RoomBookingRequestDto;
import com.rt.dto.AddRoomsResponseDto;
import com.rt.dto.CustomerRequestDto;
import com.rt.dto.CustomerResponseDto;
import com.rt.service.CustomerService;
import com.rt.service.RoomBookingService;

@RestController
@CrossOrigin("*")
@RequestMapping("/roomBooking")
public class RoomBookingController {

	@Autowired
	private RoomBookingService roomBookingService;

	@Autowired
	private CustomerService customerService;

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

	@GetMapping("/getAllCustomers")
	public List<CustomerResponseDto> getAllCustomers() {
		return customerService.getAllCustomerNames();
	}

	@PostMapping
	public ResponseEntity<String> roomBookNow(@RequestBody RoomBookingRequestDto roomBookingRequestDto) {

		boolean isAdded = roomBookingService.roomBookNow(roomBookingRequestDto);
		if (isAdded) {
			return ResponseEntity.ok("Room is Booked");
		} else {
			return ResponseEntity.ok("Room is not Booked");
		}

	}
}
