package com.project.shoppingcart.dto.response;

import java.io.Serializable;

public class JwtResponse  {

    private final String jwtToken;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getToken() {
        return this.jwtToken;
    }
}
