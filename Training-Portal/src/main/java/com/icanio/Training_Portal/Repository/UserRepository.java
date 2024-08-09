package com.icanio.Training_Portal.Repository;


import com.icanio.Training_Portal.Entity.LoginUser;
import com.icanio.Training_Portal.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<LoginUser,Integer> {
    Optional<LoginUser> findByEmail(String email);
    LoginUser findByRole(Role role);
}
