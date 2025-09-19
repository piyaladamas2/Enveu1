package com.piyal.enveuproject.Service;

import org.springframework.stereotype.Service;

import com.piyal.enveuproject.Dto.RegisterResponse;
import com.piyal.enveuproject.Dto.LoginResponse;
import com.piyal.enveuproject.Dto.RegisterRequest;
import com.piyal.enveuproject.Dto.LoginRequest;

@Service
public interface AuthService {
  RegisterResponse register(RegisterRequest request);

  LoginResponse login(LoginRequest login);
}
