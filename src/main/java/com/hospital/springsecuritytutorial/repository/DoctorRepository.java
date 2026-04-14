package com.hospital.springsecuritytutorial.repository;

import com.hospital.springsecuritytutorial.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}