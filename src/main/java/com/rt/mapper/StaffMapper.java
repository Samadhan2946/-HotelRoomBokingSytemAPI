package com.rt.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rt.dto.StaffRequestDto;
import com.rt.dto.StaffResponseDto;
import com.rt.entity.Staff;



@Component
public class StaffMapper {
	
	public Staff toEntity(StaffRequestDto staffRequestDto) {
		
		Staff staff=new Staff();
		
		staff.setAddress(staffRequestDto.getAddress());
		staff.setDepartment(staffRequestDto.getDepartment());
		staff.setEmail(staffRequestDto.getEmail());
		staff.setFullName(staffRequestDto.getFullName());
		staff.setGender(staffRequestDto.getGender());
		staff.setJoiningDate(staffRequestDto.getJoiningDate());
		staff.setPhoneNumber(staffRequestDto.getPhoneNumber());
		staff.setId(staffRequestDto.getId());
		
		return staff;
		
	}
	
	public List<StaffResponseDto> toResponse(Iterable<Staff> staff) {
		
		List<StaffResponseDto> toResponseDto=new ArrayList<StaffResponseDto>();
		
		for(Staff fromStaff:staff) {
			
			StaffResponseDto staffResponseDto=new StaffResponseDto();
			
			staffResponseDto.setAddress(fromStaff.getAddress());
			staffResponseDto.setDepartment(fromStaff.getDepartment());
			staffResponseDto.setEmail(fromStaff.getEmail());
			staffResponseDto.setFullName(fromStaff.getFullName());
			staffResponseDto.setGender(fromStaff.getGender());
			staffResponseDto.setJoiningDate(fromStaff.getJoiningDate());
			staffResponseDto.setPhoneNumber(fromStaff.getPhoneNumber());
			staffResponseDto.setId(fromStaff.getId());
			
		   toResponseDto.add(staffResponseDto);
			
		}
		return toResponseDto;
		
		
	}
	
public StaffResponseDto toRes(Staff staff) {
		
		StaffResponseDto staffRequestDto=new StaffResponseDto();
		
		staffRequestDto.setAddress(staff.getAddress());
		staffRequestDto.setDepartment(staff.getDepartment());
		staffRequestDto.setEmail(staff.getEmail());
		staffRequestDto.setFullName(staff.getFullName());
		staffRequestDto.setGender(staff.getGender());
		staffRequestDto.setJoiningDate(staff.getJoiningDate());
		staffRequestDto.setPhoneNumber(staff.getPhoneNumber());
		
		staffRequestDto.setId(staff.getId());
		
		return staffRequestDto;
		
	}

}
