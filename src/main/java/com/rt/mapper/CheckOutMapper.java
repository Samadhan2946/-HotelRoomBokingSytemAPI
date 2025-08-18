package com.rt.mapper;

import org.springframework.stereotype.Component;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.rt.dto.ConfirmCheckOutRequestDto;
import com.rt.entity.Checkout;

@Component
public class CheckOutMapper {

	public Checkout toEntity(ConfirmCheckOutRequestDto confirmCheckOutRequestDto) {
		
		Checkout checkout=new Checkout();
		
		checkout.setBookingDate(confirmCheckOutRequestDto.getBookingDate());
		checkout.setCheckoutDate(confirmCheckOutRequestDto.getCheckoutDate());
		checkout.setCustomerName(confirmCheckOutRequestDto.getCustomerName());
		checkout.setDaysStayed(confirmCheckOutRequestDto.getDaysStayed());
		checkout.setPricePerDay(confirmCheckOutRequestDto.getPricePerDay());
		checkout.setRoomType(confirmCheckOutRequestDto.getRoomType());
		checkout.setTotalAmount(confirmCheckOutRequestDto.getTotalAmount());
		
		
		return checkout;
		
	}
	
	public Checkout toDeleteById(Long checkOutId) {
		
		Checkout checkout =new Checkout();
		
		checkout.setId(checkOutId);
		
		return  checkout;
		
	}
}
