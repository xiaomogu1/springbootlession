package com.staxrt.tutorial.repository;

import com.staxrt.tutorial.model.User;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

/**
 * The interface User repository.
 *
 * @author Givantha Kalansuriya
 */
@Repository
@ActiveProfiles("test")
public interface UserRepository extends JpaRepository<User, Long> {}
