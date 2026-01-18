package com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100)
    private String name;

    @Column(length=100)
    private String specialization;

    @Column(length=100, unique=true, nullable=false)
    private String email;

    @OneToMany(mappedBy = "doctor")  //inverse side
    private Set<Appointment> appointments=new HashSet<>();
//    private List<Appointment> appointments=new ArrayList<>();

    @OneToOne(mappedBy = "headDoctor")
    private Department department;

    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments=new HashSet<>();
}
