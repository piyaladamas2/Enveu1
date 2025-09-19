package com.piyal.enveuproject.Service;

import org.springframework.stereotype.Service;

import com.piyal.enveuproject.Dto.RegisterResponse;
import com.piyal.enveuproject.Dto.RegisterRequest;

@Service
public interface AuthService {
  RegisterResponse register(RegisterRequest request);
}
