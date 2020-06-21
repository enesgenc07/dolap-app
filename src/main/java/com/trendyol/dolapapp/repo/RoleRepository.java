package com.trendyol.dolapapp.repo;

import com.trendyol.dolapapp.model.Role;
import com.trendyol.dolapapp.utility.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
