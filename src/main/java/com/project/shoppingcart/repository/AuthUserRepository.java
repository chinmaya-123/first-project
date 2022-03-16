package com.project.shoppingcart.repository;

import com.project.shoppingcart.entity.Address;
import com.project.shoppingcart.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {
   public AuthUser findByuserName(String userName);
}
