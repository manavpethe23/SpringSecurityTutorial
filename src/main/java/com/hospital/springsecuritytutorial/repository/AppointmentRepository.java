package com.hospital.springsecuritytutorial.repository;

import com.hospital.springsecuritytutorial.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}