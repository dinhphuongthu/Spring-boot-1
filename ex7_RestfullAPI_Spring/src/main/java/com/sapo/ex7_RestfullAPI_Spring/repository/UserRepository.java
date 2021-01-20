package com.sapo.ex7_RestfullAPI_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapo.ex7_RestfullAPI_Spring.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    User findUserByUsername(String username);
    User findById(int id);
}
