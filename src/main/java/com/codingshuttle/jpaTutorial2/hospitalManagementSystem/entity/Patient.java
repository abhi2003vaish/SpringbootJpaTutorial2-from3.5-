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
@ToString
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

//    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true , fetch =  FetchType.LAZY)
    @JoinColumn(name="patient_insurance")
//    @ToString.Exclude
    private Insurance insurance;  //own side


//Cascading is directional
//    @ToString.Exclude
    @OneToMany(mappedBy = "patient", cascade=CascadeType.ALL, fetch=FetchType.EAGER)  //inverse side
    private List<Appointment> appointments=new ArrayList<>();
//    private Set<Appointment> appointments=new HashSet<>();

}
