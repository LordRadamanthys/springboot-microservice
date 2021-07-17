package com.mateus.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.hruser.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
