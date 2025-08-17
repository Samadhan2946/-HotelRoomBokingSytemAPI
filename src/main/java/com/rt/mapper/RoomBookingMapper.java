package com.rt.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rt.dto.CustomerResponseDto;
import com.rt.dto.RoomBookingResponseDto;
import com.rt.entity.Customer;
import com.rt.entity.RoomBooking;

@Component
public class RoomBookingMapper {

	public List<RoomBookingResponseDto> listToResponse(Iterable<RoomBooking> iterable) {
		List<RoomBookingResponseDto> resDtoList = new ArrayList<>();

		for (RoomBooking roomBooking : iterable) {
			RoomBookingResponseDto resDto = new RoomBookingResponseDto();
			resDto.setId(roomBooking.getId());
			resDto.setFullName(roomBooking.getCustomer().getFullName());
			resDto.setBedCount(roomBooking.getRoom().getBed_count());
			resDto.setPricePerNight(roomBooking.getRoom().getPrice_per_night());
			resDto.setStatus(roomBooking.getRoom().getStatus());
			resDto.setBooking_date(roomBooking.getBookingDate());
			resDto.setRoomId(roomBooking.getRoom().getId());

			resDtoList.add(resDto);
		}

		return resDtoList;
	}

}
