package com.project.shoppingcart.repository;

import com.project.shoppingcart.entity.Category;
import com.project.shoppingcart.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
}
