package com.rt.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rt.dto.AddRoomsRequestDto;
import com.rt.dto.AddRoomsResponseDto;
import com.rt.dto.CustomerRequestDto;
import com.rt.dto.CustomerResponseDto;
import com.rt.service.CustomerService;
import com.rt.service.RoomsService;

@RestController
@CrossOrigin("*")
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<String> addCustomer(@RequestBody CustomerRequestDto customerRequestDto) {

		boolean isAdded=customerService.addCustomer(customerRequestDto);
		if (isAdded) {
			return ResponseEntity.ok("Customer is Added");
		} else {
			return ResponseEntity.ok("Customer is not Added");
		}
		

	}

	@GetMapping("/customerList")
	public List<CustomerResponseDto> getCustomerList() {
		List<CustomerResponseDto> customerResponseDtos = customerService.getCustomerList();
		return customerResponseDtos;
	}

	@GetMapping("/getCustomerById")
	public CustomerResponseDto getById(@RequestParam Long id) {

		CustomerResponseDto customerResponseDto = customerService.getCustomerById(id);

		return customerResponseDto;
	}

	@PostMapping("/updateCustomer")
	public CustomerResponseDto updateCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
	
	CustomerResponseDto customerResponseDto	= customerService.updateCustomer(customerRequestDto);

		return customerResponseDto;

	}

	@GetMapping("/deleteCustomer")
	public ResponseEntity<String> deleteCustomer(@RequestParam Long id) {

		String customerDelete = customerService.deleteCustomer(id);

		if (customerDelete != null) {
			return ResponseEntity.ok("customer is Deleted ");
		} else {
			return ResponseEntity.ok("customer is not Deleted");
		}
	}

}
