package com.rt.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rt.dto.CheckOutResponseDto;
import com.rt.dto.ConfirmCheckOutRequestDto;
import com.rt.dto.CustomerResponseDto;
import com.rt.dto.ReceiptResponseDto;
import com.rt.service.CheckOutService;

@RestController
@RequestMapping("/checkoutApi")
@CrossOrigin("*")
public class CheckOutController {

	@Autowired
	private CheckOutService checkOutService;

	@GetMapping
	public ResponseEntity<CheckOutResponseDto> checkoutAndCalculatePrice(@RequestParam("id") Long id) {
		CheckOutResponseDto checkOutResponseDto = checkOutService.checkoutAndCalulatePrice(id);
		return ResponseEntity.ok(checkOutResponseDto);
	}

	@PostMapping("/confirmCheckOut")
	public ResponseEntity<String> confirmCheckOut(@RequestBody ConfirmCheckOutRequestDto confirmCheckOutRequestDto) {
		checkOutService.confirmCheckOut(confirmCheckOutRequestDto);
		return ResponseEntity.ok("CheckOut Confirmed");
	}

}
