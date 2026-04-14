package com.hospital.springsecuritytutorial.controller;

import com.hospital.springsecuritytutorial.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

//    private final PatientService patientService;
//    private final doctorService doctorService;
//
//
//    @GetMapping("/patient")
//    public ResponseEntity<?> findAllPatients(
//            @RequestParam(value = "page", defaultValue = "0") Integer pageNumber,
//            @RequestParam(value = "size", defaultValue = "10") Integer pageSize
//    ) {
//
//        return ResponseEntity.ok(PatientService.getAllPatient(pageNumber, pageSize));
//    }

}

