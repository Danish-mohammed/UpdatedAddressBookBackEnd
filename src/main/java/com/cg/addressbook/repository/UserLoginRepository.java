package com.cg.addressbook.repository;

import java.util.Optional;

import com.cg.addressbook.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from user_tb where email= :email", nativeQuery = true)
    Optional<User> findByEmail(String email);

    @Query(value = "select * from user_tb where email= :email AND password= :password", nativeQuery = true)
    Optional<User> findByEmailIdAndPassword(String email, String password);

}