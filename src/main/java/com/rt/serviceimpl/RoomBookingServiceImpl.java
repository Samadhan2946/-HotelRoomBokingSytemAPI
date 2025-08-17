package com.rt.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.dto.AddRoomsResponseDto;
import com.rt.dto.RoomBookingRequestDto;
import com.rt.dto.RoomBookingResponseDto;
import com.rt.entity.AddRooms;
import com.rt.entity.Customer;
import com.rt.entity.RoomBooking;
import com.rt.mapper.RoomBookingMapper;
import com.rt.mapper.RoomsMapper;
import com.rt.repository.AddRoomsRepository;
import com.rt.repository.CustomerRepository;
import com.rt.repository.RoomBookingRepository;
import com.rt.service.RoomBookingService;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {

	@Autowired
	private AddRoomsRepository addRoomsRepository;

	@Autowired
	private RoomBookingRepository roomBookingRepository;

	@Autowired
	private RoomsMapper roomsMapper;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RoomBookingMapper roomBookingMapper;

	@Override
	public List<AddRoomsResponseDto> getSingleRoomList() {
		return roomsMapper.toResponse(addRoomsRepository.findByRoomtypesIgnoreCase("SINGLE ROOM"));

	}

	@Override
	public List<AddRoomsResponseDto> getDoubleRoomList() {
		return roomsMapper.toResponse(addRoomsRepository.findByRoomtypesIgnoreCase("Double ROOM"));

	}

	@Override
	@Transactional
	public boolean roomBookNow(RoomBookingRequestDto dto) {

		Customer customer = customerRepository.findById(dto.getCustomerId())
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		AddRooms room = addRoomsRepository.findById(dto.getId())
				.orElseThrow(() -> new RuntimeException("Room not found"));

		RoomBooking booking = new RoomBooking();
		booking.setCustomer(customer);
		booking.setRoom(room);
		booking.setBookingDate(LocalDate.now());

		roomBookingRepository.save(booking);

		addRoomsRepository.updateRoomStatus(dto.getId(), "BOOKED");

		return true;
	}

	@Override
	public List<RoomBookingResponseDto> getAllBookings() {
		return roomBookingMapper.listToResponse(roomBookingRepository.findAll());
	}

}
