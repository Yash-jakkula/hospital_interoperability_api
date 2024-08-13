package com.example.hosipital_Interoperablitiy.patient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("api/patient")
public class PatientController {
    private static final Logger log = LoggerFactory.getLogger(PatientController.class);
    private final Patient patient;

    @Autowired
    public PatientController(Patient patient) {
        this.patient = patient;
    }

    @PostMapping("/addpatient")
    private ResponseEntity<String> addPatient(@RequestBody PatientSchema patientData){
        patient.save(patientData);
        return ResponseEntity.ok("user saved");
    }

    @GetMapping("/getpatient/{id}")
    private ResponseEntity<Optional<PatientSchema>> getPatient(@PathVariable Integer id){
        Optional<PatientSchema> patientInfo = patient.findById(id);
        if (patientInfo.isPresent()) {
            return ResponseEntity.ok(patientInfo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getallpatient")
    private ResponseEntity<Iterable<PatientSchema>>  getAllPatients(){
        Iterable<PatientSchema> patients = patient.findAll();
        return ResponseEntity.ok(patients);
    }

    @PutMapping("/removepatient/{id}")
    private ResponseEntity<Boolean> removePatient(@PathVariable Integer id){
        patient.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/update/{id}")
    private ResponseEntity<Boolean> updatePatient(@RequestBody PatientSchema patientData){
        patient.save(patientData);
        return ResponseEntity.ok(true);
    }
    @GetMapping("/removeallpatient")
    private ResponseEntity<Boolean> removeAllPatient(){
        patient.deleteAll();
        return ResponseEntity.ok(true);
    }

    @GetMapping("/getmetadata/{id}")
    public ResponseEntity<Optional<PatientSchema>> getMetaData(@PathVariable String id){
        Optional<PatientSchema> meta_data = patient.patient_meta_data(id);
        if(meta_data.isPresent()){
            return ResponseEntity.ok(meta_data);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }
    }

}


