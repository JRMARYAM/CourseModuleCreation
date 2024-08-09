package com.icanio.Training_Portal.Service.impl;

import com.icanio.Training_Portal.Service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {
    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSigninkey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getSigninkey(){
        byte[] key= Decoders.BASE64.decode("d3c019ee3209646a1c7f28568c051674021733b7776fca8ed45f2274dc059de1");
        return Keys.hmacShaKeyFor(key);
    }
    private <T> T extractClaims(String token, Function<Claims,T>claimResolvers){
        final Claims claims=extractAllClaims(token);
        return claimResolvers.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .setSigningKey(getSigninkey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public  String extractUsername(String token){
        return extractClaims(token,Claims::getSubject);
    }
    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername())&&!isTokenExpired(token));
    }


    public String generateRefreshToken(HashMap<String, Object> extractClaims,UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extractClaims).setSubject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+604800000))
                .signWith(getSigninkey(), SignatureAlgorithm.HS256)
                .compact();
    }


    private boolean isTokenExpired(String token){
        return extractClaims(token,Claims::getExpiration).before(new Date());
    }
}
