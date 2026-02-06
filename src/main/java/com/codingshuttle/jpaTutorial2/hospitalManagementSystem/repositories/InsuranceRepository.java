package com.codingshuttle.jpaTutorial2.hospitalManagementSystem.repositories;

import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}