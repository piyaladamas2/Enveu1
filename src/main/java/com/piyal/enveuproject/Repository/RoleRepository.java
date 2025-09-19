package com.piyal.enveuproject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piyal.enveuproject.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(String name);
}
