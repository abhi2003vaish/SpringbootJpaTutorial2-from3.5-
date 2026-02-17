package com.codingshuttle.jpaTutorial2.hospitalManagementSystem.repositories;

import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.dto.BloodGroupStats;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.dto.CPatientInfo;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.dto.IPatientInfo;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query("select p.id as id , p.name as name, p.email as email from Patient p")
    List<IPatientInfo> getAllPatientInfo();


//    @Query("select new com.codingshuttle.jpaTutorial2.hospitalManagementSystem.dto.CPatientInfo(p.id, p.name) from Patient p")
//    OR   both are same
    @Query("select new com.codingshuttle.jpaTutorial2.hospitalManagementSystem.dto.CPatientInfo(p.id, p.name)" + "from Patient p")
    List<CPatientInfo> getAllPatientsInfoConcrete();


    @Query("select new com.codingshuttle.jpaTutorial2.hospitalManagementSystem.dto.BloodGroupStats(p.bloodGroup, " +
            "COUNT(p)) from Patient p group by p.bloodGroup order by COUNT(p) desc")
    List<BloodGroupStats> getBloodGroupStats();

    @Transactional
    @Modifying
    @Query("update Patient p set p.name= :name where p.id=:id")
    int updatePatientNameWithId(@Param("name") String name,@Param("id") Long id);


    //jpql query , join fetch to avoid n+1 problem
    @Query("select p from Patient p Left JOIN FETCH p.appointments")
    List<Patient> getAllPatientsWithAppointments();
}
