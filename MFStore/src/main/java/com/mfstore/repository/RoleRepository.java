package com.mfstore.repository;


import org.springframework.data.repository.CrudRepository;

import com.mfstore.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByname(String name);
}
