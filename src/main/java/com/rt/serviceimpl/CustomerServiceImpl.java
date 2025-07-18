package com.rt.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.dto.AddRoomsResponseDto;
import com.rt.dto.CustomerRequestDto;
import com.rt.dto.CustomerResponseDto;
import com.rt.entity.AddRooms;
import com.rt.entity.Customer;
import com.rt.mapper.CustomerMapper;
import com.rt.repository.CustomerRepository;
import com.rt.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean addCustomer(CustomerRequestDto customerRequestDto) {
		Customer customer= customerMapper.toEntity(customerRequestDto);

		boolean isAdded=customerRepository.save(customer) != null;
		return isAdded;
	}

	@Override
	public List<CustomerResponseDto> getCustomerList() {
		return customerMapper.listToResponse(customerRepository.findAll());
	}

	@Override
	public CustomerResponseDto getCustomerById(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);

		if (customer.isPresent()) {
			return customerMapper.toResponseById(customer.get());
		} else {
			return null;
		}
	}

	@Override
	public CustomerResponseDto updateCustomer(CustomerRequestDto customerRequestDto) {
	Customer customer	= customerMapper.toEntity(customerRequestDto);
	Customer	customer2 = customerRepository.save(customer);

		CustomerResponseDto customerResponseDto = customerMapper.toResponseById(customer2);
		
		return customerResponseDto;

	}

	@Override
	@Transactional
	public String deleteCustomer(Long id) {
		String added=customerRepository.deleteAllById(id);
		return added;
	}

}
