package com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity;
import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate birthdate;
    private String email;
    private String gender;

    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name="patient_insurance")
    private Insurance insurance;//own side

    @OneToMany(mappedBy = "patient")  //inverse side
    private List<Appointment> appointments=new ArrayList<>();
//    private Set<Appointment> appointments=new HashSet<>();

}
