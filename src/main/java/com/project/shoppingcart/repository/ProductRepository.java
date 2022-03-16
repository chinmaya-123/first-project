package com.project.shoppingcart.repository;

import com.project.shoppingcart.entity.Merchant;
import com.project.shoppingcart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Product getByName(String name);
    public Integer deleteByName(String name);
}
