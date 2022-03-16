package com.project.shoppingcart.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

    private String userName;
    private String password;

    public JwtRequest(String userName, String password)
    {
        this.userName=userName;
        this.password=password;
    }

    public JwtRequest()
    {

    }

}
