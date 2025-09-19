package com.piyal.enveuproject.Service;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.piyal.enveuproject.Dto.LoginRequest;
import com.piyal.enveuproject.Dto.LoginResponse;
import com.piyal.enveuproject.Dto.RegisterRequest;
import com.piyal.enveuproject.Dto.RegisterResponse;
import com.piyal.enveuproject.Entity.Role;
import com.piyal.enveuproject.Repository.RoleRepository;
import com.piyal.enveuproject.Repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

  private UserRepository userRepository;
  private RoleRepository roleRepository;

  @Override
  public RegisterResponse register(RegisterRequest request) {

    if(userRepository.findByEmail(request.getEmail())){
      throw new RuntimeException("Email Already registered");
    }
    
    // check if SUPER_USER exists
    boolean superAdminExists= userRepository.existsByRoles_Name("ROLE_SUPER_ADMIN");

    // Decide role 
    Role roleToAssign;

    if(!superAdminExists){
      roleToAssign=roleRepository.findByName("ROLE_SUPER_ADMIN").orElseThrow(()->new RuntimeException("SUPER_ADMIN role not found"));
    } else{
      roleToAssign=roleRepository.findByName("ROLE_USER").orElseThrow(()->new RuntimeException("USER role not found"));
    }
    User user=new User();
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setEnabled(true);
    user.setLocked(false);
    user.getRoles().add(roleToAssign);

    User savedUser=userRepository.save(user);

    return new RegisterResponse(
      savedUser.getId();
      savedUser.getEmail();
      savedUser.getFirstName();
      savedUser.getLastName();
      savedUser.getRoles().stream().map(Role::getName).toList();
    );
  }

  @Override
  public LoginResponse login(LoginRequest login) {

  }

}
