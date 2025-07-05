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
	public void addStaffData(@RequestBody StaffRequestDto staffReqDto) {

		staffService.addStaffData(staffReqDto);

//		System.out.println(staffReqDto.getJoiningDate());
//		System.out.println(staffReqDto.getAddress());
//		System.out.println(staffReqDto.getFullName());
//		System.out.println(staffReqDto.getGender());
//		System.out.println(staffReqDto.getPhoneNumber());
//		System.out.println(staffReqDto.getEmail());
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
	public void updateStaffById(@RequestBody StaffRequestDto staffRequestDto) {

		StaffResponseDto staffResponseDto = staffService.updateStaffById(staffRequestDto);

		if (staffResponseDto != null) {
			ResponseEntity.ok("Data is Updated");
		} else {
			ResponseEntity.ok("Data is not Updated");
		}
	}

	@GetMapping("/deleteStaffById")
	public void deleteStaffById(@RequestParam int id) {

		staffService.deleteStaffById(id);
	}
}
