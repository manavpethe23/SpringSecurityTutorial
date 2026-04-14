package com.hospital.springsecuritytutorial.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @MapsId
    private User user;


    @Column(length = 100)
    private String name;


    @Column(unique = true, length = 100)
    private String specification;


  @Column(length = 100,unique = true)
    private String email;

    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments = new HashSet<Department>();


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<Appointment>();
}
