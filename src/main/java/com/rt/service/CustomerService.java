package com.rt.service;



import java.util.List;

import com.rt.dto.CustomerRequestDto;
import com.rt.dto.CustomerResponseDto;


public interface CustomerService {

	boolean addCustomer(CustomerRequestDto customerRequestDto);

	List<CustomerResponseDto> getCustomerList();

	CustomerResponseDto getCustomerById(Long id);

	CustomerResponseDto updateCustomer(CustomerRequestDto customerRequestDto);

	String deleteCustomer(Long id);

}
