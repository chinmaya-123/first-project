package com.project.shoppingcart.dto.request;

import com.project.shoppingcart.entity.Address;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class ConsumerRequestDto {

    @NotBlank(message = " first name should not be empty..")
    @NotEmpty
    private String firstName;

    @NotBlank(message = " last name should not be empty..")
    @NotEmpty
    private String lastName;

    @NotBlank(message = " email  should not be empty..")
    @NotEmpty
    @Email
    private String email;

    @NotBlank(message = " password should not be empty ")
    @NotEmpty
    private String password;

   // private List<Address> addresses;

}
