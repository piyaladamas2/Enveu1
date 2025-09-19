package com.piyal.enveuproject.Dto;

import lombok.Data;

@Data
public class RegisterResponse {
  private Long id;
  private String email;
  private String firstName;
  private String lastName;
  private String role;
  private boolean enabled;
  private boolean locked;

}
