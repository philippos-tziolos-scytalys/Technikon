package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameOrEmail(String username, String email);


    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByTinNumber(Long tiNumber);

    User findByTinNumber(Long tinNumber);
    User findByEmail(String email);
    User findByUsername(String username);
}
