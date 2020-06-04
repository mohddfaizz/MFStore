package com.mfstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.mfstore.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
