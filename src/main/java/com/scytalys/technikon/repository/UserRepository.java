package com.scytalys.technikon.repository;

import com.scytalys.technikon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
