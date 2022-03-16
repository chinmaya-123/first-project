package com.project.shoppingcart.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="privileges")
@Data
public class Privileges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="privilege_name")
    private String name;

    @ManyToMany(mappedBy = "privileges")
    Set<Roles> roles=new HashSet<>();
}
