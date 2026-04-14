package com.hospital.springsecuritytutorial.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Indexed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email",columnNames = {"email"})
        },
        indexes = {
                @Index(name = "idx_patient_birth_date",columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)
    private String name;


    private LocalDate birthDate;

    @Column(length = 100,nullable = false,unique = true)
    private String email;


    private String gender;

    @OneToOne
    @MapsId
    private User user;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

//    @Enumerated(EnumType.STRING)
//    private BloodGroupType bloodGroup;


    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments =  new ArrayList<Appointment>();

    public void setInsurance(Insurance insurance) {
    }
}
