package com.mfstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.mfstore.domain.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
