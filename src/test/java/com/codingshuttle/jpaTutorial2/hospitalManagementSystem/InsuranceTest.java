package com.codingshuttle.jpaTutorial2.hospitalManagementSystem;

import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.Insurance;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testAssignInsuranceToPatient(){
        Insurance insurance=Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_236")
                .validUntil(LocalDate.of(2030,1,1))
                .build();

        var updatedInsurance=insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println("Updated Insurance: "+updatedInsurance);
//        insuranceService.deletePatient(1L);
    }

    @Test
    public void testDeletePatient(){
        insuranceService.deletePatient(1L);
    }

    @Test
    public void testRemoveInsuranceOfAPatient(){
        Insurance insurance=Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_236")
                .validUntil(LocalDate.of(2030,1,1))
                .build();

        var updatedInsurance=insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println("Updated Insurance: "+updatedInsurance);

        var patient=insuranceService.removeInsuranceOfAPatient(1L);
        System.out.println("Patient after removing insurance: "+patient);

    }
}
