package com.project.shoppingcart.repository;

import com.project.shoppingcart.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles,Integer> {

    public Roles getByName(String name);
}
