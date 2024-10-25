package com.example.deutschistent.repositories;

import com.example.deutschistent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.userName = :userName")
    Optional<User> findUserByUsername(@Param("userName") String userName);


    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    Optional<User> findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
