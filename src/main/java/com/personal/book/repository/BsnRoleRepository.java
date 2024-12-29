/*
 * This code is part of the book-social-network project.
 * Use of this code anywhere without the project owner's (https://github.com/Pratik-Zimbre) permission is prohibited.
 */
package com.personal.book.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.book.entity.BsnRole;

public interface BsnRoleRepository extends JpaRepository<BsnRole, Integer> {

	Optional<BsnRole> findByName(String role);
}
