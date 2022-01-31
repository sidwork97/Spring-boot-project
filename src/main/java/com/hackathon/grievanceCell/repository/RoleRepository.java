package com.hackathon.grievanceCell.repository;

import java.util.Optional;

import com.hackathon.grievanceCell.models.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.grievanceCell.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
