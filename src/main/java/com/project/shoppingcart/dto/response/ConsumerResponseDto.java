package com.project.shoppingcart.dto.response;

import com.project.shoppingcart.entity.Address;
import lombok.Data;

import java.util.List;

@Data
public class ConsumerResponseDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Address> address;
}
