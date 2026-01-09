package com.codingshuttle.jpaTutorial2.hospitalManagementSystem.service;


import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.Patient;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;


    public void testPatientTransactiom(){

        Patient p1=patientRepository.findById(1L).orElseThrow();
        Patient p2=patientRepository.findById(1L).orElseThrow();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1 == p2);

        p1.setName("Updated Name");

        System.out.println(p2);


    }
}
