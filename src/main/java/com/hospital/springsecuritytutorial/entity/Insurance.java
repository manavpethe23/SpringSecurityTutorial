package com.hospital.springsecuritytutorial.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String policyNumber;

    @Column( nullable = false, length = 100)
    private String provider;

    @Column( nullable = false, length = 100)
    private LocalDate validUntil;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "insurance")
    private Patient patient;
}
