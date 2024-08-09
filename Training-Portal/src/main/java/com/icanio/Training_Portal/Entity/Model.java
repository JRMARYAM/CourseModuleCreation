package com.icanio.Training_Portal.Entity;

import lombok.Data;

@Data
public class Model {
    private String email;
    private String password;
    private String token;
    private String refreshToken;
}
