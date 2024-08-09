package com.icanio.Training_Portal.Service;



import com.icanio.Training_Portal.DTO.JwtAuthenticationResponse;
import com.icanio.Training_Portal.DTO.RefreshTokenRequest;
import com.icanio.Training_Portal.DTO.SignInRequest;
import com.icanio.Training_Portal.DTO.SignUpRequest;
import com.icanio.Training_Portal.Entity.LoginUser;
import com.icanio.Training_Portal.Entity.Model;
import com.icanio.Training_Portal.Entity.Role;
import com.icanio.Training_Portal.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthenticationService {
    @Autowired
    public AuthenticationManager authenticationManager;
    @Autowired
    public LoginRepository userRepository;
    @Autowired
    public PasswordEncoder passwordEncoder;
    @Autowired
    public JwtService jwtService;
    public Model signup(SignUpRequest signUpRequest){
        LoginUser loginUser=new LoginUser();
        loginUser.setEmail(signUpRequest.getEmail());
        loginUser.setRole(Role.USER);
        loginUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        userRepository.save(loginUser);
        var jwt=jwtService.generateToken(loginUser);
        var refreshToken=jwtService.generateRefreshToken(new HashMap<>(),loginUser);
        Model model=new Model();
        model.setEmail(loginUser.getEmail());
        model.setPassword(signUpRequest.getPassword());
        model.setToken(jwt);
        model.setRefreshToken(refreshToken);
        return model;

    }
    public JwtAuthenticationResponse signin(SignInRequest signInRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken( signInRequest.getEmail(),
                signInRequest.getPassword()));
        var loginUser = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(()->new IllegalArgumentException("Invalid email or password"));
        var jwt=jwtService.generateToken(loginUser);
        var refreshToken=jwtService.generateRefreshToken(new HashMap<>(),loginUser);
        JwtAuthenticationResponse jwtAuthenticationResponse=new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;

    }
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){
        String useremail=jwtService.extractUsername(refreshTokenRequest.getToken());
        LoginUser loginUser=userRepository.findByEmail(useremail).orElseThrow();
        if(jwtService.isTokenValid(refreshTokenRequest.getToken(),loginUser)){
            var jwt=jwtService.generateToken(loginUser);
            JwtAuthenticationResponse jwtAuthenticationResponse=new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }

}

