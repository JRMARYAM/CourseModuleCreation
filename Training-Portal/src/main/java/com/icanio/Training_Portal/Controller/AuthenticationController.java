package com.icanio.Training_Portal.Controller;


import com.icanio.Training_Portal.DTO.JwtAuthenticationResponse;
import com.icanio.Training_Portal.DTO.RefreshTokenRequest;
import com.icanio.Training_Portal.DTO.SignInRequest;
import com.icanio.Training_Portal.DTO.SignUpRequest;
import com.icanio.Training_Portal.Entity.Model;
import com.icanio.Training_Portal.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
@Autowired
    public AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<Model> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signin(signInRequest));
    }
    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }


}

