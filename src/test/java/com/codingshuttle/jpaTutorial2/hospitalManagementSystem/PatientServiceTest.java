package com.codingshuttle.jpaTutorial2.hospitalManagementSystem;

import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.dto.BloodGroupStats;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.dto.CPatientInfo;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.dto.IPatientInfo;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.Patient;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;


    @Test
    public void testPatient(){
        List<Patient> patientList=patientRepository.findAll();

        for(Patient p:patientList){
            System.out.println(p);
        }
    }

    @Test
    public void testPatient1(){
        List<IPatientInfo> patientList=patientRepository.getAllPatientInfo();

        for(IPatientInfo p:patientList){
            System.out.println("Td: "+p.getId()+" Name: "+p.getName()+" Email: "+p.getEmail());
        }
    }


    @Test
    public void testPatientConcrete(){
        List<CPatientInfo> patientList=patientRepository.getAllPatientsInfoConcrete();

        for(CPatientInfo p:patientList){
            System.out.println(p);
        }
    }

    @Test
    public void testPatientConcreteBloodGroupStats(){
        List<BloodGroupStats> patientList=patientRepository.getBloodGroupStats();

        for(BloodGroupStats p:patientList){
            System.out.println(p);
        }
    }

    @Test
    public void testPatientNameWithId(){
        int rowAffected=patientRepository.updatePatientNameWithId("Aloo",1L);
        System.out.println("Rows affected: "+rowAffected);
    }

}
