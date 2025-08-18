package com.rt.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.dto.GenerateReceiptResponseDto;
import com.rt.dto.ReceiptRequestDto;
import com.rt.dto.ReceiptResponseDto;
import com.rt.dto.RoomBookingResponseDto;
import com.rt.entity.Receipt;
import com.rt.service.CheckOutService;
import com.rt.service.ReceiptService;

@RestController
@RequestMapping("/generateReceipt")
@CrossOrigin("*")
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;

	@Autowired
	private CheckOutService checkOutService;

	@GetMapping("/getAllCheckOut")
	public List<ReceiptResponseDto> getAllCheckOut() {
		return receiptService.getAllCheckOut();
	}

	@PostMapping("/generateReceiptAndRemoveCheckout")
	public GenerateReceiptResponseDto generateReceiptAndRemoveCheckout(@RequestBody ReceiptRequestDto receiptRequestDto) {
		GenerateReceiptResponseDto generateReceiptResponseDto = receiptService.generateReceiptAndRemoveCheckout(receiptRequestDto);
		checkOutService.deleteCheckOut(receiptRequestDto.getId());

		return generateReceiptResponseDto;

	}

}
