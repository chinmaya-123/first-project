package com.project.shoppingcart.repository;

import com.project.shoppingcart.entity.Address;
import com.project.shoppingcart.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query(value = "SELECT a.* FROM address a where a.user_id = :userId", nativeQuery = true)
    public List<Address> getByUserId(@Param("userId") int userId);
}
