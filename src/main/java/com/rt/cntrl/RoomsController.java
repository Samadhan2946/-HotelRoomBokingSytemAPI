package com.rt.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
public class RoomsController {

	@Autowired
	private RoomsService roomsService;

	@PostMapping
	public ResponseEntity<String> addRooms(@RequestBody AddRoomsRequestDto roomReqDto) {

		boolean isAdded=roomsService.addRoomsData(roomReqDto);
		if (isAdded) {
			return ResponseEntity.ok("room is Added");
		} else {
			return ResponseEntity.ok("room is not Added");
		}
		

	}

	@GetMapping("/roomList")
	public List<AddRoomsResponseDto> getRoomList() {
		List<AddRoomsResponseDto> resDto = roomsService.getRoomList();
		return resDto;
	}

	@GetMapping("/getById")
	public AddRoomsResponseDto getById(@RequestParam Long id) {

		AddRoomsResponseDto resDto = roomsService.getById(id);

		return resDto;
	}

	@PostMapping("/updateRoom")
	public AddRoomsResponseDto updateRoom(@RequestBody AddRoomsRequestDto reqDto) {
	
		AddRoomsResponseDto resDto = roomsService.updateRooms(reqDto);

		return resDto;

	}

	@GetMapping("/delete")
	public ResponseEntity<String> deleteRoom(@RequestParam Long id) {

		String roomDelete = roomsService.deleteRoom(id);

		if (roomDelete != null) {
			return ResponseEntity.ok("room is Deleted ");
		} else {
			return ResponseEntity.ok("room is not Deleted");
		}
	}
}
