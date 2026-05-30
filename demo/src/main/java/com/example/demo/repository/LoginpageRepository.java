package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LoginpageEntity;

public interface LoginpageRepository extends JpaRepository<LoginpageEntity, Long>{
	Optional<LoginpageEntity> findByEmail(String email);
	Optional<LoginpageEntity> findById(Long id);
	boolean existsByEmail(String email);
 

}