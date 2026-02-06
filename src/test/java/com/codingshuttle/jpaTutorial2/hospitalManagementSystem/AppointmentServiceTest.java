package com.codingshuttle.jpaTutorial2.hospitalManagementSystem;

import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.Appointment;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.service.AppointmentService;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentServiceTest {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Test
    public void testCreateANewAppointment(){
        Appointment appointment= Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,2,15,10,30))
                .reason("Regular Checkup")
                .build();
        var updatedappointment = appointmentService.createANewAppointment(appointment,1L,2L);
        System.out.println("Updated Appointment: "+updatedappointment);

//        to check whether after adding the cascading at the patient ,after deleting the patient is all appointments are
//        also deleting or not

        patientService.deletePatient(1L);


    }

}
