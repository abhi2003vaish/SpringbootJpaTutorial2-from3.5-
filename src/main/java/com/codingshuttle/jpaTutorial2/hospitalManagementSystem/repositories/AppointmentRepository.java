package com.codingshuttle.jpaTutorial2.hospitalManagementSystem.repositories;

import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}