package com.icanio.Training_Portal.Repository;


import com.icanio.Training_Portal.Entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginUser,Integer> {
    Optional<LoginUser> findByEmail(String email);
}

