package com.codingshuttle.jpaTutorial2.hospitalManagementSystem.service;

import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.Appointment;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.Doctor;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.Patient;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.repositories.AppointmentRepository;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.repositories.DoctorRepository;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createANewAppointment(Appointment appointment, Long patientId, Long doctorId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointment;

    }

}
