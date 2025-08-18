package com.rt.service;

import java.util.List;

import com.rt.dto.GenerateReceiptResponseDto;
import com.rt.dto.ReceiptRequestDto;
import com.rt.dto.ReceiptResponseDto;
import com.rt.entity.Receipt;

public interface ReceiptService {

	List<ReceiptResponseDto> getAllCheckOut();

	GenerateReceiptResponseDto generateReceiptAndRemoveCheckout(ReceiptRequestDto receiptRequestDto);

}
