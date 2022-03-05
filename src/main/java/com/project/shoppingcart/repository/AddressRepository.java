package com.project.shoppingcart.repository;

import com.project.shoppingcart.entity.Address;
import com.project.shoppingcart.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
