package com.oauth.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oauth.server.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>
{

}
