package com.rt.service;

import java.util.ArrayList;
import java.util.List;

import com.rt.dto.StaffRequestDto;
import com.rt.dto.StaffResponseDto;

public interface StaffService {

	boolean addStaffData(StaffRequestDto staffReqDto);

	List<StaffResponseDto> getStaffList();

	

	StaffResponseDto getStaffById(int id);

	StaffResponseDto updateStaffById(StaffRequestDto staffRequestDto);

	String deleteStaffById(int id);

}
