package com.project.shoppingcart.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.shoppingcart.enumclass.UserStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "merchant")
@Data
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus status;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchant")
    @JsonManagedReference
    private List<Product> products = new ArrayList();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private AuthUser authUser;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authUser")
    @JsonManagedReference
    private List<Address> address = new ArrayList();
}
