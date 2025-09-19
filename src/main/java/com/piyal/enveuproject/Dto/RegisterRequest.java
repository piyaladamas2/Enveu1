package com.piyal.enveuproject.Dto;

import lombok.Data;

@Data
public class RegisterRequest {
  private Long email;
  private String password;
  private String firstName;
  private String lastName;
}
