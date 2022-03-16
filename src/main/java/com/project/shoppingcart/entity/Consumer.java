package com.project.shoppingcart.entity;

import com.project.shoppingcart.enumclass.UserStatus;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private AuthUser authUser1;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", updatable = true)
    private UserStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authUser")
    private List<Address> address = new ArrayList();
}
