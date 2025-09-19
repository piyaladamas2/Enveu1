package com.piyal.enveuproject.Service;

import org.springframework.stereotype.Service;

import com.piyal.enveuproject.Entity.User;
import com.piyal.enveuproject.Exception.UserNameNotFoundException;
import com.piyal.enveuproject.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUserName(String email) throws UserNameNotFoundException{
      @SuppressWarnings("unused")
      User user=userRepository.findByEmail(email).orElseThrow(()->new UserNameNotFoundException("User not found"));

      return new org.springframework.security.core.userDetails.User(
        user.getEmail();
        user.getPassword();
        user.getRoles().stream()
                .map(role->new SimpleGrantedAuthority(role.getName()))
                .toList();
      );
  }
}
