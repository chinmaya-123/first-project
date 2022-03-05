package com.project.shoppingcart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Integer id;

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_address", joinColumns = {
            @JoinColumn(name = "address_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id") })
    @JsonBackReference*/
    @ManyToOne()
    @JoinColumn(name="consumer_id", nullable=false)
    private Consumer consumer;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private long postalCode;

    @Column(name = "mobile")
    private long mobile;
}

