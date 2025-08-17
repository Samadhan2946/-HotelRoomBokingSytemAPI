package com.rt.repository;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.annotations.Check;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rt.entity.Checkout;

@Repository
public interface CheckOutRepository extends CrudRepository<Checkout, Integer>{

}
