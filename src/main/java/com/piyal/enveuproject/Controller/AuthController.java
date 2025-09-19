package com.piyal.enveuproject.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.piyal.enveuproject.Dto.RegisterResponse;
import com.piyal.enveuproject.Dto.RegisterRequest;
import com.piyal.enveuproject.Dto.LoginRequest;
import com.piyal.enveuproject.Dto.LoginResponse;
import com.piyal.enveuproject.Service.AuthService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("api/auth/register")
  public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
    return ResponseEntity.ok(authService.register(request));
  }

  @PostMapping("api/auth/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
    return ResponseEntity.ok(authService.login(request));
  }
}
