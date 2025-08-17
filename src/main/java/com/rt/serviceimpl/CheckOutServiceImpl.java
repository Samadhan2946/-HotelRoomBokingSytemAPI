package com.rt.serviceimpl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rt.dto.CheckOutRequestDto;
import com.rt.dto.CheckOutResponseDto;
import com.rt.dto.ConfirmCheckOutRequestDto;
import com.rt.dto.ReceiptResponseDto;
import com.rt.entity.AddRooms;
import com.rt.entity.Checkout;
import com.rt.entity.Customer;
import com.rt.entity.Receipt;
import com.rt.entity.RoomBooking;
import com.rt.mapper.CheckOutMapper;
import com.rt.repository.AddRoomsRepository;
import com.rt.repository.CheckOutRepository;
import com.rt.repository.ReceiptRepository;
import com.rt.repository.RoomBookingRepository;
import com.rt.service.CheckOutService;

@Service
public class CheckOutServiceImpl implements CheckOutService {

	@Autowired
	private RoomBookingRepository roomBookingRepository;
	
	@Autowired
	private CheckOutMapper checkOutMapper;
	
	@Autowired
	private CheckOutRepository checkOutRepository;

	@Override
	public CheckOutResponseDto checkoutAndCalulatePrice(Long id) {

		Optional<RoomBooking> optionalBooking = roomBookingRepository.findById(id);

		RoomBooking booking = optionalBooking.get();

		AddRooms room = booking.getRoom();
		Customer customer = booking.getCustomer();

		// Calculate days stayed
		LocalDate bookingDate = booking.getBookingDate();
		LocalDate checkoutDate = LocalDate.now();
		long daysStayed = ChronoUnit.DAYS.between(bookingDate, checkoutDate);
		if (daysStayed <= 0) {
			daysStayed = 1; // Minimum 1 day
		}

		// Calculate amount
		double pricePerDay = room.getPrice_per_night();
		double totalAmount = daysStayed * pricePerDay;

//	    Receipt receipt = new Receipt();
//	    receipt.setCustomer(customer);
//	    receipt.setRoom(room);
//	    receipt.setBookingDate(bookingDate);
//	    receipt.setCheckoutDate(checkoutDate);
//	    receipt.setDaysStayed(daysStayed);
//	    receipt.setPricePerDay(pricePerDay);
//	    receipt.setTotalAmount(totalAmount);
//	    receiptRepository.save(receipt);

		// Update room status to Available
//	    room.setStatus("Available");
//	    addRoomsRepository.save(room);

		CheckOutResponseDto checkOutResponseDto = new CheckOutResponseDto();
		checkOutResponseDto.setCustomerName(customer.getFullName());
		checkOutResponseDto.setRoomType(room.getRoomtypes());
		checkOutResponseDto.setBookingDate(bookingDate);
		checkOutResponseDto.setCheckoutDate(checkoutDate);
		checkOutResponseDto.setDaysStayed(daysStayed);
		checkOutResponseDto.setPricePerDay(pricePerDay);
		checkOutResponseDto.setTotalAmount(totalAmount);

		return checkOutResponseDto;
	}

	@Override
	public String confirmCheckOut(ConfirmCheckOutRequestDto confirmCheckOutRequestDto) {
		Checkout checkout= checkOutMapper.toEntity(confirmCheckOutRequestDto);
	        checkOutRepository.save(checkout);
		return "CheckOut Confirmed";
	}

}