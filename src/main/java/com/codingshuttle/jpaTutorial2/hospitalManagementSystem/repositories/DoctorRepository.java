package com.codingshuttle.jpaTutorial2.hospitalManagementSystem.repositories;

import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}