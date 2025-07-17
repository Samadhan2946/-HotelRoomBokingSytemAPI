package com.rt.cntrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rt.dto.StaffRequestDto;
import com.rt.dto.StaffResponseDto;
import com.rt.service.StaffService;

@RestController
@RequestMapping("/add-Staff")
@CrossOrigin("*")
public class StaffController {

	@Autowired
	private StaffService staffService;

	@PostMapping
	public ResponseEntity<String> addStaffData(@RequestBody StaffRequestDto staffReqDto) {

		boolean isAdded=staffService.addStaffData(staffReqDto);
		
	
		if (isAdded) {
			return ResponseEntity.ok("staff is added");
		} else {
			return ResponseEntity.ok("staff is not added");
		}
		

//		
	}

	@GetMapping("/room-List")
	public List<StaffResponseDto> getStaffList() {
		List<StaffResponseDto> staffResponseDtos = staffService.getStaffList();

		return staffResponseDtos;
//		
//		for(StaffResponseDto staff:staffResponseDtos) {
//			System.out.println(staff.getAddress());
//			System.out.println(staff.getDepartment());
//		}
	}

	@GetMapping("/updateStaff")
	public StaffResponseDto getStaffById(@RequestParam int id) {
		StaffResponseDto staffResponseDto = staffService.getStaffById(id);
		return staffResponseDto;
	}

	@PostMapping("/update")
	public ResponseEntity<String> updateStaffById(@RequestBody StaffRequestDto staffRequestDto) {

		StaffResponseDto staffResponseDto = staffService.updateStaffById(staffRequestDto);

		if (staffResponseDto != null) {
			return ResponseEntity.ok("staff is Updated");
		} else {
			return ResponseEntity.ok("staff is not Updated");
		}
	}

	@GetMapping("/deleteStaffById")
	public ResponseEntity<String> deleteStaffById(@RequestParam int id) {

		String isDelete=staffService.deleteStaffById(id);
		

		if (isDelete != null) {
			return ResponseEntity.ok("staff is Deleted ");
		} else {
			return ResponseEntity.ok("staff is not Deleted");
		}
	}
}
