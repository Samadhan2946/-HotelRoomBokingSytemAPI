package com.rt.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.dto.AddRoomsRequestDto;
import com.rt.dto.AddRoomsResponseDto;
import com.rt.entity.AddRooms;
import com.rt.mapper.RoomsMapper;
import com.rt.repository.AddRoomsRepository;
import com.rt.service.RoomsService;

@Service
public class RoomsServiceImpl implements RoomsService {

	@Autowired
	private AddRoomsRepository addRoomsRepository;

	@Autowired
	private RoomsMapper addRoomsMapper;

	@Override
	public boolean addRoomsData(AddRoomsRequestDto roomReqDto) {

		AddRooms addRooms = addRoomsMapper.toEntity(roomReqDto);

		boolean isAdded=addRoomsRepository.save(addRooms) != null;
		return isAdded;

	}

	public List<AddRoomsResponseDto> getRoomList() {

		return addRoomsMapper.toResponse(addRoomsRepository.findAll());
	}

	@Override
	public AddRoomsResponseDto getById(Long id) {

		Optional<AddRooms> room = addRoomsRepository.findById(id);

		if (room.isPresent()) {
			return addRoomsMapper.tores(room.get());
		} else {
			return null;
		}

	}

	@Override
	public AddRoomsResponseDto updateRooms(AddRoomsRequestDto reqDto) {

		AddRooms room = addRoomsMapper.toEntity(reqDto);
		AddRooms addRoom = addRoomsRepository.save(room);

		AddRoomsResponseDto resDto = addRoomsMapper.tores(addRoom);
		
		return resDto;

	}

	@Override
	@Transactional
	public String deleteRoom(Long id) {
		String added=addRoomsRepository.deleteAllById(id);
		return added;
		
	}
}
