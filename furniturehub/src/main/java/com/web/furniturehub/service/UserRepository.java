package com.web.furniturehub.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web.furniturehub.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
