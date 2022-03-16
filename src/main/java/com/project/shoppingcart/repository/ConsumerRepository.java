package com.project.shoppingcart.repository;

import com.project.shoppingcart.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {

     Consumer findByEmail(String email);
}
