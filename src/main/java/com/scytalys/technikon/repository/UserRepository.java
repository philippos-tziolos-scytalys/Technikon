package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email OR u.username = :username OR u.tinNumber = :tinNumber")
    User findByEmailOrUsernameOrTinNumber(
            @Param("email") String email,
            @Param("username") String username,
            @Param("tinNumber") Long tinNumber
    );

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByTinNumber(Long tinNumber);

    User findByTinNumber(Long tinNumber);
    User findByEmail(String email);
}
