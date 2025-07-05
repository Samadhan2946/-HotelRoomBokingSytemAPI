package com.rt.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.loading.PrivateClassLoader;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.dto.StaffRequestDto;
import com.rt.dto.StaffResponseDto;
import com.rt.entity.AddRooms;
import com.rt.entity.Staff;
import com.rt.mapper.StaffMapper;
import com.rt.repository.StaffRepository;
import com.rt.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffMapper staffMapper;

	@Autowired
	private StaffRepository staffRepository;

	@Override
	public boolean addStaffData(StaffRequestDto staffReqDto) {

		Staff staff = staffMapper.toEntity(staffReqDto);

		boolean isAdded = staffRepository.save(staff) != null;

		if (isAdded) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<StaffResponseDto> getStaffList() {
	
		return staffMapper.toResponse(staffRepository.findAll());

	}

	@Override
	public StaffResponseDto getStaffById(int id) {
		Optional<Staff> staff = staffRepository.findById(id);

		if (staff.isPresent()) {
			return staffMapper.toRes(staff.get());
		} else {
			return null;
		}
	}

	@Override
	public StaffResponseDto updateStaffById(StaffRequestDto staffRequestDto) {
		Staff staff= staffMapper.toEntity(staffRequestDto);
		Staff addStaff= staffRepository.save(staff);
		
		StaffResponseDto staffResponseDto= staffMapper.toRes(addStaff);
		
		return staffResponseDto;
		
		
		
		
		
	}

	@Override
	@Transactional
	public String deleteStaffById(int id) {
		String added=staffRepository.deleteAllById(id);
		return added;
		
	}

}
