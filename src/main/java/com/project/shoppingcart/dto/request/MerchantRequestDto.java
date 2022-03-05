package com.project.shoppingcart.dto.request;

import com.project.shoppingcart.enumclass.Type;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MerchantRequestDto {

    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
