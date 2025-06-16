package com.rt.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rt.dto.AddRoomsRequestDto;
import com.rt.dto.AddRoomsResponseDto;
import com.rt.service.RoomsService;

@RestController
@RequestMapping("/addRooms")
@CrossOrigin("*")
public class AddRoomsController {

	@Autowired
	private RoomsService roomsService;

	@PostMapping
	public void addRooms(@RequestBody AddRoomsRequestDto roomReqDto) {

		roomsService.addRoomsData(roomReqDto);

	}

	@GetMapping("/roomList")
	public List<AddRoomsResponseDto> getRoomList() {
		List<AddRoomsResponseDto> resDto = roomsService.getRoomList();
		return resDto;
	}

	@GetMapping("/getById")
	public AddRoomsResponseDto getById(@RequestParam Long id) {
	   
		AddRoomsResponseDto resDto=roomsService.getById(id);
		
		System.out.println(resDto.getAc_type());
		return resDto;
	}
	
	@PostMapping("/updateRoom")
	public AddRoomsResponseDto updateRoom(@RequestBody AddRoomsRequestDto reqDto) {
		
		AddRoomsResponseDto resDto=	roomsService.updateRooms(reqDto);
		
		return resDto;
		
	}
	
	@GetMapping("/delete")
	public String deleteRoom(@RequestParam Long id) {
		
		String added= roomsService.deleteRoom(id);
		return added;
	}
}
