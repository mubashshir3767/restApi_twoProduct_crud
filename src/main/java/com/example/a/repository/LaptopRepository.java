package com.example.a.repository;

import com.example.a.entity.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LaptopRepository extends JpaRepository<LaptopEntity,Integer> {
 Optional<LaptopEntity> findLaptopEntityByUserEntityId(int userId);
}
