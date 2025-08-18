package com.rt.service;

import java.util.List;

import com.rt.dto.CheckOutResponseDto;
import com.rt.dto.ConfirmCheckOutRequestDto;
import com.rt.dto.ReceiptResponseDto;

public interface CheckOutService {

	CheckOutResponseDto checkoutAndCalulatePrice(Long id);

	String confirmCheckOut(ConfirmCheckOutRequestDto confirmCheckOutRequestDto);

	void deleteCheckOut(Long id);

}
