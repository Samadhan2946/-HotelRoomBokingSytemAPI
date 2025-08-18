package com.rt.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.dto.AddRoomsResponseDto;
import com.rt.dto.GenerateReceiptResponseDto;
import com.rt.dto.ReceiptRequestDto;
import com.rt.dto.ReceiptResponseDto;
import com.rt.entity.Receipt;
import com.rt.mapper.ReceiptMapper;
import com.rt.repository.CheckOutRepository;
import com.rt.repository.ReceiptRepository;
import com.rt.service.ReceiptService;

@Service
public class ReceiptServiceImpl implements ReceiptService {

	@Autowired
	private ReceiptMapper receiptMapper;

	@Autowired
	private CheckOutRepository checkOutRepository;

	@Autowired
	private ReceiptRepository receiptRepository;

	@Override
	public List<ReceiptResponseDto> getAllCheckOut() {
		return receiptMapper.listToResponse(checkOutRepository.findAll());

	}

	@Override
	public GenerateReceiptResponseDto generateReceiptAndRemoveCheckout(ReceiptRequestDto receiptRequestDto) {
		Receipt receipt = receiptMapper.toEntity(receiptRequestDto);
		Receipt savedReceipt = receiptRepository.save(receipt);

		GenerateReceiptResponseDto generateReceiptResponseDto = receiptMapper.tores(savedReceipt);
		return generateReceiptResponseDto;
	}

}
