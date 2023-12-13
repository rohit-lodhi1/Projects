package com.portal.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.app.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

}
