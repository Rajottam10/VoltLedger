package io.voltledger.userservice.repositories;

import io.voltledger.userservice.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT u FROM Users u JOIN FETCH u.role JOIN FETCH u.status WHERE u.email = :email")
    Optional<Users> findByEmail(String email);
}
