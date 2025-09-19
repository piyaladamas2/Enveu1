package com.piyal.enveuproject.Service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.piyal.enveuproject.Entity.Role;
import com.piyal.enveuproject.Entity.User;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

  @Value("${jwt.secret}")
  private String secretKey;

  @Value("${jwt.expiration}")
  private Long expiration;

  public String generateToken(User user) {
    return Jwts.builder()
        .setSubject(user.getEmail())
        .claim("roles", user.getRoles().stream().map(Role::getName).toList())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + expiration))
        .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
        .compact();
  }

  public boolean isTokenValid(String token) {
    try {
      Jwts.parserBuilder()
          .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
          .build()
          .parseClaimsJws(token);
      return true;
    } catch (JwtException | IllegalArgumentException e) {
      return false;
    }
  }

  // Extract Info from Token
  public String extractUsername(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
        .build()
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
  }

  public List<String> extractRoles(String token) {
    return (List<String>) Jwts.parserBuilder()
        .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
        .build()
        .parseClaimsJws(token)
        .getBody()
        .get("roles");
  }
}
