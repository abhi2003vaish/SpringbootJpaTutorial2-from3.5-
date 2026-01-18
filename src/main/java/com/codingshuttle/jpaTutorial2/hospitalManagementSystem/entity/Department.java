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
public class Department{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100, unique=true)
    private String name;

    @OneToOne
    @JoinColumn(nullable=false)
    private Doctor headDoctor;

    @ManyToMany
    private Set<Doctor> doctors=new HashSet<>();
}
