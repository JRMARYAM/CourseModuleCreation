package com.icanio.Training_Portal.DTO;

import lombok.Data;

@Data
public class SignInRequest {
    private String email;
    private String password;
}
