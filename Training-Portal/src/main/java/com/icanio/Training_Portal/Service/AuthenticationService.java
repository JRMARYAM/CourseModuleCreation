package com.icanio.Training_Portal.Service;


import com.icanio.Training_Portal.DTO.JwtAuthenticationResponse;
import com.icanio.Training_Portal.DTO.RefreshTokenRequest;
import com.icanio.Training_Portal.DTO.SignInRequest;
import com.icanio.Training_Portal.DTO.SignUpRequest;
import com.icanio.Training_Portal.Entity.LoginUser;

public interface AuthenticationService {
    LoginUser signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
