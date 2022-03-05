package com.project.shoppingcart.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.shoppingcart.enumclass.Status;
import com.project.shoppingcart.enumclass.Type;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "consumer")
@Data
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password", updatable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", updatable = false)
    private Type userType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", updatable = true)
    private Status status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy ="consumer")
    /*@JoinTable(name = "user_address", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "address_id", referencedColumnName = "id")})*/
    //@JsonManagedReference
    private List<Address> address = new ArrayList();
}
