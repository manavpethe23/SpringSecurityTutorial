package com.hospital.springsecuritytutorial.controller;

import com.hospital.springsecuritytutorial.entity.Appointment;
import com.hospital.springsecuritytutorial.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final AppointmentService appointmentService;


}
