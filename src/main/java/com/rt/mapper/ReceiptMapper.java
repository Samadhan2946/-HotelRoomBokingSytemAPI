package com.rt.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rt.dto.AddRoomsResponseDto;
import com.rt.dto.GenerateReceiptResponseDto;
import com.rt.dto.ReceiptRequestDto;
import com.rt.dto.ReceiptResponseDto;
import com.rt.entity.Checkout;
import com.rt.entity.Receipt;

@Component
public class ReceiptMapper {

	public List<ReceiptResponseDto> listToResponse(Iterable<Checkout> iterable) {
		List<ReceiptResponseDto> resDtoList = new ArrayList<>();

		for (Checkout checkout : iterable) {
			ReceiptResponseDto receiptResponseDto = new ReceiptResponseDto();
			receiptResponseDto.setBookingDate(checkout.getBookingDate());
			receiptResponseDto.setCheckoutDate(checkout.getCheckoutDate());
			receiptResponseDto.setCustomerName(checkout.getCustomerName());
			receiptResponseDto.setDaysStayed(checkout.getDaysStayed());
			receiptResponseDto.setId(checkout.getId());
			receiptResponseDto.setPricePerDay(checkout.getPricePerDay());
			receiptResponseDto.setRoomType(checkout.getRoomType());
			receiptResponseDto.setTotalAmount(checkout.getTotalAmount());

			resDtoList.add(receiptResponseDto);
		}

		return resDtoList;
	}
	
	
	public Receipt toEntity(ReceiptRequestDto receiptRequestDto) {
		Receipt receipt=new Receipt();
		
		receipt.setBookingDate(receiptRequestDto.getBookingDate());
		receipt.setCheckoutDate(receiptRequestDto.getCheckoutDate());
		receipt.setCustomerName(receiptRequestDto.getCustomerName());
		receipt.setDaysStayed(receiptRequestDto.getDaysStayed());
		
		receipt.setPricePerDay(receiptRequestDto.getPricePerDay());
		receipt.setRoomType(receiptRequestDto.getRoomType());
		receipt.setTotalAmount(receiptRequestDto.getTotalAmount());
		receipt.setPaymentMode(receiptRequestDto.getPaymentMode());
		
		return receipt;
		
	}


	public GenerateReceiptResponseDto tores(Receipt savedReceipt) {
         GenerateReceiptResponseDto generateReceiptResponseDto=new GenerateReceiptResponseDto();
         
         generateReceiptResponseDto.setBookingDate(savedReceipt.getBookingDate());
         generateReceiptResponseDto.setCheckoutDate(savedReceipt.getCheckoutDate());
         generateReceiptResponseDto.setCheckOutId(savedReceipt.getId());
         generateReceiptResponseDto.setCustomerName(savedReceipt.getCustomerName());
         generateReceiptResponseDto.setDaysStayed(savedReceipt.getDaysStayed());
         generateReceiptResponseDto.setPaymentMode(savedReceipt.getPaymentMode());
         generateReceiptResponseDto.setPricePerDay(savedReceipt.getPricePerDay());
         generateReceiptResponseDto.setRoomType(savedReceipt.getRoomType());
         generateReceiptResponseDto.setTotalAmount(savedReceipt.getTotalAmount());
		
		
		
		return generateReceiptResponseDto;
	}

}
