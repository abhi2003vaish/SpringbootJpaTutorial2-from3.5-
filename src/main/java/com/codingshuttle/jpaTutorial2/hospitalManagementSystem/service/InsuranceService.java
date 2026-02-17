package com.codingshuttle.jpaTutorial2.hospitalManagementSystem.service;


import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.Insurance;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.Patient;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.repositories.InsuranceRepository;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);  // dirty patient

        insurance.setPatient(patient);

        return insurance;

    }

    @Transactional
    public void deletePatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patientRepository.delete(patient);
    }


    @Transactional
    public Insurance updateInsuranceOfAPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);  // dirty patient

        insurance.setPatient(patient);

        return insurance;

    }


    @Transactional
    public Patient removeInsuranceOfAPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(null);//dirty patient

        return patient;
    }

}
