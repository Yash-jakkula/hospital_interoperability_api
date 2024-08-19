package com.example.hosipital_Interoperablitiy.patient;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/patient")
public class PatientMetaDataController {
    private final PatientMetaData patientMetaData;
    public PatientMetaDataController(PatientMetaData patientMetaData){
        this.patientMetaData = patientMetaData;
    }

    @PostMapping("/createmetadata")
    public ResponseEntity<String> createPatientMetaData(@RequestBody PatientMetaDataSchema patientmetadata){
        patientMetaData.save(patientmetadata);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/getmetadata/{id}")
    public ResponseEntity<Optional<PatientMetaDataSchema>> getMetaData(@PathVariable String id){

        Optional<PatientMetaDataSchema> meta = patientMetaData.find_meta_data(id);
        if(meta.isPresent()){
            return ResponseEntity.ok(meta);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }
    }


}
