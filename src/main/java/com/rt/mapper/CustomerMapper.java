package com.rt.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rt.dto.AddRoomsRequestDto;
import com.rt.dto.AddRoomsResponseDto;
import com.rt.dto.CustomerRequestDto;
import com.rt.dto.CustomerResponseDto;
import com.rt.entity.AddRooms;
import com.rt.entity.Customer;

@Component
public class CustomerMapper {

	public Customer toEntity(CustomerRequestDto customerRequestDto) {

		Customer customer = new Customer();

		customer.setFullName(customerRequestDto.getFullName());
		customer.setAddress(customerRequestDto.getAddress());
		customer.setCity(customerRequestDto.getCity());
		customer.setCountry(customerRequestDto.getCountry());
		customer.setEmail(customerRequestDto.getEmail());
		customer.setId(customerRequestDto.getId());
		customer.setIdProof(customerRequestDto.getIdProof());
		customer.setPhone(customerRequestDto.getPhone());
		customer.setPincode(customerRequestDto.getPincode());
		customer.setState(customerRequestDto.getState());

		return customer;
	}

	public List<CustomerResponseDto> listToResponse(Iterable<Customer> iterable) {
		List<CustomerResponseDto> resDtoList = new ArrayList<>();

		for (Customer customer : iterable) {
			CustomerResponseDto resDto = new CustomerResponseDto();
			resDto.setId(customer.getId());
			resDto.setFullName(customer.getFullName());
			resDto.setEmail(customer.getEmail());
			resDto.setPhone(customer.getPhone());
			resDto.setAddress(customer.getAddress());
			resDto.setCity(customer.getCity());
			resDto.setState(customer.getState());
			resDto.setCountry(customer.getCountry());
			resDto.setPincode(customer.getPincode());
			resDto.setIdProof(customer.getIdProof());

			resDtoList.add(resDto);
		}

		return resDtoList;
	}

	public CustomerResponseDto toResponseById(Customer customer) {
		CustomerResponseDto resDto = new CustomerResponseDto();

		resDto.setId(customer.getId());
		resDto.setFullName(customer.getFullName());
		resDto.setEmail(customer.getEmail());
		resDto.setPhone(customer.getPhone());
		resDto.setAddress(customer.getAddress());
		resDto.setCity(customer.getCity());
		resDto.setState(customer.getState());
		resDto.setCountry(customer.getCountry());
		resDto.setPincode(customer.getPincode());
		resDto.setIdProof(customer.getIdProof());

		return resDto;
	}

	
	public List<CustomerResponseDto> toResponseByFullName(List<Customer> customers) {
	    List<CustomerResponseDto> list = new ArrayList<>();
	    for (Customer customer : customers) {
	        CustomerResponseDto resDto = new CustomerResponseDto();
	        resDto.setId(customer.getId());
	        resDto.setFullName(customer.getFullName());
	        list.add(resDto);
	    }
	    return list;
	}

}
