package com.example.a.repository;

import com.example.a.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>{
   Optional<UserEntity> findByPhoneNumber(String phoneNumber);
   UserEntity findById(int id);
}
