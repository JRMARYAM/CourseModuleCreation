package com.icanio.Training_Portal.Service;


import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.HashSet;

public interface JwtService {
     String extractUsername(String token);
    String generateToken(UserDetails userDetails);

    boolean  isTokenValid(String token,UserDetails userDetails);
    String generateRefreshToken(HashMap<String, Object> extractClaims,UserDetails userDetails);



}
