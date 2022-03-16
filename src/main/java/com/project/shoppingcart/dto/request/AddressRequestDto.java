package com.project.shoppingcart.dto.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class AddressRequestDto {
    private String address1;

    private String address2;

    @NotBlank(message = "enter country")
    private String country;

    @NotBlank(message = "enter city")
    private String city;

    @NotBlank(message = "enter state")
    private String state;

    /*@NotBlank(message = "enter the postal code")
    @Pattern(regexp = "(^$|[0-9]{6})")*/
    private long postalCode;

    /*@NotBlank
    @Pattern(regexp = "(^$|[0-9]{10})",message = "invalid mobile number")*/
    private long mobile;

}
