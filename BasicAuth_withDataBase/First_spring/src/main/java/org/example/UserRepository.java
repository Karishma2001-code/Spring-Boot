package org.example;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByNameContainingIgnoreCase(String name);
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(String email);


}