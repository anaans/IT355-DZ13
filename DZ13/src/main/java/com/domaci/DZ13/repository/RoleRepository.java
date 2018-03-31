/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domaci.DZ13.repository;

import com.domaci.DZ13.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ana
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
