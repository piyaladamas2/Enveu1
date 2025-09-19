package com.piyal.enveuproject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piyal.enveuproject.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);

  boolean existsByRoles_Name(String roleName);
}
