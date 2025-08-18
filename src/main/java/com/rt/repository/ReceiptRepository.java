package com.rt.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.rt.entity.Receipt;
@Repository
public interface ReceiptRepository extends CrudRepository<Receipt, Integer>{

}
