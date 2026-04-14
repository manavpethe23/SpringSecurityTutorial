package com.hospital.springsecuritytutorial.repository;

import com.hospital.springsecuritytutorial.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}

