package com.project.shoppingcart.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class MerchantRequestDto {

    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @Email
    private String email;
}
