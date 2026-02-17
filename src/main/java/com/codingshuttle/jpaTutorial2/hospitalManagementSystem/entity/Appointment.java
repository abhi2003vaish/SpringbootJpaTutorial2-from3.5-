package com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.util.Lazy;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private LocalDateTime appointmentTime;

    @Column(length=500)
    private String reason;

    @ManyToOne  //own side
    @JoinColumn(nullable=false)
    @ToString.Exclude
//    @JsonIgnore
    private Patient patient;

    @ManyToOne(fetch=FetchType.LAZY)  //own side
    @JoinColumn(nullable=false)
    @ToString.Exclude
    private Doctor doctor;







}
